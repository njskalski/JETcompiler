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

public class SuffixIncDecExpr implements Expr {

	private final int Line;
	private final String Operator;
	private final Expr Target;
	
	public SuffixIncDecExpr(int _Line, String _operator, Expr _target)
	{
		Operator = _operator;
		Target = _target;
		Line = _Line;
		
		assert(Operator.equals("--") || Operator.equals("++"));
		assert(Target != null);
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
		
		if(!(TargetType.equals(IntegerType.Instance)))
			throw new ExpressionParsingException("Cannot apply suffix inc/dec operator to type " + TargetType, this.getLine());
		
		return PrecompiledType = TargetType;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = ";!!begin SuffixIncDecExpr:\n";
		
		CResult comp = Target.compute(e);
		e = comp.Env;
		
		String valname = NameGenerator.getUniqueIdentifier();
		String valtypename = TypeTranslator.getTypeName(comp.ReturnValue.getType());
		
		String resultname = NameGenerator.getUniqueIdentifier();
		code += resultname + " = alloca " + valtypename;
		
		code += valname + " = load " + valtypename + "* " + comp.ReturnValue.getName() + "\n";
		
		String tmp = NameGenerator.getUniqueIdentifier();
		String ope = "ERROR";
		
		if(this.Operator.equals("--"))
			ope = "sub";
		else if (this.Operator.equals("++"))
			ope = "add";
		
		code += tmp + " = " + ope + " " + TypeTranslator.getTypeName(comp.ReturnValue.getType()) + " " + valname + ", 1\n";
		
		code += "store " + valtypename + " " + tmp + ", " + valtypename + "* " + comp.ReturnValue.getName() + "\n";
		code += "store " + valtypename + " " + valname + ", " + valtypename + "* " + resultname + "\n"; 
		code += ";!!end SuffixIncDecExpr\n";
		return new CResult(e, code, new CReference(resultname, IntegerType.Instance));
	}
	
}
