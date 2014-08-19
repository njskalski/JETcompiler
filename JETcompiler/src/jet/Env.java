package jet;

import java.util.HashMap;
import java.util.Map;

import jet.tree.ClassDefinition;
import jet.tree.FunctionDefinition;
import jet.types.TypeDescriptor;

public class Env {
	private Map<String, TypeDescriptor> Namespace;
	private Map<String, ClassDefinition> Classes;
	private Map<String, FunctionDefinition> Functions;
	private TypeDescriptor ReturnType;
	private Env ParentEnv;
	
	//TODO dodać sprawdzanie, czy dany konstruktor nie został 2x zadeklarowany.
	
	public Env(Map<String, TypeDescriptor> _Namespace, Map<String, ClassDefinition> _Classes, Map<String, FunctionDefinition> _Functions)
	{
		Namespace = new HashMap<String, TypeDescriptor>(_Namespace);
		Classes = new HashMap<String, ClassDefinition>(_Classes);
		Functions = new HashMap<String, FunctionDefinition>(_Functions);
		ReturnType = null;
		ParentEnv = null;
	}
	
	public static Env getEmptyEnv()
	{
		return new Env(new HashMap<String, TypeDescriptor>(), new HashMap<String, ClassDefinition>(), new HashMap<String, FunctionDefinition>());
	}
	
	public Env createSubEnv()
	{
		// Nowe env jest puste, a lookupa propaguje w górę do parenta.		
		Env e = getEmptyEnv();
		e.ReturnType = ReturnType;
		e.ParentEnv = this;
		return e;
	}
	
	public boolean isDeclaredLocallyVariable(String name)
	{
		if(Namespace.containsKey(name))
			return true;
		else
			return false;
	}
	
	public boolean isDeclaredAnywhereVariable(String name)
	{
		if(Namespace.containsKey(name))
			return true;
		else
			if(ParentEnv != null)
				return ParentEnv.isDeclaredAnywhereVariable(name);
			else
				return false;
	}
	
	public boolean isDeclaredFunction(String name)
	{
		if(Functions.containsKey(name))
			return true;
		else
			if(ParentEnv != null)
				return ParentEnv.isDeclaredFunction(name);
			else
				return false;
	}
	
	public boolean isDeclaredClass(String name)
	{
		if(Classes.containsKey(name))
			return true;
		else
			if(ParentEnv != null)
				return ParentEnv.isDeclaredClass(name);
			else
				return false;
	}
	
	public void setVariableDeclaration(String Name, TypeDescriptor Type)
	{
		if(Namespace.containsKey(Name))
			Namespace.remove(Name);
		Namespace.put(Name, Type);
	}
	
	public void setClassDeclaration(String Name, ClassDefinition _Class) throws Exception
	{
		if(Classes.containsKey(Name))
			throw new Exception("Two distinct declarations of class \"" + Name + "\" found! \n");
		Classes.put(Name, _Class);
	}
	
	public void setFunctionDeclaration(String Name, FunctionDefinition _Function) throws Exception
	{
		if(Functions.containsKey(Name))
			throw new Exception("Two distinct declarations of function \"" + Name + "\" in the same namespace found! No overloading implemented. \n");
		
		Functions.put(Name, _Function);
		// TODO to może należy przenieść gdzie indziej, ew zintegrować te set'y
		Namespace.put(Name, _Function.getFunctionType());
	}
	
	public FunctionDefinition getFunctionDefinition(String Name) throws EnvLookupException
	{
		//Functions.get(Name);
		if(Functions.containsKey(Name))
			return Functions.get(Name);
			else
			{
				if(ParentEnv != null)
					return ParentEnv.getFunctionDefinition(Name);
				else throw new EnvLookupException("Cannot find function \"" + Name + "\"");
			}
	}
	
	public ClassDefinition getClassDefinition(String Name) throws EnvLookupException
	{
		//return Classes.get(Name);
		if(Classes.containsKey(Name))
			return Classes.get(Name);
			else
			{
				if(ParentEnv != null)
					return ParentEnv.getClassDefinition(Name);
				else throw new EnvLookupException("Cannot find class \"" + Name + "\"");
			}
	}
	
	public TypeDescriptor getTypeOf(String Name) throws EnvLookupException
	{
		//return Namespace.get(Name);
		if(Namespace.containsKey(Name))
			return Namespace.get(Name);
			else
			{
				if(ParentEnv != null)
					return ParentEnv.getTypeOf(Name);
				else throw new EnvLookupException("Identifier \"" + Name + "\" not found");
			}
	}
	
	public TypeDescriptor getReturnType()
	{
		return ReturnType;
	}
	
	public void setReturnType(TypeDescriptor Type)
	{
		ReturnType = Type;
	}
}
