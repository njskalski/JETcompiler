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
import jet.types.FunctionType;
import jet.types.NamedType;
import jet.types.TypeDescriptor;

public class FunctionDefinition implements Node {
	private final FunctionType Type;
	private final List<String> ArgumentNames;
	private final String Name;
	private ClassDefinition Owner;
	private final CompoundStmt Code;
	
	private final int Line;
	
	public FunctionDefinition(int _Line, FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
	{
		Type = _Type;
		Name = _Name;
		Code = _Code;
		ArgumentNames = _ArgumentNames;
		Line = _Line;
	}
	
	public void setOwner(ClassDefinition owner) {
		Owner = owner;
	}
	
	public ClassDefinition getOwner()
	{
		return Owner;
	}
	
	public List<String> getArgumentNames()
	{
		return ArgumentNames;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public FunctionType getFunctionType()
	{
		return Type;
	}
	
	public CompoundStmt getCode()
	{
		return Code;
	}
	
	public boolean doesArgumentListMatch(List<TypeDescriptor> _ArgumentTypes)
	{
		if(_ArgumentTypes.size() != Type.getArgumentTypes().size()) return false;
		
		for(int i = 0 ; i < _ArgumentTypes.size() ; ++i)
			if(!Type.getArgumentTypes().get(i).equals(_ArgumentTypes.get(i)))
				return false;
		return true;
	}
	
	public Env processEnv(Env e, TypeErrorLogger log)
	{ 	// funckja nie dodaje się sama do środowiska.
		Env local = e.createSubEnv();
		
		assert(Type.getArgumentTypes().size() == ArgumentNames.size());
		
		for(int i = 0 ; i < ArgumentNames.size() ; ++i)
		{
			local.setVariableDeclaration(ArgumentNames.get(i), Type.getArgumentTypes().get(i));
		}
		local.setReturnType(Type.getReturnType());
		
		if(!Code.containsReturn())
			log.log("Function \"" + this.getName() + "\" does not contain a return statement", this);
		
		Code.processEnv(local, log);
		
		return e;
	}

	@Override
	public int getLine() {
		return Line;
	}

	@Override
	public CResult compute(CEnv e) throws ComputationException {
		
		List<CReference> ArgumentCRefs = new ArrayList<CReference>();
		List<String>	 ArgumentUIDs  = new ArrayList<String>();
		
		String header = "define " + TypeTranslator.getTypeName(this.getFunctionType().getReturnType()) + " " + e.getFunctionName(Name);
		header += "(";
		
		if(Owner != null)
		{
			header += TypeTranslator.getClassTypeName(Owner.getName()) + "* " + "%this";
			if(ArgumentNames.size() > 0)
				header += ", ";
		}
		
		for(int i = 0 ; i < ArgumentNames.size(); ++i)
		{
			ArgumentUIDs.add(NameGenerator.getUniqueIdentifier());
			
			header += TypeTranslator.getTypeName(Type.getArgumentTypes().get(i)) + " " + ArgumentUIDs.get(i);
			
			if(i < ArgumentNames.size() -1) header += ", ";
		}
		header += ") {\n";
		
		List<String>	LocalArgUIDs = new ArrayList<String>();
		for(int i = 0 ; i < ArgumentNames.size(); ++i)
		{
			LocalArgUIDs.add(NameGenerator.getUniqueIdentifier());
			String argtype = TypeTranslator.getTypeName(Type.getArgumentTypes().get(i));
			header += LocalArgUIDs.get(i) + " = alloca " + argtype + "\n";
			header += "store " + argtype + " " + ArgumentUIDs.get(i) + ", " + argtype + "* " + LocalArgUIDs.get(i) + "\n";
			
			ArgumentCRefs.add(new CReference(LocalArgUIDs.get(i), Type.getArgumentTypes().get(i)));
		}
		
		header += ";!!end function header\n";
		
		CEnv local = e.createSubEnv();
		local.setReturnType(Type.getReturnType());
		for(int i = 0 ; i < ArgumentCRefs.size(); ++i)
			local.addToNamespace(ArgumentNames.get(i), ArgumentCRefs.get(i));
		
		if(Owner != null)
			local.setThis(new CReference("%this", new NamedType(Owner.getName())));
		
		CResult comp = Code.compute(local);
		
		String footer = "}\n";
		
		String FinalCode = header + comp.Code + footer;
		
		return new CResult(e, FinalCode, null);
	}
}
