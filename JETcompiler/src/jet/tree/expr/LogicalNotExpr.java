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

public class LogicalNotExpr implements Expr{

	private final int Line;
	private final Expr Target;
	
	public LogicalNotExpr(int _Line, Expr _Target)
	{
		Target = _Target;
		Line = _Line;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		if(!(Target.getResultType(e).equals(BooleanType.Instance)))
			throw new ExpressionParsingException("Logical NOT expression can be applied only to boolean value, and a value of \"" + Target.getResultType(e) + "\" type is found.", this.getLine() );
		
		return PrecompiledType = BooleanType.Instance;
	}
	
	private TypeDescriptor PrecompiledType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin LogicalNot:\n";
		
		CResult comp = Target.compute(e);
		e = comp.Env;
		
		String valname = NameGenerator.getUniqueIdentifier();
		String valtypename = TypeTranslator.getTypeName(comp.ReturnValue.getType());
		String resultname = NameGenerator.getUniqueIdentifier();
		
		code += comp.Code;
		code += valname + " = load " + valtypename + "* " + comp.ReturnValue.getName() + "\n";
		
		String tmp = NameGenerator.getUniqueIdentifier();
		
		code += tmp + " = xor " + valtypename + " 1, " + valname + "\n";
		code += resultname + " = alloca " + valtypename + "\n";
		
		code += "store " + valtypename + " " + tmp + ", " + valtypename + "* " + resultname;
		code += ";!!end LogicalNot\n";
		return new CResult(e, code, new CReference(resultname, BooleanType.Instance));
	}

}
