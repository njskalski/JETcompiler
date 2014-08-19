package jet.tree;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.Instruction;

public interface Stmt extends Node {
	public Env processEnv(Env e, TypeErrorLogger log);
	public boolean containsReturn();
}
