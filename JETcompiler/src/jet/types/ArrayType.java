package jet.types;

public class ArrayType extends TypeDescriptor {

	private final TypeDescriptor ElementType;
	
	public ArrayType(TypeDescriptor _ElementType)
	{
		ElementType = _ElementType;
	}
	
	public TypeDescriptor getSingleElementType()
	{
		return ElementType;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof ArrayType))
			return false;
		ArrayType b = (ArrayType)o;
				
		return this.getSingleElementType().equals(b.getSingleElementType());
	}

}
