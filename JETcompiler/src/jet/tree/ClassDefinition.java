package jet.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jet.Env;
import jet.ExpressionParsingException;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.ComputationException;
import jet.llvm.TypeTranslator;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class ClassDefinition {
	private final String Name;
	private final DeclarationListStmt Declarations;
	
	private final Map<String, FunctionDefinition> Functions;
	private final List<String> FunctionNames;
	private final List<ConstructorDefinition> Constructors;
	private final Map<String, TypeDescriptor> Fields;
	private final List<String> FieldNames;
	
	public String getName()
	{
		return Name;
	}
	
	public Map<String, TypeDescriptor> getFieldMap()
	{
		return Fields;
	}
	
	public List<String> getFieldNames()
	{
		return FieldNames;
	}
	
	public ClassDefinition(String _Name, DeclarationListStmt _Declarations, 
			List<FunctionDefinition> _Functions, List<ConstructorDefinition> _Constructors)
	{
		Name = _Name;
		Declarations = _Declarations;
		Functions = new HashMap<String, FunctionDefinition>();
		FunctionNames = new ArrayList<String>();
		for(FunctionDefinition fd : _Functions)
		{
			fd.setOwner(this);
			Functions.put(fd.getName(), fd);
			FunctionNames.add(fd.getName());
		}
		
		Constructors = _Constructors;
		for(ConstructorDefinition cd : Constructors)
			cd.setOwner(this);
		
		Fields = new HashMap<String, TypeDescriptor>();
		FieldNames = new ArrayList<String>();
		
		for(SingleDeclarationStmt sds : Declarations.getDeclarationList())
		{
			Fields.put(sds.getFieldName(), sds.getFieldType());
			FieldNames.add(sds.getFieldName());
		}
		
		for(FunctionDefinition fd : _Functions)
			Fields.put(fd.getName(), fd.getFunctionType());
	}
	
	public List<ConstructorDefinition> getConstructors()
	{
		return Constructors;
	}
	
	public boolean hasDefaultConstructor()
	{
		for(ConstructorDefinition cd : Constructors)
		{
			if(cd.getArgumentTypes().size() == 0)
				return true;
		}
		return false;
	}
	
	public Map<String,FunctionDefinition> getFuncitons()
	{
		return Functions;
	}
	
	public TypeDescriptor getFieldOrFunctionType(String Name)
	{
		if(Fields.containsKey(Name)) return Fields.get(Name);
		if(Functions.containsKey(Name)) return Functions.get(Name).getFunctionType();
		return null;
	}
	
	public boolean isNameDeclared(String Name)
	{
		if(Fields.containsKey(Name)) return true;
		if(Functions.containsKey(Name)) return true;
		return false;
	}
	
	public Env processEnv(Env e, TypeErrorLogger log)
	{
		Env local = e.createSubEnv();
		
		for(int i = 0 ; i < Constructors.size(); ++i)
			for(int j = 0; j < i; ++j)
				{
					ConstructorDefinition a = Constructors.get(i), b = Constructors.get(j);
					if(a.doesArgumentListMatch(b.getArgumentTypes()))
						log.log("Two constructors that take the same argument list at lines " + a.getLine() + " and " + b.getLine() + ".");
				}
		
		for(int i = 0 ; i < FunctionNames.size(); ++i)
			for(int j = 0; j < i; ++j)
				if(FunctionNames.get(i).equals(FunctionNames.get(j)))
					log.log("Two distinct declarations of function \"" + Name + "." + FunctionNames.get(i) + "\" in the same class found! No overloading implemented. \n");
	
		
		for(SingleDeclarationStmt d : Declarations.getDeclarationList())
		{
			d.processEnv(e, log);
			local.setVariableDeclaration(d.getFieldName(), d.getFieldType());
		}
		
		for(FunctionDefinition fd : Functions.values())
			fd.processEnv(local, log);
		
		for(ConstructorDefinition cd : Constructors)
			cd.processEnv(local, log);
		
		return e;
	}
	
	public Env getInsideTheClass(Env e) throws Exception
	{
		Env local = e.createSubEnv();
		
		for(SingleDeclarationStmt d : Declarations.getDeclarationList())
		{
			local.setVariableDeclaration(d.getFieldName(), d.getFieldType());
		}
		
		for(FunctionDefinition fd : Functions.values())
		{
			local.setFunctionDeclaration(fd.getName(), fd);
		}
		
		return local;
	}
	
	public String generateClassCode(CEnv e) throws ComputationException
	{
		String Code = ";!!Class definition: \"" + Name + "\":\n";
		
		String cn = TypeTranslator.getClassTypeName(Name);
		
		Code += cn + " = type { ";
		
		for(int i = 0 ; i < FieldNames.size(); ++i)
		{
			String fn = FieldNames.get(i);
			Code += TypeTranslator.getTypeName(Fields.get(fn));
			if(i < FieldNames.size() -1)
				Code += ", ";
		}
		
		Code += " }\n\n";
		
		CEnv loc = e.createSubEnv();
		loc.setThis(new CReference("%this", new NamedType(Name)));
		
		for(ConstructorDefinition cd : Constructors)
		{
			Code += cd.compute(loc).Code;
		}
		
		for(FunctionDefinition fd : Functions.values())
		{
			Code += fd.compute(loc).Code;
		}
		
		Code += ";!!end of class definition \"" + Name + "\"\n";
		return Code;
	}
}
