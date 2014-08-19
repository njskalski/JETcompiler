package jet.types;


public class VoidType extends TypeDescriptor {

	public final static VoidType Instance = new VoidType();
	private VoidType(){}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof VoidType))
			return false;
		return true;
	}
	
	
}
