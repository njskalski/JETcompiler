package jet.tree.expr;

import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.types.ArrayType;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;

public class ArrayConstructorExpr implements Expr {

	private final int Line;
	private final TypeDescriptor ElementType;
	private final Expr AmountExpr;
	private TypeDescriptor PrecompiledType;
	

	public ArrayConstructorExpr(int _Line, TypeDescriptor _ElementType, Expr _AmountExpr)
	{
		ElementType = _ElementType;
		AmountExpr = _AmountExpr;
		Line = _Line;
	}
	
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		
		if(!(AmountExpr.getResultType(e).equals(IntegerType.Instance)))
			throw new ExpressionParsingException("Cannot declare array sized different that with an integer value", this.getLine()); 
		
		return PrecompiledType = new ArrayType(ElementType);
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		CResult ca = AmountExpr.compute(e);
		e = ca.Env;
				
		String code = ";!!begin ArrayConstructorExpr:\n";
		
		Malloc.Result mr = Malloc.GenerateArrayAllocation(ElementType, ca.ReturnValue.getName(), e);
		
		code += ca.Code;
		code += mr.Code;
		
		code += ";!!end ArrayConstructorExpr:\n";
		
		return new CResult(ca.Env, code, new CReference(mr.ValueName, PrecompiledType));
	}

}
