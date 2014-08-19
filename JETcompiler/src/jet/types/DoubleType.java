package jet.types;

public class DoubleType extends TypeDescriptor {

	public final static DoubleType Instance = new DoubleType();
	private DoubleType(){}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof DoubleType))
			return false;
		return this == o; // zaprywatyzowany konstruktor załatwia sprawę
	}
}
