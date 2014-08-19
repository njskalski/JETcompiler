package jet.types;

public class NamedType extends TypeDescriptor {

	private final String Name;
	
	public NamedType(String _Name)
	{
		Name = _Name;
	}
	
	public String getName()
	{
		return Name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NamedType))
			return false;
		
		NamedType b = (NamedType)o;
		return b.getName().equals(this.getName());
	}
	
	@Override
	public String toString()
	{
		return "[NamedType: " + Name + "]";
	}

}
