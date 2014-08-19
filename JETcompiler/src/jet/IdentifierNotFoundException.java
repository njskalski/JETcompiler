package jet;

import com.sun.xml.internal.bind.v2.runtime.output.IndentingUTF8XmlOutput;

public class IdentifierNotFoundException extends ExpressionParsingException {

	public IdentifierNotFoundException(String identifier, int line)
	{
		super(identifier, line);
	}
}
