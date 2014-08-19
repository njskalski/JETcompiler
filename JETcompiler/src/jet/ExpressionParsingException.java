package jet;

public class ExpressionParsingException extends Exception{
	public final int Line;
	public final String Identifier;
	
	public ExpressionParsingException(String identifier, int line)
	{
		Line = line;
		Identifier = identifier;
	}
	
	@Override
	public String toString()
	{
		return Identifier + ", line " + Line + ".";
	}
}
