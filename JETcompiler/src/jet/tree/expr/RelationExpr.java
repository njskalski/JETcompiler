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

public class RelationExpr implements Expr {

	private final int Line;
	private final String Operator;
	private final Expr LeftHand;
	private final Expr RightHand;
	
	public RelationExpr(int _Line, String _Operator, Expr _LeftHand, Expr _RightHand)
	{
		Operator = _Operator;
		LeftHand = _LeftHand;
		RightHand = _RightHand;
		Line = _Line;
	}
	
	private TypeDescriptor PrecompiledType;
	private TypeDescriptor OperandType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		
		TypeDescriptor lht = LeftHand.getResultType(e);
		TypeDescriptor rht = RightHand.getResultType(e);
		
		
		if(!(lht.equals(IntegerType.Instance) ||
				lht.equals(FloatType.Instance)   ||
				lht.equals(DoubleType.Instance)))
				throw new ExpressionParsingException("Cannot apply " + Operator + " operator to type (first argument)" + lht, this.getLine());
		
		if(!(rht.equals(IntegerType.Instance) ||
				rht.equals(FloatType.Instance)   ||
				rht.equals(DoubleType.Instance)))
					throw new ExpressionParsingException("Cannot apply " + Operator + " operatorto type (second argument)" + rht, this.getLine());
		
		if(!lht.equals(rht))
			throw new ExpressionParsingException("Cannot compare two different types (no dynamic casting).", this.getLine());
		
		OperandType = lht;
		
		return PrecompiledType = BooleanType.Instance;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin RelationExpr:\n";
		
		String LHvalue = NameGenerator.getUniqueIdentifier();
		CResult cl = LeftHand.compute(e);
		code += cl.Code;
		code += LHvalue + " = load " + TypeTranslator.getTypeName(cl.ReturnValue.getType()) + "* " + cl.ReturnValue.getName() + "\n";
		
		String RHvalue = NameGenerator.getUniqueIdentifier();
		CResult cr = RightHand.compute(cl.Env);
		code += cr.Code;
		code += RHvalue + " = load " + TypeTranslator.getTypeName(cr.ReturnValue.getType()) + "* " + cr.ReturnValue.getName() + "\n";
		
		String retvalname = NameGenerator.getUniqueIdentifier();
		
		String ope = "ERROR";
		
		if(Operator.equals(">"))
		{
			if(OperandType.equals(IntegerType.Instance))
			{
				ope = "icmp sgt";
			}else if(OperandType.equals(FloatType.Instance) || PrecompiledType.equals(DoubleType.Instance))
			{
				ope = "fcmp ogt";
			}
		}
		else if(Operator.equals("<"))
		{
			if(OperandType.equals(IntegerType.Instance))
			{
				ope = "icmp slt";
			}else if(OperandType.equals(FloatType.Instance) || PrecompiledType.equals(DoubleType.Instance))
			{
				ope = "fcmp olt";
			}
		}
		else if(Operator.equals(">="))
		{
			if(OperandType.equals(IntegerType.Instance))
			{
				ope = "icmp sge";
			}else if(OperandType.equals(FloatType.Instance) || PrecompiledType.equals(DoubleType.Instance))
			{
				ope = "fcmp oge";
			}
		}
		else if(Operator.equals("<="))
		{
			if(OperandType.equals(IntegerType.Instance))
			{
				ope = "icmp slr";
			}else if(OperandType.equals(FloatType.Instance) || PrecompiledType.equals(DoubleType.Instance))
			{
				ope = "fcmp olr";
			}
		}
		code += retvalname + " = " + ope + " " + TypeTranslator.getTypeName(cr.ReturnValue.getType()) + " " + LHvalue + ", " + RHvalue + "\n";
		
		String resultname = NameGenerator.getUniqueIdentifier();
		String typename = TypeTranslator.getTypeName(BooleanType.Instance);
		
		code += resultname + " = alloca " + typename + "\n";
		code += "store " + typename + " " + retvalname + ", " + typename + "* " + resultname + "\n"; 
		code += ";!!end RelationExpr\n";
		
		return new CResult(cr.Env, code, new CReference(resultname, BooleanType.Instance));
	}

}
