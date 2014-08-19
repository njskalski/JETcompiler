package jet.llvm;

public interface Instruction {

	public CResult compute(CEnv e) throws ComputationException;
}
