package jet.types;

public class IntegerType extends TypeDescriptor {

	public final static IntegerType Instance = new IntegerType();
	private IntegerType(){}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof IntegerType))
			return false;
		return true; // zaprywatyzowany konstruktor załatwia sprawę
	}
}
