package jet.tree.expr;

import jet.Env;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.IntegerType;
import jet.types.StringType;
import jet.types.TypeDescriptor;

public class StringLiteralExpr implements Expr {

	private final int Line;
	private final String Text;
	
	public StringLiteralExpr(int _Line, String content)
	{
		Text = content.substring(1, content.length() -1).replace("\\", "\\\\");
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
		return PrecompiledType = StringType.Instance;
	}

	//@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		
		String Code = ";!!begin StringLiteral:\n";
		Malloc.Result mr = Malloc.GenerateStringAllocation(Text, e);
		
		String temp = NameGenerator.getUniqueIdentifier();
		
		Code += mr.Code;
		Code += temp + " = bitcast i8* " + mr.ValueName + " to [" + (Text.length() + 1) + " x i8]*\n";
		Code += "store [" + (Text.length() + 1) + " x i8] " + "c\"" + Text + "\\00\", [" + (Text.length() + 1) + " x i8]* " + temp + "\n";
		
		String result = NameGenerator.getUniqueIdentifier();
		String type = TypeTranslator.getTypeName(StringType.Instance);
		
		Code += result + " = alloca " + type + "\n";
		Code += "store " + type + " " + mr.ValueName + ", " + type + "* " + result + "\n";
		
		Code += ";!!end StringLiteral\n";
		return new CResult(e, Code, new CReference(result, StringType.Instance));
	}

}
