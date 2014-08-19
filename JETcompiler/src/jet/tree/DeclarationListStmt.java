package jet.tree;

import java.util.ArrayList;
import java.util.List;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.Instruction;

public class DeclarationListStmt implements Stmt {
	private List<SingleDeclarationStmt> Declarations;

	public DeclarationListStmt()
	{
		Declarations = new ArrayList<SingleDeclarationStmt>();
	}
	
	public DeclarationListStmt(List<SingleDeclarationStmt> _Declarations)
	{
		Declarations = _Declarations;
	}
	
	public void addDeclaration(SingleDeclarationStmt Declaration)
	{
		Declarations.add(Declaration);
	}
	
	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		for(SingleDeclarationStmt s : Declarations)
			e = s.processEnv(e, log);
		return e;
		
		//TODO tu może być błąd, nie myślę
	}
	
	public List<SingleDeclarationStmt> getDeclarationList()
	{
		return Declarations;
	}
	
	public static DeclarationListStmt MergeLists(DeclarationListStmt dls1, DeclarationListStmt dls2)
	{
		List<SingleDeclarationStmt> newList = new ArrayList<SingleDeclarationStmt>(dls1.Declarations);
		newList.addAll(dls2.Declarations);
		return new DeclarationListStmt(newList);
	}

	@Override
	public int getLine() {
		return Declarations.get(0).getLine();
	}

	@Override
	public boolean containsReturn() {
		return false;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String code = "";
		CEnv finalEnv = e;
		for(Instruction i : Declarations)
		{
			CResult x = i.compute(e);
			e = x.Env;
			code += x.Code;
			finalEnv = x.Env;
		}
		return new CResult(finalEnv, code, null);
	}
}
