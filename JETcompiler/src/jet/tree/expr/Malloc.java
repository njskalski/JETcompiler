package jet.tree.expr;

import jet.llvm.CEnv;
import jet.llvm.ComputationException;
import jet.llvm.NameGenerator;
import jet.llvm.TypeTranslator;
import jet.types.TypeDescriptor;

public class Malloc {
	public static class Result
	{
		public final String ValueName;
		public final String Code;
		
		public Result(String ValueName, String C)
		{
			this.ValueName = ValueName;
			this.Code = C;
		}
	}
	
	static public Result GenerateSingleAllocation(TypeDescriptor TypeName, CEnv e) throws ComputationException
	{
		String typename = TypeTranslator.getTypeName(TypeName);
		String size1 = NameGenerator.getUniqueIdentifier();
		String sizeof = NameGenerator.getUniqueIdentifier();
		String ptr = NameGenerator.getUniqueIdentifier();
		String returnValue = NameGenerator.getUniqueIdentifier();
		
		String Code = ";!!begin Malloc.GenerateSingleAllocation(" + TypeName + "):\n";
		
		Code  += size1 + " = getelementptr " + typename + "* null, i32 1\n";
		Code  += sizeof + " = ptrtoint " + typename + "* " + size1 + " to i32\n";
		Code  += ptr + " = call i8* @malloc (i32 " + sizeof + ")\n";
		Code  += returnValue + " = bitcast i8* " + ptr + " to " + typename + "*\n";

		Code += ";!!end Malloc.GenerateSingleAllocation(" + TypeName + "):\n";
		
		return new Result(returnValue, Code);
	}
	
	static public Result GenerateArrayAllocation(TypeDescriptor TypeName, String lengthName, CEnv e) throws ComputationException
	{
		String typename = TypeTranslator.getTypeName(TypeName);
		String size1 = NameGenerator.getUniqueIdentifier();
		String sizeof = NameGenerator.getUniqueIdentifier();
		String ptr = NameGenerator.getUniqueIdentifier();
		String arrayptr = NameGenerator.getUniqueIdentifier();
		String returnValue = NameGenerator.getUniqueIdentifier();
		
		String Code = ";!!begin Malloc.GenerateArrayAllocation(" + TypeName + "):\n";
		
		String lengthVal = NameGenerator.getUniqueIdentifier();
		
		Code  += lengthVal + " = load i32* " + lengthName + "\n";
		Code  += size1 + " = getelementptr " + typename + "* null, i32 1\n";
		Code  += sizeof + " = ptrtoint " + typename + "* " + size1 + " to i32\n";
		Code  += ptr + " = call i8* @calloc (i32 " + lengthVal + ", i32 " + sizeof + ")\n";
		Code  += arrayptr + " = bitcast i8* " + ptr + " to " + typename + "*\n"; //arrayptr będzie typu type*
		Code  += returnValue + " = alloca " + typename + "*\n";					 // returnvalue będzie type**
		Code  += "store " + typename + "* " + arrayptr + ", " + typename + "** " + returnValue + "\n"; // teraz zapisuje arrayptr pod retval
		Code  += ";!!en Malloc.GenerateArrayAllocation(" + TypeName + "):\n";
		
		return new Result(returnValue, Code);
	}
	
	static public Result GenerateStringAllocation(String Text, CEnv e)
	{
		String ptr = NameGenerator.getUniqueIdentifier();
		
		String Code = ";!!begin Malloc.GenerateStringAllocation():\n";
		
		Code  += ptr + " = call i8* @malloc (i32 " + (Text.length() + 1) + ")\n";
		Code  += ";!!end Malloc.GenerateStringAllocation():\n";
		return new Result(ptr, Code);
	}
}
