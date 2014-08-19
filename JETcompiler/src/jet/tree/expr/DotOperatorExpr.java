package jet.tree.expr;

import jet.Env;
import jet.EnvLookupException;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.tree.ClassDefinition;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class DotOperatorExpr implements Expr {
	
	private final int Line;
	private final Expr Target;
	private final Expr FieldName;
	
	public DotOperatorExpr(int _Line, Expr _Target, Expr _FieldName)
	{
		Target = _Target;
		FieldName = _FieldName;
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
		
		TypeDescriptor LEFT = Target.getResultType(e);
		
		if(!(LEFT instanceof NamedType)) throw new ExpressionParsingException("Cannot apply dot operator to non-class object, and this one is of type \"" + LEFT + "\".", this.getLine());
		
		NamedType ClassType = (NamedType)LEFT;
		
//		if(!e.isDeclaredClass(ClassType.getName()))
//			throw new ExpressionParsingException("Cannot find class definition for \"" + ClassType.getName() + "\".", this.getLine());

		ClassDefinition CD;
		try {
			CD = e.getClassDefinition(ClassType.getName());
		} catch (EnvLookupException e1) {
			throw new ExpressionParsingException(e1.getMessage(), this.getLine());
		}
		
		Env local = e.createSubEnv();
		
		try {
			local = CD.getInsideTheClass(local);
		} catch (Exception e1) {
			throw new ExpressionParsingException("Cannot get into class env, because " + e1, this.getLine());
		}
		
		return PrecompiledType = FieldName.getResultType(local);
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {		
		String Code = ";!!begin DotOperaorExpr:\n";
		
		CResult lh = Target.compute(e);
		
		Code += lh.Code;
		
		CEnv local = lh.Env.createSubEnv();
		local.setThis(lh.ReturnValue);
		
		CResult rh = FieldName.compute(local);
		
		Code += rh.Code;
		
		Code += ";!!end DotOperatorExpr\n";
		
		return new CResult(e, Code, rh.ReturnValue);
	}
}
