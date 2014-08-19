package jet.tree;

import jet.Env;
import jet.ExpressionParsingException;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.tree.expr.Expr;

public class ExprStmt implements Stmt {
	
	private final Expr TheExpr;
	
	public ExprStmt(Expr _Expr)
	{
		TheExpr = _Expr;
	}

	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		try {
			TheExpr.getResultType(e);
		} catch (ExpressionParsingException e1) {
			log.log(e1);
		}
		return e;
	}

	@Override
	public int getLine() {
		return TheExpr.getLine();
	}

	@Override
	public boolean containsReturn() {
		return false;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		return TheExpr.compute(e);
	}
}
