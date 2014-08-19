package jet.tree;

import jet.Env;
import jet.ExpressionParsingException;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.tree.expr.Expr;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class SingleDeclarationStmt implements Stmt {
	private final TypeDescriptor Type;
	private final String FieldName;
	private final Expr FieldValue;
	private final int Line;
	
	public SingleDeclarationStmt(int _Line, TypeDescriptor _Type, String _FieldName, Expr _FieldValue)
	{
		Type = _Type;
		FieldName = _FieldName;
		FieldValue = _FieldValue;
		Line = _Line;
	}
	
	public String getFieldName()
	{
		return FieldName;
	}
	
	public TypeDescriptor getFieldType()
	{
		return Type;
	}

	@Override
	public Env processEnv(Env e, TypeErrorLogger log) {
		//TODO tu są błędy
		if(FieldValue != null)
		{
			try
			{
				TypeDescriptor FieldValueType = FieldValue.getResultType(e);
				if(!FieldValueType.equals(Type))
					log.log("Cannot initiate field \"" + FieldName + "\" of type \"" + Type + "\" with incompatible type \"" + FieldValueType + "\"", this);
				
				if(e.isDeclaredLocallyVariable(FieldName) || e.isDeclaredFunction(FieldName) || e.isDeclaredClass(FieldName))
					throw new ExpressionParsingException("Name \"" + FieldName + "\" is already taken in this scope", this.getLine());
				
				Env local = e.createSubEnv();
				local.setVariableDeclaration(FieldName, Type);
				return local;
			}
			catch(ExpressionParsingException ex)
			{
				log.log(""+ex);
				return e;
			}
		} else
		{

			if(e.isDeclaredLocallyVariable(FieldName) || e.isDeclaredFunction(FieldName) || e.isDeclaredClass(FieldName))
				log.log("Name \"" + FieldName + "\" is already taken in this scope.",this);
			
			if(Type instanceof NamedType)
			{
				NamedType NType = (NamedType)Type;
				
				
			}
			
			Env local = e.createSubEnv();
			local.setVariableDeclaration(FieldName, Type);
			return local;
		}
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
		
		String Code = "";
		if(FieldValue == null)
			Code += ";!!begin DeclarationStmt, FieldValue == null\n";
		else
			 Code += ";!!begin DeclarationStmt, FieldValue != null\n";
		
		String resname = NameGenerator.getUniqueIdentifier();
		String typename = TypeTranslator.getTypeName(Type);
		Code += resname + " = alloca " + typename + "\n";
		
		if(FieldValue != null)
		{
			CResult fv = FieldValue.compute(e);
			e = fv.Env;
			
			e.addToNamespace(FieldName, new CReference(resname, Type));
			
			String valtmp = NameGenerator.getUniqueIdentifier();
			
			Code += valtmp + " = load " + typename + "* " + fv.ReturnValue.getName () + "\n";
			Code += "store " + typename + " " + valtmp + ", " + typename + "* " + resname +"\n";
			Code += ";!!end DeclarationStmt\n";
			return new CResult(e, fv.Code + Code, new CReference(resname, Type));
		}
		else
		{
			e.addToNamespace(FieldName, new CReference(resname, Type));
			Code += ";!!end DeclarationStmt\n";
			return new CResult(e, Code, new CReference(resname, Type));
		}
	}
}
