package jet.tree.expr;

import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.TypeDescriptor;

public class AssignmentExpr implements Expr {

	private final String Operator;
	private final Expr LeftHand;
	private final Expr RightHand;
	private TypeDescriptor PrecompiledType;
	
	public AssignmentExpr(String _Operator, Expr _LeftHand, Expr _RightHand)
	{
		Operator = _Operator;
		LeftHand = _LeftHand;
		RightHand = _RightHand;
	}
	
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		
		//TODO obsługa testów dla operatorów przypisania arytmetycznego.
		
		TypeDescriptor LHT = LeftHand.getResultType(e);
		TypeDescriptor RHT = RightHand.getResultType(e);
		if(!(LHT.equals(RHT)))
			throw new ExpressionParsingException("cannot apply assignment expression - incompatible types \"" + RHT + "\" and \"" + LHT + "\"", this.getLine());
		
		return PrecompiledType = LeftHand.getResultType(e);
	}

	@Override
	public int getLine() {
		return LeftHand.getLine();
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		CResult rht = RightHand.compute(e);
		e = rht.Env;
		CResult lht = LeftHand.compute(rht.Env);
		e = lht.Env;
		
		String valtmp = NameGenerator.getUniqueIdentifier();
		String typename = TypeTranslator.getTypeName(PrecompiledType);
		
		String Code = ";!!begin AssignmentExpr:\n";
		Code += rht.Code;
		Code += lht.Code;
		//wczytuje wynik prawej strony
		Code += valtmp + " = load " + typename + "* " + rht.ReturnValue.getName () + "\n";
		//zapisuje pod adresem lewej strony
		Code += "store " + typename + " " + valtmp + ", " + typename + "* " + lht.ReturnValue.getName() + "\n";
		//zwracam adres lewej strony
		
		Code += ";!!end AssignmentExpr:\n";
		return new CResult(e, Code, lht.ReturnValue);
	}

}
