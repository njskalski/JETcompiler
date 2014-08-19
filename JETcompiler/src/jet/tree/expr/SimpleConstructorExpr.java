package jet.tree.expr;

import java.util.ArrayList;
import java.util.List;

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
import jet.tree.ConstructorDefinition;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class SimpleConstructorExpr implements Expr{
	private final int Line;
	private final TypeDescriptor NewElementType;
	private final List<Expr> ConstructorArguments;
	
	private NamedType PrecompiledNamedType;
	//private ConstructorDefiniton PrecompiledConstructorDefinition;
	
	public SimpleConstructorExpr(int _Line, TypeDescriptor _NewElementType, List<Expr> _ConstructorArguments)
	{
		NewElementType = _NewElementType;
		if(_ConstructorArguments != null)
			ConstructorArguments = _ConstructorArguments;
		else
			ConstructorArguments = new ArrayList<Expr>(); 
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
		
		for(Expr expr : ConstructorArguments)
			expr.getResultType(e);
		
		if(NewElementType instanceof NamedType)
		{
			NamedType NET = (NamedType)NewElementType;
			if(!e.isDeclaredClass(NET.getName()))
				throw new ExpressionParsingException("Cannot find class definition for \"" + NET.getName() + "\"", this.getLine());
			
			PrecompiledNamedType = NET;
			
			ClassDefinition CD;
			try {
				CD = e.getClassDefinition(NET.getName());
			} catch (EnvLookupException e1) {
				throw new ExpressionParsingException(e1.getMessage(), this.getLine());
			}
			
			List<ConstructorDefinition> CCs = CD.getConstructors();
			
			ConstructorDefinition working = null;
			List<TypeDescriptor> ArgumentTypes = new ArrayList<TypeDescriptor>();
			for(Expr expr : ConstructorArguments)
			{
				ArgumentTypes.add(expr.getResultType(e));
			}
			
			for(ConstructorDefinition cd : CCs)
			{
				if(cd.doesArgumentListMatch(ArgumentTypes))
				{
					working = cd;
					break;
				}
			}
			
			if(working == null)
				throw new ExpressionParsingException("Cannot find a proper constructor for \"" + NET.getName() + "\".", this.getLine());
		}
		else throw new ExpressionParsingException("INTERNAL ERROR", this.getLine());
		
		return PrecompiledType = NewElementType;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		
		String Code = ";!!begin SimpleConstructorExpr\n";
		
		Malloc.Result mr = Malloc.GenerateSingleAllocation(NewElementType, e);
		
		Code += mr.Code;
		
		List<String> argIds = new ArrayList<String>();
		for(int i = 0 ; i < ConstructorArguments.size(); ++i)
			argIds.add(NameGenerator.getUniqueIdentifier());
		
		List<CResult> argComp = new ArrayList<CResult>();
		for(int i = 0 ; i < ConstructorArguments.size(); ++i)
		{
			argComp.add(ConstructorArguments.get(i).compute(e));
			e = argComp.get(i).Env;
		}
		
		for(int i = 0 ; i < ConstructorArguments.size(); ++i)
		{
			Code += argComp.get(i).Code;
			Code += argIds.get(i) + " = load " + TypeTranslator.getTypeName(argComp.get(i).ReturnValue.getType()) + "* " + argComp.get(i).ReturnValue.getName() + "\n";
		}
		
		Code += "call void " + TypeTranslator.getClassConstructorName(PrecompiledNamedType.getName()) + "(";
		Code += TypeTranslator.getClassTypeName(PrecompiledNamedType.getName()) + "* " + mr.ValueName;
		
		if(ConstructorArguments.size() > 0)
			Code += ", ";
			
		for(int i = 0 ; i < ConstructorArguments.size(); ++i)
		{
			Code += TypeTranslator.getTypeName(argComp.get(i).ReturnValue.getType()) + " " + argIds.get(i);
			if(i < ConstructorArguments.size() - 1)
				Code += ", ";
		}
		Code += ")\n";
		
		Code += ";!!end SimpleConstructorExpr\n";
		
		return new CResult(e, Code, new CReference(mr.ValueName, NewElementType));
	}

}
