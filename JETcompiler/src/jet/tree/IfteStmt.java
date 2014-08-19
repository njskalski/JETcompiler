package jet.tree;

import jet.Env;
import jet.ExpressionParsingException;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.tree.expr.Expr;
import jet.types.BooleanType;
import jet.types.IntegerType;

public class IfteStmt implements Stmt {

	private final int Line;
	private final Expr Condition;
	private final Stmt IfTrue, IfFalse;
	
	public IfteStmt(int _Line, Expr _Condition, Stmt _IfTrue, Stmt _IfFalse)
	{
		Condition = _Condition;
		IfTrue = _IfTrue;
		IfFalse = _IfFalse;
		Line = _Line;
	}

	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		
		try {
			if(!(Condition.getResultType(e).equals(BooleanType.Instance)))
				log.log("Condition must be boolean.", this);
		} catch (ExpressionParsingException e1) {
			log.log(e1);
		}
		
		IfTrue.processEnv(e, log);
		if(IfFalse != null)
			IfFalse.processEnv(e, log);
		
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public boolean containsReturn() {
		if(IfTrue.containsReturn()) return true;
		if(IfFalse != null)
			if(IfFalse.containsReturn()) return true;
		return false;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String Code = ";!! IfteStmt\n";
		CResult cexpr = Condition.compute(e);
		e = cexpr.Env;
		
		Code += cexpr.Code;
		
		String LabelTrue, LabelFalse, LabelEnd, Cond;
		
		Cond = NameGenerator.getUniqueIdentifier();
		LabelTrue = NameGenerator.getUniqueLabel("IfteTrue");
		LabelFalse = NameGenerator.getUniqueLabel("IfteFalse");
		LabelEnd = NameGenerator.getUniqueLabel("IfteEnd");
		
		
		Code += Cond + " = load " + TypeTranslator.getTypeName(BooleanType.Instance) + "* " + cexpr.ReturnValue.getName() + "\n"; 
		Code += "br " + TypeTranslator.getTypeName(BooleanType.Instance) + " " + Cond + ", label %" + LabelTrue + ", label %" + LabelFalse + "\n";
		Code += LabelTrue + ":\n";
		
		CResult ctrue = IfTrue.compute(e);
		e = ctrue.Env;
		
		Code += ctrue.Code;
		Code += "br label %" + LabelEnd + "\n";
		Code += LabelFalse + ":\n";
		
		if(IfFalse != null)
		{
			CResult cfalse = IfFalse.compute(e);
			e = cfalse.Env;
			Code += cfalse.Code;
		}
		Code += "br label %" + LabelEnd + "\n";
		Code += LabelEnd + ":\n";
		Code += ";!!end ifte\n";
		
		return new CResult(e, Code, null);
	}
	
	
}
