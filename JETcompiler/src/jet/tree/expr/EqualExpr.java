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
import jet.types.DoubleType;
import jet.types.FloatType;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;

public class EqualExpr implements Expr {

	private final String Operator;
	private final Expr LeftHand;
	private final Expr RightHand;
	
	public EqualExpr(String _Operator, Expr _LeftHand, Expr _RightHand)
	{
		Operator = _Operator;
		LeftHand = _LeftHand;
		RightHand = _RightHand;
	}
	
	private TypeDescriptor PrecompiledType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		if(!LeftHand.getResultType(e).equals(RightHand.getResultType(e)))
			throw new ExpressionParsingException("cannot compare two different types: \"" + LeftHand.getResultType(e) +
						"\" and \"" + RightHand.getResultType(e) + "\"", this.getLine());
			
		return PrecompiledType = BooleanType.Instance;
	}

	@Override
	public int getLine() {
		return LeftHand.getLine();
		
		//TODO zwracam left-hand'a
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		
		String code = ";!!begin EqualExpr:\n";	
		
		String LHvalue = NameGenerator.getUniqueIdentifier();
		CResult cl = LeftHand.compute(e);
		code += cl.Code;
		code += LHvalue + " = load " + TypeTranslator.getTypeName(cl.ReturnValue.getType()) + "* " + cl.ReturnValue.getName() + "\n";
		
		String RHvalue = NameGenerator.getUniqueIdentifier();
		CResult cr = RightHand.compute(cl.Env);
		code += cr.Code;
		code += RHvalue + " = load " + TypeTranslator.getTypeName(cr.ReturnValue.getType()) + "* " + cr.ReturnValue.getName() + "\n";
		
		String local_code = "";
		String retvalname = NameGenerator.getUniqueIdentifier();
		
		String op;
		if(Operator.equals("!="))
			op = "ne";
		else op = "eq";
		
		if(cl.ReturnValue.getType().equals(IntegerType.Instance))
		{
			local_code += retvalname + " = icmp " + op + " i32 " + LHvalue + ", " + RHvalue + "\n";
		}else if (cl.ReturnValue.getType().equals(BooleanType.Instance))
		{
			local_code += retvalname + " = icmp " + op + TypeTranslator.getTypeName(BooleanType.Instance) + LHvalue + ", " + RHvalue + "\n";
		}else if (cl.ReturnValue.getType().equals(FloatType.Instance))
		{
			local_code += retvalname + " = fcmp o" + op + " float " + LHvalue + ", " + RHvalue + "\n";
		}else if (cl.ReturnValue.getType().equals(DoubleType.Instance))
		{
			local_code += retvalname + " = fcmp o" + op + " double " + LHvalue + ", " + RHvalue + "\n";
		}
		
		String resultname = NameGenerator.getUniqueIdentifier();

		String typename = TypeTranslator.getTypeName(PrecompiledType);
		
		local_code += resultname + " = alloca " + typename + "\n";
		local_code += "store " + typename + " " + retvalname + ", " + typename + "* " + resultname + "\n"; 
		
		code += local_code;
		code += ";!!end EqualExpr:\n";
		
		return new CResult(cr.Env, code, new CReference(resultname, PrecompiledType));
	}

}
