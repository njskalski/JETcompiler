package jet.tree;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;

public class EmptyStmt implements Stmt{
	
	private final int Line;
	
	public EmptyStmt(int _Line)
	{
		Line = _Line;
	}

	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public boolean containsReturn() {
		return false;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		return new CResult(e, "", null);
	}
	
	
}
