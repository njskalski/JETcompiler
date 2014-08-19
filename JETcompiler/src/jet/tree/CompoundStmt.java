package jet.tree;

import java.util.ArrayList;
import java.util.List;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.Instruction;

public class CompoundStmt implements Stmt {

	private final int Line;
	private final List<Stmt> StmtList;
	
	public CompoundStmt(int _Line, List<Stmt> _List)
	{
		StmtList = _List;
		Line = _Line;
	}
	
	public CompoundStmt(int _Line)
	{
		StmtList = new ArrayList<Stmt>();
		Line = _Line;
	}
	
	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		Env local = e.createSubEnv();
		
		for(Stmt s : StmtList)
			local = s.processEnv(local, log);
		
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public boolean containsReturn() {
		for(Stmt s : StmtList)
			if(s.containsReturn()) return true;
		return false;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = "";
		CEnv local = e.createSubEnv();
		for(Instruction i : StmtList)
		{
			CResult x = i.compute(local);
			local = x.Env;
			code += x.Code;
		}
		return new CResult(e, code, null);
	}

}
