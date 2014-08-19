package jet.llvm;

public class NameGenerator {
	private static long uq = 0;
	private static long num = 0;
	public static String getUniqueIdentifier()
	{
		return "%uid." + uq++;
	}
	
	public static String getUniqueLabel()
	{
		return "Label"+ num++;
	}
	
	public static String getUniqueLabel(String suffix)
	{
		return "Label"+ num++ + suffix;
	}
}
