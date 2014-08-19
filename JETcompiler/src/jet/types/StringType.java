package jet.types;

public class StringType extends TypeDescriptor {

	public final static StringType Instance = new StringType();
	private StringType(){}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof StringType))
			return false;
		return true;
	}
}
