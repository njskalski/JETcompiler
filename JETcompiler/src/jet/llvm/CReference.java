package jet.llvm;

import jet.types.TypeDescriptor;

public class CReference {
	private String Name;
	private TypeDescriptor Type;
	
	public CReference(String Name, TypeDescriptor Type) {
		this.Name = Name;
		this.Type = Type;
	}
	
	public TypeDescriptor getType() {
		return Type;
	}
	
	public String getName() {
		return Name;
	}
}
