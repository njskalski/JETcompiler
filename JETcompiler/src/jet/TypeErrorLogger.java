package jet;

import java.util.ArrayList;
import java.util.List;

import jet.tree.Node;

public class TypeErrorLogger {

	private List<String> Errors;
	
	public TypeErrorLogger()
	{
		Errors = new ArrayList<String>();
	}
	
	public void log(String s, Node n)
	{
		Errors.add(s + ", line " + n.getLine());
	}
	
	public void log(String s)
	{
		Errors.add(s);
	}
	
	public void log(ExpressionParsingException e)
	{
		Errors.add("Error while processing expression: " + e);
	}
	
	public void log(Exception e)
	{
		Errors.add("" + e.getMessage());
	}
	
	public List<String> getErrorList()
	{
		return Errors;
	}
}
