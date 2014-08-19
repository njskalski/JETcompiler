package jet.llvm;

import jet.types.ArrayType;
import jet.types.BooleanType;
import jet.types.DoubleType;
import jet.types.FloatType;
import jet.types.IntegerType;
import jet.types.NamedType;
import jet.types.StringType;
import jet.types.TypeDescriptor;
import jet.types.VoidType;

public class TypeTranslator {
	static public String getTypeName(TypeDescriptor type) throws ComputationException
	{
		if(type instanceof IntegerType)
			return "i32";
		else if(type instanceof DoubleType)
			return "double";
		else if(type instanceof FloatType)
			return "float";
		else if(type instanceof StringType)
			return "i8*";
		else if(type instanceof BooleanType)
			return "i1";
		else if(type instanceof VoidType)
			return "void";
		else if(type instanceof NamedType)
		{
			NamedType nt = (NamedType)type;
			return getClassTypeName(nt.getName());
		}
		else if(type instanceof ArrayType)
		{
			ArrayType at = (ArrayType)type;
			return getTypeName(at.getSingleElementType()) + "*";
		}
		else throw new ComputationException("Unknown type:\"" + type + "\".");
	}
	
	static public String getClassTypeName(String ClassName)
	{
		return "%cls." + ClassName;
	}
	
	static public String getClassConstructorName(String ClassName)
	{
		return "@cc." + ClassName;
	}
}
