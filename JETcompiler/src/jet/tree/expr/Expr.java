package jet.tree.expr;
import jet.Env;
import jet.ExpressionParsingException;
import jet.llvm.Instruction;
import jet.tree.Node;
import jet.types.TypeDescriptor;

public interface Expr extends Node {
	TypeDescriptor getResultType(Env e) throws ExpressionParsingException;
	
	TypeDescriptor getPrecompiledType();
	
}
