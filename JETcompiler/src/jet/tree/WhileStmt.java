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

public class WhileStmt implements Stmt {

	private final int Line;
	private final Stmt LoopBody;
	private final Expr LoopCondition;
	
	public WhileStmt(int _Line, Expr _Condition, Stmt _Body)
	{
		LoopBody = _Body;
		LoopCondition = _Condition;
		Line = _Line;
	}
	
	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		
		try {
			if(!LoopCondition.getResultType(e).equals(BooleanType.Instance))
			{
				log.log("Loop condition must be boolean.", this);
			}
		} catch (ExpressionParsingException e1) {
			log.log(e1);
		}
		
		LoopBody.processEnv(e, log);
		
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public boolean containsReturn() {
		return LoopBody.containsReturn();
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String LabelLoopCond, LabelLoopBody,LabelLoopEnd;
		
		String Code = ";!!begin WhileStmt:\n";
		
		LabelLoopCond = NameGenerator.getUniqueLabel("LoopCond");
		LabelLoopBody = NameGenerator.getUniqueLabel("LoopBody");
		LabelLoopEnd = NameGenerator.getUniqueLabel("LoopEnd");
		
		CResult LoopComp = LoopCondition.compute(e);
		e = LoopComp.Env;
		
		Code += "br label %" + LabelLoopCond + "\n";
		Code += LabelLoopCond + ":\n";
		Code += LoopComp.Code;
		
		String LoopCondVal = NameGenerator.getUniqueIdentifier();
		
		Code += LoopCondVal + " = load " + TypeTranslator.getTypeName(BooleanType.Instance) + "* " + LoopComp.ReturnValue.getName() + "\n";
		Code += "br " + TypeTranslator.getTypeName(BooleanType.Instance) + " " + LoopCondVal + ", label %" + LabelLoopBody + ", label %" + LabelLoopEnd + "\n";

		Code += LabelLoopBody + ":\n";
		CResult LoopBodyComp = this.LoopBody.compute(e);
		e = LoopBodyComp.Env;
		Code += LoopBodyComp.Code;
		Code += "br label%" + LabelLoopCond + "\n";
		
		Code += LabelLoopEnd + ":\n";
		Code += ";!!end WhileStmt\n";
		
		return new CResult(e, Code, null);
	}
	
}
