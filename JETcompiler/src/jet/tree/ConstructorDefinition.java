package jet.tree;

import java.util.ArrayList;
import java.util.List;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CReference;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.tree.expr.Malloc;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class ConstructorDefinition implements Node {
	private final List<TypeDescriptor> ArgumentTypes;
	private final List<String> ArgumentNames;
	private final String Name;
	private final int Line;
	private final CompoundStmt Code;
	private ClassDefinition Owner;
	
	
	public ConstructorDefinition(List<TypeDescriptor> _ArgumentTypes, List<String> _ArgumentNames, String _Name, CompoundStmt _Code, int _Line)
	{
		ArgumentTypes = _ArgumentTypes;
		Name = _Name;
		Code = _Code;
		ArgumentNames = _ArgumentNames;
		Line = _Line;
	}
	
	public void setOwner(ClassDefinition owner) {
		Owner = owner;
	}
	
	public boolean doesArgumentListMatch(List<TypeDescriptor> _ArgumentTypes)
	{
		if(_ArgumentTypes.size() != ArgumentTypes.size()) return false;
		
		for(int i = 0 ; i < _ArgumentTypes.size() ; ++i)
			if(!ArgumentTypes.get(i).equals(_ArgumentTypes.get(i)))
				return false;
		return true;
	}
	
	public List<TypeDescriptor> getArgumentTypes()
	{
		return ArgumentTypes;
	}
	
	public Env processEnv(Env e, TypeErrorLogger log)
	{ 	// funckja nie dodaje się sama do środowiska.
		Env local = e.createSubEnv();
		
		for(int i = 0 ; i < ArgumentNames.size() ; ++i)
		{
			local.setVariableDeclaration(ArgumentNames.get(i), ArgumentTypes.get(i));
		}
		
		Code.processEnv(local, log);
		
		return e;
	}
	
	public String getName()
	{
		return Name;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		List<CReference> ArgumentCRefs = new ArrayList<CReference>();
		List<String>	 ArgumentUIDs  = new ArrayList<String>();
		
		String header = ";!!class constructor:\n";
		
		header += "define void " + TypeTranslator.getClassConstructorName(Name);
		header += "(";

		header += TypeTranslator.getClassTypeName(Owner.getName()) + "* " + "%this";
		if(ArgumentNames.size() > 0)
				header += ", ";
		
		for(int i = 0 ; i < ArgumentNames.size(); ++i)
		{
			ArgumentUIDs.add(NameGenerator.getUniqueIdentifier());
			
			header += TypeTranslator.getTypeName(ArgumentTypes.get(i)) + " " + ArgumentUIDs.get(i);
			
			if(i < ArgumentNames.size() -1) header += ", ";
		}
		header += ") {\n";
		
		List<String>	LocalArgUIDs = new ArrayList<String>();
		for(int i = 0 ; i < ArgumentNames.size(); ++i)
		{
			LocalArgUIDs.add(NameGenerator.getUniqueIdentifier());
			String argtype = TypeTranslator.getTypeName(ArgumentTypes.get(i));
			header += LocalArgUIDs.get(i) + " = alloca " + argtype + "\n";
			header += "store " + argtype + " " + ArgumentUIDs.get(i) + ", " + argtype + "* " + LocalArgUIDs.get(i) + "\n";
			
			ArgumentCRefs.add(new CReference(LocalArgUIDs.get(i), ArgumentTypes.get(i)));
		}
		
		header += ";!!end class constructor header\n";
		
		CEnv local = e.createSubEnv();
		
		for(int i = 0 ; i < ArgumentCRefs.size(); ++i)
			local.addToNamespace(ArgumentNames.get(i), ArgumentCRefs.get(i));
		
		
		local.setThis(new CReference("%this", new NamedType(Owner.getName())));
		
		CResult comp = Code.compute(local);
		
		String footer = "ret void\n}\n";
		
		String FinalCode = header + comp.Code + footer;
		
		return new CResult(e, FinalCode, null);
	}
}
