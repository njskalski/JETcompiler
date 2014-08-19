package jet.tree.expr;

import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.BooleanType;
import jet.types.TypeDescriptor;

public class LogicalOrExpr implements Expr {
	
	private final int Line;
	private final Expr LeftHand;
	private final Expr RightHand;
	
	public LogicalOrExpr(int _Line, Expr _LeftHand, Expr _RightHand)
	{
		LeftHand = _LeftHand;
		RightHand = _RightHand;
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
		
		if(!(LeftHand.getResultType(e).equals(BooleanType.Instance)))
			throw new ExpressionParsingException("Logical OR expression can be applied only to boolean values, and left-hand is a type of \"" + LeftHand.getResultType(e) + "\".", this.getLine() );

		if(!(RightHand.getResultType(e).equals(BooleanType.Instance)))
			throw new ExpressionParsingException("Logical OR expression can be applied only to boolean values, and right-hand is a type of \"" + RightHand.getResultType(e) + "\".", this.getLine() );
		
		return PrecompiledType = BooleanType.Instance;
	}
	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin LogicalOrExpr:\n";
		
		String typename = TypeTranslator.getTypeName(BooleanType.Instance);
		
		String LHvalue = NameGenerator.getUniqueIdentifier();
		CResult cl = LeftHand.compute(e);
		code += cl.Code;
		code += LHvalue + " = load " + typename + "* " + cl.ReturnValue.getName() + "\n";
		
		String RHvalue = NameGenerator.getUniqueIdentifier();
		CResult cr = RightHand.compute(cl.Env);
		code += cr.Code;
		code += RHvalue + " = load " + typename + "* " + cr.ReturnValue.getName() + "\n";
		
		String retval = NameGenerator.getUniqueIdentifier();
		String resultname = NameGenerator.getUniqueIdentifier();
		
		code += retval + " = or " + typename + " " + LHvalue + ", " + RHvalue + "\n";
		code += resultname + " = alloca " + typename + "\n";
		code += "store " + typename + " " + retval + ", " + typename + "* " + resultname + "\n"; 
		
		code += ";!!end LogicalOrExpr\n";
		
		return new CResult(cr.Env, code, new CReference(resultname , PrecompiledType));
	}

}
