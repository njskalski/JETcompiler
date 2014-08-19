package jet.tree.expr;

import jet.Env;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.FloatType;
import jet.types.TypeDescriptor;

public class FloatLiteralExpr implements Expr {

	private final int Line;
	private final float Value;
	
	public FloatLiteralExpr(int _Line, String content)
	{
		Value = Float.parseFloat(content);
		Line = _Line;
	}
	
	private TypeDescriptor PrecompiledType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) {
		return PrecompiledType = FloatType.Instance;
	}

	//@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String name = NameGenerator.getUniqueIdentifier();
		String type = TypeTranslator.getTypeName(PrecompiledType);

		String Code = ";!!begin FloatLiteral:\n";
		
		Code += name + " = alloca " + type + "\n";
		Code += "store " + type + " " + Float.toString(Value) + ", "+ type + "* " + name + "\n";
		
		Code += ";!!end FloatLiteral:\n";
		
		return new CResult(e, Code, new CReference(name, PrecompiledType));
	}
}
