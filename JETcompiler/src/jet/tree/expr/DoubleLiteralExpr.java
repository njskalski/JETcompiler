package jet.tree.expr;

import jet.Env;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.DoubleType;
import jet.types.TypeDescriptor;

public class DoubleLiteralExpr implements Expr {
	
	private final int Line;
	private final double Value;
	
	public DoubleLiteralExpr(int _Line, String content)
	{
		Value = Double.parseDouble(content.substring(0, content.length() -1));
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
		return PrecompiledType = DoubleType.Instance;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String name = NameGenerator.getUniqueIdentifier();
		String type = TypeTranslator.getTypeName(PrecompiledType);

		String Code = ";!!begin DoubleLiteral:\n";
		
		Code += name + " = alloca " + type + "\n";
		Code += "store " + type + " " + Double.toString(Value) + ", "+ type + "* " + name + "\n";
		
		Code += ";!!end DoubleLiteral:\n";
		
		return new CResult(e, Code, new CReference(name, PrecompiledType));
	}
}
