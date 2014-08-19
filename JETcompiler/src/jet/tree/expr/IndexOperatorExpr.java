package jet.tree.expr;

import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.ArrayType;
import jet.types.FunctionType;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;

public class IndexOperatorExpr implements Expr {

	private final int Line;
	private final Expr Index;
	private final Expr Target;
	
	public IndexOperatorExpr(int _Line, Expr _Target, Expr _Index)
	{
		Index = _Index;
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
			
		if(!(TargetType instanceof ArrayType))
			throw new ExpressionParsingException("Index operator can be applied only to arrays, and instead " + TargetType + " was found", this.getLine()); 
		
		ArrayType at = (ArrayType) TargetType;
		
		TypeDescriptor IndexType = Index.getResultType(e);
		
		if(!(IndexType instanceof IntegerType))
			throw new ExpressionParsingException("Arrays can be indexed only with integer values, and instead a " + IndexType + " was found", this.getLine());
		
		return PrecompiledType = at.getSingleElementType();
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		CResult tcomp = Target.compute(e);
		e = tcomp.Env;
		
		CResult icomp = Index.compute(e);
		e = icomp.Env;
			
		String Code = ";!!begin IndexOperatorExpr:\n";
		Code += tcomp.Code;
		Code += icomp.Code;
		
		String tmpIndex = NameGenerator.getUniqueIdentifier();
		String tmpTarget = NameGenerator.getUniqueIdentifier();
		String result = NameGenerator.getUniqueIdentifier();
		
		
		Code += tmpIndex + " = load " + TypeTranslator.getTypeName(icomp.ReturnValue.getType()) + "* " + icomp.ReturnValue.getName() + "\n";
		Code += tmpTarget + " = load " + TypeTranslator.getTypeName(tcomp.ReturnValue.getType()) + "* " + tcomp.ReturnValue.getName() + "\n";
		Code += result + " = getelementptr " + TypeTranslator.getTypeName(PrecompiledType) + "* " + tmpTarget + ", i32 " + tmpIndex + "\n";
		Code +=  ";!!end IndexOperatorExpr\n";
		return new CResult(e, Code, new CReference(result, PrecompiledType));
	}

}
