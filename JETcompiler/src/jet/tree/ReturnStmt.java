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
import jet.types.TypeDescriptor;
import jet.types.VoidType;

public class ReturnStmt implements Stmt {

	private final int Line;
	private final Expr ReturnExpr;
	
	public ReturnStmt(int _Line, Expr _ReturnExpr)
	{
		this.ReturnExpr = _ReturnExpr;
		Line = _Line;
	}
	
	@Override
	public Env processEnv(Env e, TypeErrorLogger log){
		
		TypeDescriptor rettype;
		
		try {
			if(ReturnExpr != null)
				rettype = ReturnExpr.getResultType(e);
			else
				rettype = VoidType.Instance;
			
			if(!rettype.equals(e.getReturnType()))
				log.log("Incorrect return type. Expected \""+ e.getReturnType() + " and \"" + rettype +"\" was found",this);
		} catch (ExpressionParsingException e1) {
			log.log(e1);
		}
		
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public boolean containsReturn() {
		return true;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		String Code = ";!!ReturnStmt:\n";
		if(ReturnExpr == null)
		{
			Code += "ret void\n";
		}
		else if(ReturnExpr.getPrecompiledType().equals(VoidType.Instance))
		{
			Code += "ret void\n";
		}
		else
		{
			CResult comp = ReturnExpr.compute(e);
			Code += comp.Code;
			e = comp.Env;
			
			String retuid = NameGenerator.getUniqueIdentifier();
			Code += retuid + " = load " + TypeTranslator.getTypeName(comp.ReturnValue.getType()) + "* " + comp.ReturnValue.getName() + "\n";
			Code += "ret " + TypeTranslator.getTypeName(comp.ReturnValue.getType()) + " " + retuid + "\n";
		}
		
		return new CResult(e, Code, null);
	}

}
