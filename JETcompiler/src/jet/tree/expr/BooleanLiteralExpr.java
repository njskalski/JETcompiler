package jet.tree.expr;

import jet.Env;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.BooleanType;
import jet.types.TypeDescriptor;

public class BooleanLiteralExpr implements Expr {

	private final int Line;
	private final boolean Value;
	
	private TypeDescriptor PrecompiledType;
	
	public BooleanLiteralExpr(int _Line, String content)
	{
		Value = Boolean.parseBoolean(content);
		Line = _Line;
	}
	
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) {
		return PrecompiledType = BooleanType.Instance;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String name = NameGenerator.getUniqueIdentifier();
		String type = TypeTranslator.getTypeName(PrecompiledType);

		String Code = ";!!begin BooleanLiteral:\n";
		
		String x;
		if(Value) x = "1";
			else x = "0";
		
		Code += name + " = alloca " + type + "\n";
		Code += "store " + type + " " + x + ", "+ type + "* " + name + "\n";
		
		Code += ";!!end BooleanLiteral:\n";
		return new CResult(e, Code, new CReference(name, PrecompiledType));
	}

}
