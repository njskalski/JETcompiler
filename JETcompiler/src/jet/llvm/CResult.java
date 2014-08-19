package jet.llvm;

public class CResult {

	public final CEnv Env;
	public final String Code;
	public final CReference ReturnValue;
	
	public CResult(CEnv Env, String Code, CReference ReturnValue)
	{
		this.Env = Env;
		this.Code = Code;
		this.ReturnValue = ReturnValue;
	}
}
