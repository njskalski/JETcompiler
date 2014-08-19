package jet.types;

import java.util.List;

import jet.tree.*;

public class FunctionType extends TypeDescriptor {

	private final List<TypeDescriptor> ArgumentTypes;
	private final TypeDescriptor ReturnType;
	
	public FunctionType(List<TypeDescriptor> _ArgumentTypes, TypeDescriptor _ReturnType)
	{
		ArgumentTypes = _ArgumentTypes;
		ReturnType = _ReturnType;
	}

	public TypeDescriptor getReturnType()
	{
		return ReturnType;
	}
	
	public List<TypeDescriptor> getArgumentTypes()
	{
		return ArgumentTypes;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof FunctionType))
				return false;
		
		FunctionType b = (FunctionType)(o);
		
		if(!b.ReturnType.equals(this.ReturnType)) return false;
		if(!b.ArgumentTypes.equals(this.ArgumentTypes)) return false;
		return true;
	}
	
}
