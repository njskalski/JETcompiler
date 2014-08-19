package jet.tree.expr;

import jet.Env;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;

public class IntegerLiteralExpr implements Expr {

	private final int Line;
	private final int Value;
	
	public IntegerLiteralExpr(int _Line, String content)
	{
		Value = Integer.parseInt(content);
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
		return PrecompiledType = IntegerType.Instance;
	}
	
	//@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String name = NameGenerator.getUniqueIdentifier();
		String type = TypeTranslator.getTypeName(PrecompiledType);

		String Code = ";!!begin IntegerLiteral:\n";
		
		Code += name + " = alloca " + type + "\n";
		Code += "store " + type + " " + Integer.toString(Value) + ", "+ type + "* " + name + "\n";
		
		Code += ";!!end IntegerLiteral:\n";
		
		return new CResult(e, Code, new CReference(name, PrecompiledType));
	}
}
