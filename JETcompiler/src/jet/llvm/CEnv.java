package jet.llvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.Env;
import jet.tree.ClassDefinition;
import jet.tree.FunctionDefinition;
import jet.types.ArrayType;
import jet.types.BooleanType;
import jet.types.DoubleType;
import jet.types.FloatType;
import jet.types.IntegerType;
import jet.types.NamedType;
import jet.types.StringType;
import jet.types.TypeDescriptor;
import jet.types.VoidType;

public class CEnv {
    private Map<String, ClassDefinition> Classes;
	private Map<String, CReference> Namespace;
	private Map<String, CReference> NameToReference;
	private TypeDescriptor ReturnType;
	private CReference This;
	private ClassDefinition ClassScope;
	private CEnv ParentEnv;

	public void setThis(CReference this1) {
		This = this1;
	}
	
	public CReference getThis() {
		return This;
	}
//	
//	public void setClassScope(ClassDefinition classScope) {
//		ClassScope = classScope;
//	}
//	
//	public ClassDefinition getClassScope() {
//		return ClassScope;
//	}

	public ClassDefinition getClassByName(String name)
	{
		return Classes.get(name);
	}
	
	public void addClass(ClassDefinition cd)
	{
		Classes.put(cd.getName(), cd);
	}
	
	public CEnv()
	{
		Namespace = new HashMap<String, CReference>();
		NameToReference = new HashMap<String, CReference>();
		Classes = new HashMap<String, ClassDefinition>();
	}
	
	public void addToNamespace(String originalID, CReference ref)
	{
		Namespace.put(originalID, ref);
	}
	
	public CReference getItemFromNamespaceByName(String name) throws ComputationException
	{		
		if(Namespace.containsKey(name))
			return Namespace.get(name);
		
		if(ParentEnv != null)
			return ParentEnv.getItemFromNamespaceByName(name);
		else
			throw new ComputationException("Item \"" + name + "\" cannot be found in namespace!");
	}
	
	public String getFunctionName(String funname)
	{
		return "@" + funname;
	}
	
	public void setReturnType(TypeDescriptor returnType) {
		ReturnType = returnType;
	}
	
	public CEnv createSubEnv()
	{		
		CEnv e = new CEnv();
		e.ReturnType = ReturnType;
		e.Classes = Classes;
		e.ParentEnv = this;
		e.This = this.This;
		return e;
	}

}
