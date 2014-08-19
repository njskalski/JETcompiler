package jet.tree.expr;

import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.DoubleType;
import jet.types.FloatType;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;

public class MultExpr implements Expr {

	private final int Line;
	private final String Operator;
	private final Expr LeftHand;
	private final Expr RightHand;
	
	public MultExpr(int _Line, String _Operator, Expr _LeftHand, Expr _RightHand)
	{
		Operator = _Operator;
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
		
		TypeDescriptor lht = LeftHand.getResultType(e), rht = RightHand.getResultType(e);
		if(!(lht.equals(IntegerType.Instance) ||
				lht.equals(FloatType.Instance)   ||
				lht.equals(DoubleType.Instance)))
				throw new ExpressionParsingException("Cannot apply " + Operator + " operator to type (first argument)" + lht, this.getLine());
		
		if(!(rht.equals(IntegerType.Instance) ||
				rht.equals(FloatType.Instance)   ||
				rht.equals(DoubleType.Instance)))
					throw new ExpressionParsingException("Cannot apply " + Operator + " operatorto type (second argument)" + rht, this.getLine());
		
		if(!lht.equals(rht))
			throw new ExpressionParsingException("Cannot multiply two different types - \"" + lht + "\" and \"" + rht + "\", because there is no dynamic casting ", this.getLine());
		
		return PrecompiledType = lht;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin MultExpr:\n";
		
		String LHvalue = NameGenerator.getUniqueIdentifier();
		CResult cl = LeftHand.compute(e);
		code += cl.Code;
		code += LHvalue + " = load " + TypeTranslator.getTypeName(cl.ReturnValue.getType()) + "* " + cl.ReturnValue.getName() + "\n";
		
		String RHvalue = NameGenerator.getUniqueIdentifier();
		CResult cr = RightHand.compute(cl.Env);
		code += cr.Code;
		code += RHvalue + " = load " + TypeTranslator.getTypeName(cr.ReturnValue.getType()) + "* " + cr.ReturnValue.getName() + "\n";
		
		String resultname = NameGenerator.getUniqueIdentifier();
		
		String ope = "ERROR";
		
		//TODO dorobić te operatory
		if(Operator.equals("*"))
		{
			ope = "mul";
		}
		else if(Operator.equals("/"))
		{
			ope = "udiv";
		}
		else if(Operator.equals("%"))
		{
			ope = "urem";
		}
		
		String local_code = resultname + " = " + ope + " " + TypeTranslator.getTypeName(cr.ReturnValue.getType()) + " " + LHvalue + ", " + RHvalue + "\n";

		String retvalname = NameGenerator.getUniqueIdentifier();

		String typename = TypeTranslator.getTypeName(PrecompiledType);
		
		local_code += retvalname + " = alloca " + typename + "\n";
		local_code += "store " + typename + " " + resultname + ", " + typename + "* " + retvalname + "\n"; 
		code += local_code;
		
		code += ";!!end MultExpr\n";
		
		return new CResult(cr.Env, code, new CReference(retvalname, PrecompiledType));
	}

}
