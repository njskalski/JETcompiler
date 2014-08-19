grammar Javalette;

options {
  language = Java;
}

@header
{
package jet;
import jet.tree.*;
import jet.tree.expr.*;
import jet.types.*;
import java.util.ArrayList;
import java.util.List;
}

@lexer::header
{
package jet;
import jet.tree.*;
import jet.types.*;
}

@members {
  @Override
  public void reportError(RecognitionException e) {
    throw new IllegalArgumentException(e);
  }
  
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new IllegalArgumentException(e);
  }
  
}

program returns [Program result]
  : {
      List<FunctionDefinition> Functions = new ArrayList<FunctionDefinition>();
      List<ClassDefinition>    Classes   = new ArrayList<ClassDefinition>();
    }
    (class_definition    {Classes.add($class_definition.result);})*
    (function_definition {Functions.add($function_definition.result);} )*
    {$result = new Program(Functions, Classes); }
  ;


//KLASY 

function_definition returns [FunctionDefinition result]
  : typename identifier '(' argument_list ')' compound_stmt
    {
      $result = new FunctionDefinition($identifier.line, new FunctionType($argument_list.Types, $typename.result),
                                       $identifier.result,
                                       $argument_list.Identifiers,
                                       $compound_stmt.result);
    }
  ;
  
constructor_definition returns [ConstructorDefinition result]
  :  identifier '(' argument_list ')' compound_stmt
    {
      $result = new ConstructorDefinition($argument_list.Types, $argument_list.Identifiers,
                                          $identifier.result, $compound_stmt.result, $identifier.line);
    }
  ;
  
argument_list returns [List<TypeDescriptor> Types, List<String> Identifiers]
  : {$Types = new ArrayList<TypeDescriptor>(); $Identifiers = new ArrayList<String>();}
    (
      t0=typename i0=identifier       {$Types.add($t0.result); $Identifiers.add($i0.result); }
      (',' t1=typename i1=identifier  {$Types.add($t1.result); $Identifiers.add($i1.result); }
      )*
    )?
  ;

class_definition returns [ClassDefinition result]
  : {
      List<FunctionDefinition> Functions = new ArrayList<FunctionDefinition>();
      DeclarationListStmt Declarations = new DeclarationListStmt();
      List<ConstructorDefinition> Constructors = new ArrayList<ConstructorDefinition>();
    }
    'class' identifier
    '{'
    ( 
      (declaration_stmt     {Declarations = DeclarationListStmt.MergeLists(Declarations, $declaration_stmt.result); }
      )
      |
      (function_definition  {Functions.add($function_definition.result);}                                     
      )
      |
      (constructor_definition {Constructors.add($constructor_definition.result);}
      )
    )*
    '}'
    
    {$result = new ClassDefinition($identifier.result, Declarations,Functions, Constructors);}
  ;


//TYPES

typename returns [TypeDescriptor result]
  : array_type   {$result = $array_type.result;}
  | unit_type    {$result = $unit_type.result; }
  ;
  
unit_type returns [TypeDescriptor result]
  : primitive_type  {$result = $primitive_type.result;}
  | named_type      {$result = $named_type.result;    }
  ;
  
array_type returns [TypeDescriptor result]
  : unit_type {$result = $unit_type.result;}
    ('[' ']'  {$result = new ArrayType($result);}
    )+
  ;
  
primitive_type returns [TypeDescriptor result]
  : 'boolean' {$result = BooleanType.Instance;}
  | 'void'    {$result = VoidType.Instance;   }
  | 'int'     {$result = IntegerType.Instance;}
  | 'double'  {$result = DoubleType.Instance; }
  | 'string'  {$result = StringType.Instance; }
  | 'float'   {$result = FloatType.Instance;  }
  ;
  
named_type returns [TypeDescriptor result]
  : IDENT     {$result = new NamedType($IDENT.text);}
  ;
  
////STMT:
stmt returns [Stmt result]
  : compound_stmt       {$result = $compound_stmt.result;}
  | declaration_stmt    {$result = $declaration_stmt.result;}
  | if_stmt             {$result = $if_stmt.result;}
  | loop_stmt           {$result = $loop_stmt.result;}
  | return_stmt         {$result = $return_stmt.result;}
  | expr_stmt           {$result = $expr_stmt.result;}
  | empty_stmt          {$result = $empty_stmt.result;}
  ;
    
empty_stmt returns [EmptyStmt result]
  : sem=';'{$result = new EmptyStmt($sem.line); }
  ;    
    
compound_stmt returns [CompoundStmt result]
  : r='{' stmt_list '}' {$result = new CompoundStmt($r.line, $stmt_list.result); }
  ;
  
stmt_list returns [List<Stmt> result]
  : {$result = new ArrayList<Stmt>();} 
    (stmt {$result.add($stmt.result);}
    )*
  ;
  
