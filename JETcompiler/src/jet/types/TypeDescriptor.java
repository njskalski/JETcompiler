package jet.types;

public abstract class TypeDescriptor {
	@Override
	public abstract boolean equals(Object o);
	
	@Override
	public String toString()
	{
		String cn = this.getClass().getName(); 
		return cn.substring(cn.lastIndexOf('.')+1, cn.length());
	}
}
