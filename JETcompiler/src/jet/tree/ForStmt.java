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

public class ForStmt implements Stmt {
	
	private final int Line;
	private final Stmt LoopBody;
	private final Expr InitialExpr, LoopConditionExpr, IterationExpr;
	
	public ForStmt(int _Line, Expr _InitialExpr, Expr _LoopConditionExpr, Expr _IterationExpr, Stmt _LoopBody)
	{
		LoopBody = _LoopBody;
		InitialExpr = _InitialExpr;
		LoopConditionExpr = _LoopConditionExpr;
		IterationExpr = _IterationExpr;
		Line = _Line;
	}

	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		
		try {
			if(InitialExpr != null)
				InitialExpr.getResultType(e);
		} catch (ExpressionParsingException e2) {
			log.log(e2);
		}
		
		try {	
			if(LoopConditionExpr != null)
				if(!LoopConditionExpr.getResultType(e).equals(BooleanType.Instance))
				{
					log.log("Loop condition must be boolean.", this);
				}
		} catch (ExpressionParsingException e1) {
			log.log(e1);
		}
		
		try {
			if( IterationExpr!= null)
				IterationExpr.getResultType(e);
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
		String LabelLoopCond, LabelLoopBody, LabelIteExpr, LabelLoopEnd;
		
		String Code = ";!!begin ForStmt:\n";
		
		LabelLoopCond = NameGenerator.getUniqueLabel("LoopCond");
		LabelLoopBody = NameGenerator.getUniqueLabel("LoopBody");
		LabelLoopEnd = NameGenerator.getUniqueLabel("LoopEnd");
		LabelIteExpr = NameGenerator.getUniqueLabel("IterExpr");
		
		CResult InitComp = this.InitialExpr.compute(e);
		e = InitComp.Env;
		
		Code += ";for stmt init:\n";
		Code += InitComp.Code;
		Code += ";end of for stmt init\n";
		Code += "br label %" + LabelLoopCond + "\n";
		
		CResult LoopCond = this.LoopConditionExpr.compute(e);
		
		Code += LabelLoopCond + ":\n";
		Code += LoopCond.Code;
		
		String LoopCondVal = NameGenerator.getUniqueIdentifier();
		
		Code += LoopCondVal + " = load " + TypeTranslator.getTypeName(BooleanType.Instance) + "* " + LoopCond.ReturnValue.getName() + "\n";
		Code += "br " + TypeTranslator.getTypeName(BooleanType.Instance) + " " + LoopCondVal + ", label %" + LabelLoopBody + ", label %" + LabelLoopEnd + "\n";

		Code += LabelLoopBody + ":\n";
		CResult LoopBodyComp = this.LoopBody.compute(e);
		e = LoopBodyComp.Env;
		Code += LoopBodyComp.Code;
		Code += "br label %" + LabelIteExpr + "\n";
		
		Code += LabelIteExpr + ":\n";
		CResult LoopIteComp = this.IterationExpr.compute(e);
		e = LoopIteComp.Env;
		Code += LoopIteComp.Code;
		Code += "br label %" + LabelLoopCond + "\n";
		
		Code += LabelLoopEnd + ":\n";
		Code += ";!!end ForStmt\n";
		
		return new CResult(e, Code, null);
	}
}
