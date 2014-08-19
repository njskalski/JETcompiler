package jet.tree.expr;

import java.util.List;

import jet.Env;
import jet.EnvLookupException;
import jet.ExpressionParsingException;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.tree.ClassDefinition;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class IdentifierExpr implements Expr{

	private final int line;
	private final String FieldName;
	
	public IdentifierExpr(int _Line, String name)
	{
		FieldName = name;
		line = _Line;
	}
	
	@Override
	public TypeDescriptor getResultType(Env e) throws ExpressionParsingException {
		
//		if(!(e.isDeclaredVariable(FieldName)))
//			throw new ExpressionParsingException("Identifier \"" + FieldName + "\" is undeclared.", this.getLine());

		try {
			return PrecompiledType = e.getTypeOf(FieldName);
		} catch (EnvLookupException e1) {
			throw new ExpressionParsingException(e1.getMessage(), this.getLine());
		}
	}

	private TypeDescriptor PrecompiledType;
	@Override
	public TypeDescriptor getPrecompiledType()
	{
		return PrecompiledType;
	}
	
	@Override
	public int getLine() {
		return line;
	}

	public String getFieldName()
	{
		return FieldName;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {

		if(e.getThis() != null)
		{
			
			try
			{
				CReference ident = e.getItemFromNamespaceByName(FieldName);
				
				String Code = ";!!begin and end of IdentifierExpr, passing \"" + ident.getName() + "\" as \"" + FieldName + "\"\n";
					
				return new CResult(e, Code, ident);
			} catch (ComputationException ex)
			{
			
			
				TypeDescriptor parentObject = e.getThis().getType();
				
				if(!(parentObject instanceof NamedType))
					throw new ComputationException("Cannot apply dot operator to non-named class instance type.");
				NamedType parent = (NamedType)parentObject;
				
				ClassDefinition parentClass = e.getClassByName(parent.getName());
				
				List<String> fieldnames = parentClass.getFieldNames();
				
				int offset = 0;
				while(offset < fieldnames.size())
				{
					if(fieldnames.get(offset).equals(FieldName))
						break;
					offset++;
				}
				
				if(offset == fieldnames.size())
					throw new ComputationException("Fieln named \"" + FieldName + "\" cannot be found in \"" + parentClass.getName() + "\" class.");
				
				TypeDescriptor FieldType = parentClass.getFieldMap().get(FieldName);
				
				String Code = ";!!begin IdentifierExpr, case This is type of " + parentClass.getName() + ":\n";
				
				String restocast = NameGenerator.getUniqueIdentifier();
				String result = NameGenerator.getUniqueIdentifier();
				Code += restocast + " = getelementptr " + TypeTranslator.getTypeName(e.getThis().getType()) + "* " + e.getThis().getName() + ", i32 " + offset + "\n";
				Code += result + " = bitcast " + TypeTranslator.getTypeName(e.getThis().getType()) + "* " + restocast +" to " + TypeTranslator.getTypeName(FieldType) + "*\n";
				Code += ";!!end IdentifierExpr\n";
				return new CResult(e, Code, new CReference(result, FieldType));
			}	
		} else
		{
			CReference ident = e.getItemFromNamespaceByName(FieldName);
			
			String Code = ";!!begin and end of IdentifierExpr, passing \"" + ident.getName() + "\" as \"" + FieldName + "\"\n";
				
			return new CResult(e, Code, ident);
			
		}
	}
	
}