declaration_stmt returns [DeclarationListStmt result]
  : t0=typename {$result = new DeclarationListStmt();}
  (d0=declarator {$result.addDeclaration(new SingleDeclarationStmt($d0.line, $t0.result, $d0.Id, $d0.E));}
    (',' d1=declarator {$result.addDeclaration(new SingleDeclarationStmt($d0.line, $t0.result, $d1.Id, $d1.E));}
    )*
  ) ';'
  ;
  
declarator returns [String Id, Expr E, int line]
  : identifier ('=' expr)? {$Id = $identifier.result; $E = $expr.result; $line = $identifier.line;}
  ;
  
expr_stmt returns [Stmt result]
  : expr ';' {$result = new ExprStmt($expr.result); }
  ;
  
if_stmt returns [Stmt result]
  : if1='if' '(' e1=expr ')' s1=stmt ('else' s2=stmt)? {$result = new IfteStmt($if1.line, $e1.result, $s1.result, $s2.result); }
  ;
  
loop_stmt returns [Stmt result]
  : w1='while' '(' e0=expr ')' s0=stmt {$result = new WhileStmt($w1.line, $e0.result, $s0.result);}
  | f1='for' '(' e1=expr ';' e2=expr ';' e3=expr ')' s1=stmt {$result = new ForStmt($f1.line, $e1.result, $e2.result, $e3.result, $s1.result);}
  ;
  
return_stmt returns [ReturnStmt result]
  : r1='return' expr? ';' {$result = new ReturnStmt($r1.line, $expr.result);}
  ;

//EXPR:

assignment_operator //traktowane na pale jako string
  : '='
  | '+='
  | '-='
  | '*='
  | '/='
  | '%='
  | '<<=' 
  | '>>=' 
  ;

expr  returns [Expr result]
  : assignment_expr {$result = $assignment_expr.result;}
  ;

assignment_expr returns [Expr result]  //pamietaj by to skladac od zewnatrz
   :  //jesli to dziala, to zajebistosc++
    {
      List<Expr> ExprList = new ArrayList<Expr>();
      List<String> Operators = new ArrayList<String>();
    }
    l1=logical_or_expr {ExprList.add($l1.result);}
    (op1=assignment_operator l2=logical_or_expr
      {
        ExprList.add($l2.result);
        Operators.add($op1.text);
      }
    )*
    
    {
      if(ExprList.size() == 1) {
          $result = ExprList.get(0);
      } else {
          int lastExpr = ExprList.size() - 1;
          $result = new AssignmentExpr(Operators.get(lastExpr-1),
                       ExprList.get(lastExpr-1),
                       ExprList.get(lastExpr));
          lastExpr -= 2;
          
          while(lastExpr >= 0)
          {
            $result = new AssignmentExpr(Operators.get(lastExpr), //to nie jest blad, narysuj sobie
                                        ExprList.get(lastExpr),
                                        $result);
          }
      }
    }
  ;
  
logical_or_expr returns [Expr result]
  : l1=logical_and_expr {$result = $l1.result;}
    (op='||' l2=logical_and_expr {$result = new LogicalOrExpr($op.line, $result, $l2.result);}
    )*
  ;
  
logical_and_expr returns [Expr result]
  : e1=equal_expr {$result = $e1.result;} 
    (op='&&' e2=equal_expr {$result = new LogicalAndExpr($op.line, $result, $e2.result);}
    )*
  ;
  
equal_expr returns [Expr result]
  : r1=relation_expr {$result = $r1.result;}
    (op1=('=='|'!=') r2=relation_expr {$result = new EqualExpr($op1.text, $result, $r2.result);}
    )*
  ;
  
relation_expr returns [Expr result]
  : a1=add_expr  {$result = $a1.result;} 
    (op1=('<' | '>' | '<=' | '>=') a2=add_expr  {$result = new RelationExpr($op1.line, $op1.text, $result, $a2.result);}
    )*
  ;
  
add_expr returns [Expr result]
  : m1=mult_expr {$result = $m1.result;} 
    (op1=('+' | '-') m2=mult_expr {$result = new AddExpr($op1.line, $op1.text, $result, $m2.result);} 
    )*
  ;

mult_expr returns [Expr result]
  : c1=constructor_expr {$result = $c1.result; } 
    (op1=('*' | '/' | '%') c2=constructor_expr {$result = new MultExpr($op1.line, $op1.text, $result, $c2.result);}
    )*
  ;

constructor_expr returns [Expr result]
  : n1='new' typename {TypeDescriptor td = $typename.result;}
    (
      (  '[' expr ']'         {$result = new ArrayConstructorExpr($n1.line, td, $expr.result);      }   )
    | ( '(' expr_list? ')'    {$result = new SimpleConstructorExpr($n1.line, td, $expr_list.result);}   )
    )
  | unary_expr { $result = $unary_expr.result; }
  ;
  
