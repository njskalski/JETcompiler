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

public class UnaryMinusExpr implements Expr {

	private final int Line;
	private final Expr Target;
	
	public UnaryMinusExpr(int _Line, Expr _Target)
	{
		Target = _Target;
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
		TypeDescriptor TargetType = Target.getResultType(e);
		
		if(!(TargetType.equals(IntegerType.Instance) ||
			 TargetType.equals(FloatType.Instance)   ||
			 TargetType.equals(DoubleType.Instance)))
			throw new ExpressionParsingException("Cannot apply unary minus to type " + TargetType, this.getLine());
		
		return PrecompiledType = TargetType;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin UnaryMinus:\n";
		
		CResult comp = Target.compute(e);
		e = comp.Env;
		code += comp.Code;
		
		String valname = NameGenerator.getUniqueIdentifier();
		String resname = NameGenerator.getUniqueIdentifier();
		String valtypename = TypeTranslator.getTypeName(comp.ReturnValue.getType());
		
		code += valname + " = load " + valtypename + "* " + comp.ReturnValue.getName() + "\n";
		code += resname + " = alloca " + valtypename + "\n";
		String tmp = NameGenerator.getUniqueIdentifier();
		
		String oper = "ERROR", zero = "ERROR";
		if(PrecompiledType.equals(IntegerType.Instance))
		{
			oper = "sub";
			zero = "0";
		}else if(PrecompiledType.equals(FloatType.Instance) || PrecompiledType.equals(DoubleType.Instance))
		{
			oper = "fsub";
			zero = "0.0";
		}else throw new ComputationException("Wrong type");
		
		code += tmp + " = " + oper + " " + valtypename + " " + zero + ", " + valname + "\n";
		
		code += "store " + valtypename + " " + tmp + ", " + valtypename + "* " + resname + "\n";
		code += ";!!end UnaryMinusExpr\n";
		
		return new CResult(e, code, new CReference(resname, PrecompiledType));
	}

}
