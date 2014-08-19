package jet.types;

public class FloatType extends TypeDescriptor {

	public final static FloatType Instance = new FloatType();
	private FloatType(){}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof FloatType))
			return false;
		return this == o; // zaprywatyzowany konstruktor załatwia sprawę
	}
}