unary_expr returns [Expr result]
  : (op1=('!'|'+'|'-'))? prefix_expr
	  {
	   $result = $prefix_expr.result;
	   
	   if($op1!=null)
	     if($op1.text.equals("!"))
	     {$result = new LogicalNotExpr($op1.line, $result); }
	     else if ($op1.text.equals("-"))
	     {$result = new UnaryMinusExpr($op1.line, $result); }
	  // "+" ignoruje.
	  } 
  ;

prefix_expr returns [Expr result]
  : (op1=('--'|'++'))? term_expr//suffix_expr
    {
      $result = $term_expr.result;
      if($op1!=null)
      {
        $result = new PrefixIncDecExpr($op1.line, $op1.text, $result);
      } 
    }
  ;

expr_list returns [List<Expr> result]
  : {$result = new ArrayList<Expr>(); }
    e1=expr       {$result.add($e1.result);}
     (',' e2=expr {$result.add($e2.result);}
     )* 
  ;

// kolejnosc jak w c - sufiksowy ma wiekszy priorytet wiazania http://en.wikipedia.org/wiki/Operators_in_C_and_C%2B%2B
term_expr returns [Expr result]
  : l1=literal     {$result = $l1.result;} 
  | identifier  {$result = new IdentifierExpr($identifier.line, $identifier.text);}
    ( ( op=('--'|'++') {$result = new SuffixIncDecExpr($op.line, $op.text, result);}   )
    | 
      ( 
        ( op1='(' el1=expr_list? ')'   {$result = new FuncallOperatorExpr($op1.line, $el1.result, $result); } )
        | (op2='[' e1=expr ']'        {$result = new IndexOperatorExpr($op2.line, $result, $e1.result); } ) 
        | (op3='.' e2=expr            {$result = new DotOperatorExpr($op3.line, $result, $e2.result); } )
      )+
    )?
  | '(' e4=expr ')'  {$result = $e4.result;}
  ;

literal returns [Expr result]
  : integer_literal {$result = $integer_literal.result;}
  | float_literal   {$result = $float_literal.result;}
  | double_literal  {$result = $double_literal.result;}
  | logical_literal {$result = $logical_literal.result;}
  | string_literal  {$result = $string_literal.result;}
  ;

integer_literal returns [IntegerLiteralExpr result]
  : INTEGER_LITERAL {$result = new IntegerLiteralExpr($INTEGER_LITERAL.line, $INTEGER_LITERAL.text);}
  ;
  
float_literal returns [FloatLiteralExpr result]
  : FLOAT_LITERAL {$result = new FloatLiteralExpr($FLOAT_LITERAL.line, $FLOAT_LITERAL.text);}
  ;

double_literal returns [DoubleLiteralExpr result]
  : DOUBLE_LITERAL {$result = new DoubleLiteralExpr($DOUBLE_LITERAL.line, $DOUBLE_LITERAL.text);}
  ;
  
logical_literal returns [BooleanLiteralExpr result]
  : LOGICAL_LITERAL {$result = new BooleanLiteralExpr($LOGICAL_LITERAL.line,$LOGICAL_LITERAL.text);}
  ;

string_literal returns [StringLiteralExpr result]
  : STRING_LITERAL  {$result = new StringLiteralExpr($STRING_LITERAL.line, $STRING_LITERAL.text);}
  ;

identifier returns [String result, int line]
  : IDENT {$result = $IDENT.text; $line = $IDENT.line;}
  ;    
  
//LEXER:

INTEGER_LITERAL : ('0'..'9')+;
FLOAT_LITERAL :        (
                        ('0'..'9')+'.'(('0'..'9')*)
                        | ('.'('0'..'9')+)
                       );

DOUBLE_LITERAL :        (
                        ('0'..'9')+'.'(('0'..'9')*)'d'
                        | ('.'('0'..'9')+)'d'
                       );
                       
LOGICAL_LITERAL : ('true' | 'false');
STRING_LITERAL : '"' .* '"';

//NUMERIC : ('0'..'9')+('.' '0'..'9')?;

IDENT : ('a'..'z' | 'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

WS : (' ' | '\n' | '\t' | '\r' | '\f')+ {$channel = HIDDEN;};

COMMENT
  : ('//' | '#') .* ('\n' | '\r') {$channel = HIDDEN;}
  | '/*' .* '*/' {$channel = HIDDEN;}
  ;   
  
 BAD_COMMENT :c='/*'( ~('*') | ( '*' ~ ('/')) )*  {EarlyExitException e = new EarlyExitException(); e.token = $c; reportError(e);} ;
  