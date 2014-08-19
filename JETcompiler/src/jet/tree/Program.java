package jet.tree;

import java.util.ArrayList;
import java.util.List;

import jet.Env;
import jet.TypeErrorLogger;
import jet.llvm.CEnv;
import jet.llvm.CResult;
import jet.llvm.ComputationException;
import jet.types.DoubleType;
import jet.types.FloatType;
import jet.types.FunctionType;
import jet.types.IntegerType;
import jet.types.TypeDescriptor;
import jet.types.VoidType;
import jet.types.StringType;

public class Program {
	private final List<FunctionDefinition> Functions;
	private final List<ClassDefinition>	Classes;
	
	public Program(List<FunctionDefinition> _Functions, List<ClassDefinition> _Classes)
	{
		Functions = _Functions;
		Classes = _Classes;
	}
	
	public List<String> getTypeCheckResults()
	{
		TypeErrorLogger log = new TypeErrorLogger();
	
		Env e;
		
		try{
			e = putDefaultFunctions(Env.getEmptyEnv());
			
			for(ClassDefinition cd : Classes)
				e.setClassDeclaration(cd.getName(), cd);
			for(FunctionDefinition fd : Functions)
				e.setFunctionDeclaration(fd.getName(), fd);
		} catch (Exception ex) {
			log.log(ex);
			return log.getErrorList();
		}
		
		for(ClassDefinition cd : Classes)
			cd.processEnv(e, log);
		for(FunctionDefinition fd : Functions)
			fd.processEnv(e, log);
		
		return log.getErrorList();
	}
	
	public Env putDefaultFunctions(Env e) throws Exception
	{
		e = e.createSubEnv();
		{ //printInt...
			List<TypeDescriptor> printIntArgs = new ArrayList<TypeDescriptor>();
			printIntArgs.add(IntegerType.Instance);
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			nazwy_arg.add("arg1");
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("printInt", new FunctionDefinition(-1, new FunctionType(printIntArgs, VoidType.Instance), "printInt", nazwy_arg, kod));
		}
		
		{ //printFloat...
			List<TypeDescriptor> printFloat = new ArrayList<TypeDescriptor>();
			printFloat.add(FloatType.Instance);
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			nazwy_arg.add("arg1");
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("printFloat", new FunctionDefinition(-1, new FunctionType(printFloat, VoidType.Instance), "printInt", nazwy_arg, kod));
		}
		
		{ //printDouble...
			List<TypeDescriptor> printArgs = new ArrayList<TypeDescriptor>();
			printArgs.add(DoubleType.Instance);
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			nazwy_arg.add("arg1");
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("printDouble", new FunctionDefinition(-1, new FunctionType(printArgs, VoidType.Instance), "printDouble", nazwy_arg, kod));
		}
		
		{ //printString...
			List<TypeDescriptor> printArgs = new ArrayList<TypeDescriptor>();
			printArgs.add(StringType.Instance);
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			nazwy_arg.add("arg1");
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("printString", new FunctionDefinition(-1, new FunctionType(printArgs, VoidType.Instance), "printString", nazwy_arg, kod));
		}
		
		{ //error...
			List<TypeDescriptor> printArgs = new ArrayList<TypeDescriptor>();
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("error", new FunctionDefinition(-1, new FunctionType(printArgs, VoidType.Instance), "error", nazwy_arg, kod));
		}
		
		{ //readInt...
			List<TypeDescriptor> printArgs = new ArrayList<TypeDescriptor>();
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("readInt", new FunctionDefinition(-1, new FunctionType(printArgs, IntegerType.Instance), "readInt", nazwy_arg, kod));
		}
		
		{ //readDouble...
			List<TypeDescriptor> printArgs = new ArrayList<TypeDescriptor>();
			
			CompoundStmt kod = new CompoundStmt(-1, new ArrayList<Stmt>());
			List<String> nazwy_arg = new ArrayList<String>();
			
			//public FunctionDefinition(FunctionType _Type, String _Name, List<String> _ArgumentNames, CompoundStmt _Code)
			e.setFunctionDeclaration("readDouble", new FunctionDefinition(-1, new FunctionType(printArgs, DoubleType.Instance), "readDouble", nazwy_arg, kod));
		}
		
		return e;
	}

	public List<FunctionDefinition> getFunctions()
	{
		return Functions;
	}
	
	public List<ClassDefinition> getClasses()
	{
		return Classes;
	}
	
	public String getCode() throws ComputationException
	{
		String res = "";
		
		CEnv e = new CEnv();
		
		for(ClassDefinition c : Classes)
			e.addClass(c);
		
		for(ClassDefinition c : Classes)
		{
			res += c.generateClassCode(e);
		}
		
		for(FunctionDefinition f : Functions)
		{
			CResult cr = f.compute(e);
			res += cr.Code;
		}
		
		return res;
	}
}
