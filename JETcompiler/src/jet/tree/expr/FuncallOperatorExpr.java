package jet.tree.expr;

import jet.Env;
import jet.EnvLookupException;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.tree.ClassDefinition;
import jet.tree.FunctionDefinition;
import jet.types.FunctionType;
import jet.types.TypeDescriptor;
import jet.types.VoidType;

import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;

public class FuncallOperatorExpr implements Expr {

	private final int Line;
	private final List<Expr> Arguments;
	private final Expr FunctionIdentifier;
	
	private String PrecompiledName;
	private FunctionType PrecompiledFunctionType;
	private FunctionDefinition PrecompiledFunctionDefinition;
	
	public FuncallOperatorExpr(int _Line, List<Expr> _Arguments, Expr _FunctionIdentifier)
	{
		
		if(_Arguments == null)
			Arguments = new ArrayList<Expr>();
		else
			Arguments = _Arguments;
		
		FunctionIdentifier = _FunctionIdentifier;
		Line = _Line;
	}
	
	private TypeDescriptor PrecompiledType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		
		if(!(FunctionIdentifier instanceof IdentifierExpr))
			throw new ExpressionParsingException("Function call operator can be applied only to functions, so an identifier is expected", this.getLine());
		
		IdentifierExpr funid = (IdentifierExpr)FunctionIdentifier;
		
		String funname = funid.getFieldName();
		PrecompiledName = funname;
		
//		if(!(e.isDeclaredFunction(funname)))
//				throw new ExpressionParsingException("Identifier \"" + funname + "\" is undeclared.", this.getLine());

		TypeDescriptor funtype;
		try {
			funtype = e.getTypeOf(funname);
			PrecompiledFunctionDefinition = e.getFunctionDefinition(funname);
		} catch (EnvLookupException e1) {
			throw new ExpressionParsingException(e1.getMessage(), this.getLine());
		}
		
		if(!(funtype instanceof FunctionType))
			throw new ExpressionParsingException("function call operator can be applied only to functions, and instead " + funtype + " was found", this.getLine()); 
		
		FunctionType ff = (FunctionType) funtype;
		PrecompiledFunctionType = ff;
		
		
		if((ff.getArgumentTypes().size() != Arguments.size()))
			throw new ExpressionParsingException("function \"" + funname + "\" expects " + ff.getArgumentTypes().size() + " arguments, and " + Arguments.size() + " were provided", this.getLine());
		
		List<TypeDescriptor> argument_types = new ArrayList<TypeDescriptor>();
		for(int i = 0 ; i < Arguments.size() ; ++i)
			argument_types.add(Arguments.get(i).getResultType(e));
		
		for(int i = 0 ; i < Arguments.size() ; ++i)
			if(!ff.getArgumentTypes().get(i).equals(argument_types.get(i)))
				throw new ExpressionParsingException("invalid argument type for function \"" + funname + "\". Expecting \"" + ff.getArgumentTypes().get(i) + "\" and instead \"" + argument_types.get(i) + "\" was provided", this.getLine());
		
		return PrecompiledType = ff.getReturnType();
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {		
		String Code = ";!!begin FuncallOperatorExpr:\n";
		
		List<String> argIds = new ArrayList<String>();
		for(int i = 0 ; i < Arguments.size(); ++i)
			argIds.add(NameGenerator.getUniqueIdentifier());
		
		CEnv argloc = e.createSubEnv();
		argloc.setThis(null);
		// to jest najobrzydliwszy hack na swiecie - przyslaniam thisa, zeby sie ident expr w arg liczyly przez lookup
		
		List<CResult> argComp = new ArrayList<CResult>();
		for(int i = 0 ; i < Arguments.size(); ++i)
		{
			argComp.add(Arguments.get(i).compute(argloc));
			argloc = argComp.get(i).Env;
		}
		
		for(int i = 0 ; i < Arguments.size(); ++i)
		{
			Code += argComp.get(i).Code;
			Code += argIds.get(i) + " = load " + TypeTranslator.getTypeName(argComp.get(i).ReturnValue.getType()) + "* " + argComp.get(i).ReturnValue.getName() + "\n";
		}
		
		if(PrecompiledFunctionType.getReturnType().equals(VoidType.Instance))
		{
			Code += "call void " + e.getFunctionName(PrecompiledName) + "(";
			
			if(PrecompiledFunctionDefinition.getOwner() != null)
			{
				ClassDefinition owner = PrecompiledFunctionDefinition.getOwner();
				
				Code += TypeTranslator.getClassTypeName(owner.getName()) + "* " + e.getThis().getName();
				if(Arguments.size() > 0)
					Code += ", ";
			}
			
			for(int i = 0 ; i < Arguments.size(); ++i)
			{
				Code += TypeTranslator.getTypeName(argComp.get(i).ReturnValue.getType()) + " " + argIds.get(i);
				if(i < Arguments.size() - 1)
					Code += ", ";
			}
			Code += ")\n";
			
			Code += ";!!end FuncalOperatorExpr\n";
			return new CResult(e, Code, null);
		}
		else
		{
			String funcallres = NameGenerator.getUniqueIdentifier();
			Code += funcallres + " = call " + TypeTranslator.getTypeName(PrecompiledFunctionType.getReturnType()) + " " + e.getFunctionName(PrecompiledName) + "(";
			
			if(PrecompiledFunctionDefinition.getOwner() != null)
			{
				ClassDefinition owner = PrecompiledFunctionDefinition.getOwner();
				
				Code += TypeTranslator.getClassTypeName(owner.getName()) + "* " + e.getThis().getName();
				if(Arguments.size() > 0)
					Code += ", ";
			}
			
			for(int i = 0 ; i < Arguments.size(); ++i)
			{
				Code += TypeTranslator.getTypeName(argComp.get(i).ReturnValue.getType()) + " " + argIds.get(i);
				if(i < Arguments.size() - 1)
					Code += ", ";
			}
			
			Code += ")\n";
			Code += ";!!end FuncalOperatorExpr\n";
			
			String result = NameGenerator.getUniqueIdentifier();
			String type = TypeTranslator.getTypeName(PrecompiledFunctionType.getReturnType());
			Code += result + " = alloca " + type + "\n";
			Code += "store " + type + " " + funcallres + ", "+ type + "* " + result + "\n";
			
			return new CResult(e, Code, new CReference(result, PrecompiledFunctionType.getReturnType()));
		}
	}
}
