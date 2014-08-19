// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/akuda/school/JETcompiler/src/jet/Javalette.g 2011-01-23 21:38:36

package jet;
import jet.tree.*;
import jet.tree.expr.*;
import jet.types.*;
import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JavaletteParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "INTEGER_LITERAL", "FLOAT_LITERAL", "DOUBLE_LITERAL", "LOGICAL_LITERAL", "STRING_LITERAL", "WS", "COMMENT", "BAD_COMMENT", "'('", "')'", "','", "'class'", "'{'", "'}'", "'['", "']'", "'boolean'", "'void'", "'int'", "'double'", "'string'", "'float'", "';'", "'='", "'if'", "'else'", "'while'", "'for'", "'return'", "'+='", "'-='", "'*='", "'/='", "'%='", "'<<='", "'>>='", "'||'", "'&&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'new'", "'!'", "'--'", "'++'", "'.'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int BAD_COMMENT=12;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int DOUBLE_LITERAL=7;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int STRING_LITERAL=9;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int LOGICAL_LITERAL=8;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENT=4;
    public static final int COMMENT=11;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int FLOAT_LITERAL=6;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int INTEGER_LITERAL=5;

    // delegates
    // delegators


        public JavaletteParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public JavaletteParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return JavaletteParser.tokenNames; }
    public String getGrammarFileName() { return "/home/akuda/school/JETcompiler/src/jet/Javalette.g"; }


      @Override
      public void reportError(RecognitionException e) {
        throw new IllegalArgumentException(e);
      }
      



    // $ANTLR start "program"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:40:1: program returns [Program result] : ( class_definition )* ( function_definition )* ;
    public final Program program() throws RecognitionException {
        Program result = null;

        ClassDefinition class_definition1 = null;

        FunctionDefinition function_definition2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:41:3: ( ( class_definition )* ( function_definition )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:41:5: ( class_definition )* ( function_definition )*
            {

                  List<FunctionDefinition> Functions = new ArrayList<FunctionDefinition>();
                  List<ClassDefinition>    Classes   = new ArrayList<ClassDefinition>();
                
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:45:5: ( class_definition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:45:6: class_definition
            	    {
            	    pushFollow(FOLLOW_class_definition_in_program67);
            	    class_definition1=class_definition();

            	    state._fsp--;

            	    Classes.add(class_definition1);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:46:5: ( function_definition )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT||(LA2_0>=21 && LA2_0<=26)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:46:6: function_definition
            	    {
            	    pushFollow(FOLLOW_function_definition_in_program81);
            	    function_definition2=function_definition();

            	    state._fsp--;

            	    Functions.add(function_definition2);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            result = new Program(Functions, Classes); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "program"


    // $ANTLR start "function_definition"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:53:1: function_definition returns [FunctionDefinition result] : typename identifier '(' argument_list ')' compound_stmt ;
    public final FunctionDefinition function_definition() throws RecognitionException {
        FunctionDefinition result = null;

        JavaletteParser.identifier_return identifier3 = null;

        JavaletteParser.argument_list_return argument_list4 = null;

        TypeDescriptor typename5 = null;

        CompoundStmt compound_stmt6 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:54:3: ( typename identifier '(' argument_list ')' compound_stmt )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:54:5: typename identifier '(' argument_list ')' compound_stmt
            {
            pushFollow(FOLLOW_typename_in_function_definition112);
            typename5=typename();

            state._fsp--;

            pushFollow(FOLLOW_identifier_in_function_definition114);
            identifier3=identifier();

            state._fsp--;

            match(input,13,FOLLOW_13_in_function_definition116); 
            pushFollow(FOLLOW_argument_list_in_function_definition118);
            argument_list4=argument_list();

            state._fsp--;

            match(input,14,FOLLOW_14_in_function_definition120); 
            pushFollow(FOLLOW_compound_stmt_in_function_definition122);
            compound_stmt6=compound_stmt();

            state._fsp--;


                  result = new FunctionDefinition((identifier3!=null?identifier3.line:0), new FunctionType((argument_list4!=null?argument_list4.Types:null), typename5),
                                                   (identifier3!=null?identifier3.result:null),
                                                   (argument_list4!=null?argument_list4.Identifiers:null),
                                                   compound_stmt6);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "function_definition"


    // $ANTLR start "constructor_definition"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:63:1: constructor_definition returns [ConstructorDefinition result] : identifier '(' argument_list ')' compound_stmt ;
    public final ConstructorDefinition constructor_definition() throws RecognitionException {
        ConstructorDefinition result = null;

        JavaletteParser.argument_list_return argument_list7 = null;

        JavaletteParser.identifier_return identifier8 = null;

        CompoundStmt compound_stmt9 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:64:3: ( identifier '(' argument_list ')' compound_stmt )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:64:6: identifier '(' argument_list ')' compound_stmt
            {
            pushFollow(FOLLOW_identifier_in_constructor_definition148);
            identifier8=identifier();

            state._fsp--;

            match(input,13,FOLLOW_13_in_constructor_definition150); 
            pushFollow(FOLLOW_argument_list_in_constructor_definition152);
            argument_list7=argument_list();

            state._fsp--;

            match(input,14,FOLLOW_14_in_constructor_definition154); 
            pushFollow(FOLLOW_compound_stmt_in_constructor_definition156);
            compound_stmt9=compound_stmt();

            state._fsp--;


                  result = new ConstructorDefinition((argument_list7!=null?argument_list7.Types:null), (argument_list7!=null?argument_list7.Identifiers:null),
                                                      (identifier8!=null?identifier8.result:null), compound_stmt9, (identifier8!=null?identifier8.line:0));
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "constructor_definition"

    public static class argument_list_return extends ParserRuleReturnScope {
        public List<TypeDescriptor> Types;
        public List<String> Identifiers;
    };

    // $ANTLR start "argument_list"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:71:1: argument_list returns [List<TypeDescriptor> Types, List<String> Identifiers] : (t0= typename i0= identifier ( ',' t1= typename i1= identifier )* )? ;
    public final JavaletteParser.argument_list_return argument_list() throws RecognitionException {
        JavaletteParser.argument_list_return retval = new JavaletteParser.argument_list_return();
        retval.start = input.LT(1);

        TypeDescriptor t0 = null;

        JavaletteParser.identifier_return i0 = null;

        TypeDescriptor t1 = null;

        JavaletteParser.identifier_return i1 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:72:3: ( (t0= typename i0= identifier ( ',' t1= typename i1= identifier )* )? )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:72:5: (t0= typename i0= identifier ( ',' t1= typename i1= identifier )* )?
            {
            retval.Types = new ArrayList<TypeDescriptor>(); retval.Identifiers = new ArrayList<String>();
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:73:5: (t0= typename i0= identifier ( ',' t1= typename i1= identifier )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT||(LA4_0>=21 && LA4_0<=26)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:74:7: t0= typename i0= identifier ( ',' t1= typename i1= identifier )*
                    {
                    pushFollow(FOLLOW_typename_in_argument_list197);
                    t0=typename();

                    state._fsp--;

                    pushFollow(FOLLOW_identifier_in_argument_list201);
                    i0=identifier();

                    state._fsp--;

                    retval.Types.add(t0); retval.Identifiers.add((i0!=null?i0.result:null)); 
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:75:7: ( ',' t1= typename i1= identifier )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:75:8: ',' t1= typename i1= identifier
                    	    {
                    	    match(input,15,FOLLOW_15_in_argument_list218); 
                    	    pushFollow(FOLLOW_typename_in_argument_list222);
                    	    t1=typename();

                    	    state._fsp--;

                    	    pushFollow(FOLLOW_identifier_in_argument_list226);
                    	    i1=identifier();

                    	    state._fsp--;

                    	    retval.Types.add(t1); retval.Identifiers.add((i1!=null?i1.result:null)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argument_list"


    // $ANTLR start "class_definition"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:80:1: class_definition returns [ClassDefinition result] : 'class' identifier '{' ( ( declaration_stmt ) | ( function_definition ) | ( constructor_definition ) )* '}' ;
    public final ClassDefinition class_definition() throws RecognitionException {
        ClassDefinition result = null;

        DeclarationListStmt declaration_stmt10 = null;

        FunctionDefinition function_definition11 = null;

        ConstructorDefinition constructor_definition12 = null;

        JavaletteParser.identifier_return identifier13 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:81:3: ( 'class' identifier '{' ( ( declaration_stmt ) | ( function_definition ) | ( constructor_definition ) )* '}' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:81:5: 'class' identifier '{' ( ( declaration_stmt ) | ( function_definition ) | ( constructor_definition ) )* '}'
            {

                  List<FunctionDefinition> Functions = new ArrayList<FunctionDefinition>();
                  DeclarationListStmt Declarations = new DeclarationListStmt();
                  List<ConstructorDefinition> Constructors = new ArrayList<ConstructorDefinition>();
                
            match(input,16,FOLLOW_16_in_class_definition268); 
            pushFollow(FOLLOW_identifier_in_class_definition270);
            identifier13=identifier();

            state._fsp--;

            match(input,17,FOLLOW_17_in_class_definition276); 
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:88:5: ( ( declaration_stmt ) | ( function_definition ) | ( constructor_definition ) )*
            loop5:
            do {
                int alt5=4;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:89:7: ( declaration_stmt )
            	    {
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:89:7: ( declaration_stmt )
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:89:8: declaration_stmt
            	    {
            	    pushFollow(FOLLOW_declaration_stmt_in_class_definition292);
            	    declaration_stmt10=declaration_stmt();

            	    state._fsp--;

            	    Declarations = DeclarationListStmt.MergeLists(Declarations, declaration_stmt10); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:92:7: ( function_definition )
            	    {
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:92:7: ( function_definition )
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:92:8: function_definition
            	    {
            	    pushFollow(FOLLOW_function_definition_in_class_definition323);
            	    function_definition11=function_definition();

            	    state._fsp--;

            	    Functions.add(function_definition11);

            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:95:7: ( constructor_definition )
            	    {
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:95:7: ( constructor_definition )
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:95:8: constructor_definition
            	    {
            	    pushFollow(FOLLOW_constructor_definition_in_class_definition388);
            	    constructor_definition12=constructor_definition();

            	    state._fsp--;

            	    Constructors.add(constructor_definition12);

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_class_definition411); 
            result = new ClassDefinition((identifier13!=null?identifier13.result:null), Declarations,Functions, Constructors);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "class_definition"


    // $ANTLR start "typename"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:106:1: typename returns [TypeDescriptor result] : ( array_type | unit_type );
    public final TypeDescriptor typename() throws RecognitionException {
        TypeDescriptor result = null;

        TypeDescriptor array_type14 = null;

        TypeDescriptor unit_type15 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:107:3: ( array_type | unit_type )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:107:5: array_type
                    {
                    pushFollow(FOLLOW_array_type_in_typename442);
                    array_type14=array_type();

                    state._fsp--;

                    result = array_type14;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:108:5: unit_type
                    {
                    pushFollow(FOLLOW_unit_type_in_typename452);
                    unit_type15=unit_type();

                    state._fsp--;

                    result = unit_type15; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "typename"


    // $ANTLR start "unit_type"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:111:1: unit_type returns [TypeDescriptor result] : ( primitive_type | named_type );
    public final TypeDescriptor unit_type() throws RecognitionException {
        TypeDescriptor result = null;

        TypeDescriptor primitive_type16 = null;

        TypeDescriptor named_type17 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:112:3: ( primitive_type | named_type )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=21 && LA7_0<=26)) ) {
                alt7=1;
            }
            else if ( (LA7_0==IDENT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:112:5: primitive_type
                    {
                    pushFollow(FOLLOW_primitive_type_in_unit_type476);
                    primitive_type16=primitive_type();

                    state._fsp--;

                    result = primitive_type16;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:113:5: named_type
                    {
                    pushFollow(FOLLOW_named_type_in_unit_type485);
                    named_type17=named_type();

                    state._fsp--;

                    result = named_type17;    

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unit_type"


    // $ANTLR start "array_type"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:116:1: array_type returns [TypeDescriptor result] : unit_type ( '[' ']' )+ ;
    public final TypeDescriptor array_type() throws RecognitionException {
        TypeDescriptor result = null;

        TypeDescriptor unit_type18 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:117:3: ( unit_type ( '[' ']' )+ )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:117:5: unit_type ( '[' ']' )+
            {
            pushFollow(FOLLOW_unit_type_in_array_type511);
            unit_type18=unit_type();

            state._fsp--;

            result = unit_type18;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:118:5: ( '[' ']' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==20) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:118:6: '[' ']'
            	    {
            	    match(input,19,FOLLOW_19_in_array_type520); 
            	    match(input,20,FOLLOW_20_in_array_type522); 
            	    result = new ArrayType(result);

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "array_type"


    // $ANTLR start "primitive_type"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:122:1: primitive_type returns [TypeDescriptor result] : ( 'boolean' | 'void' | 'int' | 'double' | 'string' | 'float' );
    public final TypeDescriptor primitive_type() throws RecognitionException {
        TypeDescriptor result = null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:123:3: ( 'boolean' | 'void' | 'int' | 'double' | 'string' | 'float' )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case 23:
                {
                alt9=3;
                }
                break;
            case 24:
                {
                alt9=4;
                }
                break;
            case 25:
                {
                alt9=5;
                }
                break;
            case 26:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:123:5: 'boolean'
                    {
                    match(input,21,FOLLOW_21_in_primitive_type551); 
                    result = BooleanType.Instance;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:124:5: 'void'
                    {
                    match(input,22,FOLLOW_22_in_primitive_type559); 
                    result = VoidType.Instance;   

                    }
                    break;
                case 3 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:125:5: 'int'
                    {
                    match(input,23,FOLLOW_23_in_primitive_type570); 
                    result = IntegerType.Instance;

                    }
                    break;
                case 4 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:126:5: 'double'
                    {
                    match(input,24,FOLLOW_24_in_primitive_type582); 
                    result = DoubleType.Instance; 

                    }
                    break;
                case 5 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:127:5: 'string'
                    {
                    match(input,25,FOLLOW_25_in_primitive_type591); 
                    result = StringType.Instance; 

                    }
                    break;
                case 6 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:128:5: 'float'
                    {
                    match(input,26,FOLLOW_26_in_primitive_type600); 
                    result = FloatType.Instance;  

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "primitive_type"


    // $ANTLR start "named_type"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:131:1: named_type returns [TypeDescriptor result] : IDENT ;
    public final TypeDescriptor named_type() throws RecognitionException {
        TypeDescriptor result = null;

        Token IDENT19=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:132:3: ( IDENT )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:132:5: IDENT
            {
            IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_named_type623); 
            result = new NamedType((IDENT19!=null?IDENT19.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "named_type"


    // $ANTLR start "stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:136:1: stmt returns [Stmt result] : ( compound_stmt | declaration_stmt | if_stmt | loop_stmt | return_stmt | expr_stmt | empty_stmt );
    public final Stmt stmt() throws RecognitionException {
        Stmt result = null;

        CompoundStmt compound_stmt20 = null;

        DeclarationListStmt declaration_stmt21 = null;

        Stmt if_stmt22 = null;

        Stmt loop_stmt23 = null;

        ReturnStmt return_stmt24 = null;

        Stmt expr_stmt25 = null;

        EmptyStmt empty_stmt26 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:137:3: ( compound_stmt | declaration_stmt | if_stmt | loop_stmt | return_stmt | expr_stmt | empty_stmt )
            int alt10=7;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:137:5: compound_stmt
                    {
                    pushFollow(FOLLOW_compound_stmt_in_stmt649);
                    compound_stmt20=compound_stmt();

                    state._fsp--;

                    result = compound_stmt20;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:138:5: declaration_stmt
                    {
                    pushFollow(FOLLOW_declaration_stmt_in_stmt663);
                    declaration_stmt21=declaration_stmt();

                    state._fsp--;

                    result = declaration_stmt21;

                    }
                    break;
                case 3 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:139:5: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_stmt674);
                    if_stmt22=if_stmt();

                    state._fsp--;

                    result = if_stmt22;

                    }
                    break;
                case 4 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:140:5: loop_stmt
                    {
                    pushFollow(FOLLOW_loop_stmt_in_stmt694);
                    loop_stmt23=loop_stmt();

                    state._fsp--;

                    result = loop_stmt23;

                    }
                    break;
                case 5 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:141:5: return_stmt
                    {
                    pushFollow(FOLLOW_return_stmt_in_stmt712);
                    return_stmt24=return_stmt();

                    state._fsp--;

                    result = return_stmt24;

                    }
                    break;
                case 6 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:142:5: expr_stmt
                    {
                    pushFollow(FOLLOW_expr_stmt_in_stmt728);
                    expr_stmt25=expr_stmt();

                    state._fsp--;

                    result = expr_stmt25;

                    }
                    break;
                case 7 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:143:5: empty_stmt
                    {
                    pushFollow(FOLLOW_empty_stmt_in_stmt746);
                    empty_stmt26=empty_stmt();

                    state._fsp--;

                    result = empty_stmt26;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "stmt"


    // $ANTLR start "empty_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:146:1: empty_stmt returns [EmptyStmt result] : sem= ';' ;
    public final EmptyStmt empty_stmt() throws RecognitionException {
        EmptyStmt result = null;

        Token sem=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:147:3: (sem= ';' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:147:5: sem= ';'
            {
            sem=(Token)match(input,27,FOLLOW_27_in_empty_stmt780); 
            result = new EmptyStmt((sem!=null?sem.getLine():0)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "empty_stmt"


    // $ANTLR start "compound_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:150:1: compound_stmt returns [CompoundStmt result] : r= '{' stmt_list '}' ;
    public final CompoundStmt compound_stmt() throws RecognitionException {
        CompoundStmt result = null;

        Token r=null;
        List<Stmt> stmt_list27 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:151:3: (r= '{' stmt_list '}' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:151:5: r= '{' stmt_list '}'
            {
            r=(Token)match(input,17,FOLLOW_17_in_compound_stmt808); 
            pushFollow(FOLLOW_stmt_list_in_compound_stmt810);
            stmt_list27=stmt_list();

            state._fsp--;

            match(input,18,FOLLOW_18_in_compound_stmt812); 
            result = new CompoundStmt((r!=null?r.getLine():0), stmt_list27); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "compound_stmt"


    // $ANTLR start "stmt_list"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:154:1: stmt_list returns [List<Stmt> result] : ( stmt )* ;
    public final List<Stmt> stmt_list() throws RecognitionException {
        List<Stmt> result = null;

        Stmt stmt28 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:155:3: ( ( stmt )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:155:5: ( stmt )*
            {
            result = new ArrayList<Stmt>();
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:156:5: ( stmt )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=IDENT && LA11_0<=STRING_LITERAL)||LA11_0==13||LA11_0==17||(LA11_0>=21 && LA11_0<=27)||LA11_0==29||(LA11_0>=31 && LA11_0<=33)||(LA11_0>=49 && LA11_0<=50)||(LA11_0>=54 && LA11_0<=57)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:156:6: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_stmt_list841);
            	    stmt28=stmt();

            	    state._fsp--;

            	    result.add(stmt28);

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "stmt_list"


    // $ANTLR start "declaration_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:160:1: declaration_stmt returns [DeclarationListStmt result] : t0= typename (d0= declarator ( ',' d1= declarator )* ) ';' ;
    public final DeclarationListStmt declaration_stmt() throws RecognitionException {
        DeclarationListStmt result = null;

        TypeDescriptor t0 = null;

        JavaletteParser.declarator_return d0 = null;

        JavaletteParser.declarator_return d1 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:161:3: (t0= typename (d0= declarator ( ',' d1= declarator )* ) ';' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:161:5: t0= typename (d0= declarator ( ',' d1= declarator )* ) ';'
            {
            pushFollow(FOLLOW_typename_in_declaration_stmt871);
            t0=typename();

            state._fsp--;

            result = new DeclarationListStmt();
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:162:3: (d0= declarator ( ',' d1= declarator )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:162:4: d0= declarator ( ',' d1= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaration_stmt880);
            d0=declarator();

            state._fsp--;

            result.addDeclaration(new SingleDeclarationStmt((d0!=null?d0.line:0), t0, (d0!=null?d0.Id:null), (d0!=null?d0.E:null)));
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:163:5: ( ',' d1= declarator )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:163:6: ',' d1= declarator
            	    {
            	    match(input,15,FOLLOW_15_in_declaration_stmt889); 
            	    pushFollow(FOLLOW_declarator_in_declaration_stmt893);
            	    d1=declarator();

            	    state._fsp--;

            	    result.addDeclaration(new SingleDeclarationStmt((d0!=null?d0.line:0), t0, (d1!=null?d1.Id:null), (d1!=null?d1.E:null)));

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            match(input,27,FOLLOW_27_in_declaration_stmt908); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "declaration_stmt"

    public static class declarator_return extends ParserRuleReturnScope {
        public String Id;
        public Expr E;
        public int line;
    };

    // $ANTLR start "declarator"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:168:1: declarator returns [String Id, Expr E, int line] : identifier ( '=' expr )? ;
    public final JavaletteParser.declarator_return declarator() throws RecognitionException {
        JavaletteParser.declarator_return retval = new JavaletteParser.declarator_return();
        retval.start = input.LT(1);

        JavaletteParser.identifier_return identifier29 = null;

        Expr expr30 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:169:3: ( identifier ( '=' expr )? )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:169:5: identifier ( '=' expr )?
            {
            pushFollow(FOLLOW_identifier_in_declarator927);
            identifier29=identifier();

            state._fsp--;

            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:169:16: ( '=' expr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:169:17: '=' expr
                    {
                    match(input,28,FOLLOW_28_in_declarator930); 
                    pushFollow(FOLLOW_expr_in_declarator932);
                    expr30=expr();

                    state._fsp--;


                    }
                    break;

            }

            retval.Id = (identifier29!=null?identifier29.result:null); retval.E = expr30; retval.line = (identifier29!=null?identifier29.line:0);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declarator"


    // $ANTLR start "expr_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:172:1: expr_stmt returns [Stmt result] : expr ';' ;
    public final Stmt expr_stmt() throws RecognitionException {
        Stmt result = null;

        Expr expr31 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:173:3: ( expr ';' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:173:5: expr ';'
            {
            pushFollow(FOLLOW_expr_in_expr_stmt955);
            expr31=expr();

            state._fsp--;

            match(input,27,FOLLOW_27_in_expr_stmt957); 
            result = new ExprStmt(expr31); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expr_stmt"


    // $ANTLR start "if_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:176:1: if_stmt returns [Stmt result] : if1= 'if' '(' e1= expr ')' s1= stmt ( 'else' s2= stmt )? ;
    public final Stmt if_stmt() throws RecognitionException {
        Stmt result = null;

        Token if1=null;
        Expr e1 = null;

        Stmt s1 = null;

        Stmt s2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:177:3: (if1= 'if' '(' e1= expr ')' s1= stmt ( 'else' s2= stmt )? )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:177:5: if1= 'if' '(' e1= expr ')' s1= stmt ( 'else' s2= stmt )?
            {
            if1=(Token)match(input,29,FOLLOW_29_in_if_stmt980); 
            match(input,13,FOLLOW_13_in_if_stmt982); 
            pushFollow(FOLLOW_expr_in_if_stmt986);
            e1=expr();

            state._fsp--;

            match(input,14,FOLLOW_14_in_if_stmt988); 
            pushFollow(FOLLOW_stmt_in_if_stmt992);
            s1=stmt();

            state._fsp--;

            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:177:38: ( 'else' s2= stmt )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:177:39: 'else' s2= stmt
                    {
                    match(input,30,FOLLOW_30_in_if_stmt995); 
                    pushFollow(FOLLOW_stmt_in_if_stmt999);
                    s2=stmt();

                    state._fsp--;


                    }
                    break;

            }

            result = new IfteStmt((if1!=null?if1.getLine():0), e1, s1, s2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "if_stmt"


    // $ANTLR start "loop_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:180:1: loop_stmt returns [Stmt result] : (w1= 'while' '(' e0= expr ')' s0= stmt | f1= 'for' '(' e1= expr ';' e2= expr ';' e3= expr ')' s1= stmt );
    public final Stmt loop_stmt() throws RecognitionException {
        Stmt result = null;

        Token w1=null;
        Token f1=null;
        Expr e0 = null;

        Stmt s0 = null;

        Expr e1 = null;

        Expr e2 = null;

        Expr e3 = null;

        Stmt s1 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:181:3: (w1= 'while' '(' e0= expr ')' s0= stmt | f1= 'for' '(' e1= expr ';' e2= expr ';' e3= expr ')' s1= stmt )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:181:5: w1= 'while' '(' e0= expr ')' s0= stmt
                    {
                    w1=(Token)match(input,31,FOLLOW_31_in_loop_stmt1024); 
                    match(input,13,FOLLOW_13_in_loop_stmt1026); 
                    pushFollow(FOLLOW_expr_in_loop_stmt1030);
                    e0=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_loop_stmt1032); 
                    pushFollow(FOLLOW_stmt_in_loop_stmt1036);
                    s0=stmt();

                    state._fsp--;

                    result = new WhileStmt((w1!=null?w1.getLine():0), e0, s0);

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:182:5: f1= 'for' '(' e1= expr ';' e2= expr ';' e3= expr ')' s1= stmt
                    {
                    f1=(Token)match(input,32,FOLLOW_32_in_loop_stmt1046); 
                    match(input,13,FOLLOW_13_in_loop_stmt1048); 
                    pushFollow(FOLLOW_expr_in_loop_stmt1052);
                    e1=expr();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_loop_stmt1054); 
                    pushFollow(FOLLOW_expr_in_loop_stmt1058);
                    e2=expr();

                    state._fsp--;

                    match(input,27,FOLLOW_27_in_loop_stmt1060); 
                    pushFollow(FOLLOW_expr_in_loop_stmt1064);
                    e3=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_loop_stmt1066); 
                    pushFollow(FOLLOW_stmt_in_loop_stmt1070);
                    s1=stmt();

                    state._fsp--;

                    result = new ForStmt((f1!=null?f1.getLine():0), e1, e2, e3, s1);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "loop_stmt"


    // $ANTLR start "return_stmt"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:185:1: return_stmt returns [ReturnStmt result] : r1= 'return' ( expr )? ';' ;
    public final ReturnStmt return_stmt() throws RecognitionException {
        ReturnStmt result = null;

        Token r1=null;
        Expr expr32 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:186:3: (r1= 'return' ( expr )? ';' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:186:5: r1= 'return' ( expr )? ';'
            {
            r1=(Token)match(input,33,FOLLOW_33_in_return_stmt1093); 
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:186:17: ( expr )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=IDENT && LA16_0<=STRING_LITERAL)||LA16_0==13||(LA16_0>=49 && LA16_0<=50)||(LA16_0>=54 && LA16_0<=57)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:186:17: expr
                    {
                    pushFollow(FOLLOW_expr_in_return_stmt1095);
                    expr32=expr();

                    state._fsp--;


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_return_stmt1098); 
            result = new ReturnStmt((r1!=null?r1.getLine():0), expr32);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "return_stmt"

    public static class assignment_operator_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "assignment_operator"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:191:1: assignment_operator : ( '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '<<=' | '>>=' );
    public final JavaletteParser.assignment_operator_return assignment_operator() throws RecognitionException {
        JavaletteParser.assignment_operator_return retval = new JavaletteParser.assignment_operator_return();
        retval.start = input.LT(1);

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:192:3: ( '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '<<=' | '>>=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:
            {
            if ( input.LA(1)==28||(input.LA(1)>=34 && input.LA(1)<=40) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment_operator"


    // $ANTLR start "expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:202:1: expr returns [Expr result] : assignment_expr ;
    public final Expr expr() throws RecognitionException {
        Expr result = null;

        Expr assignment_expr33 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:203:3: ( assignment_expr )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:203:5: assignment_expr
            {
            pushFollow(FOLLOW_assignment_expr_in_expr1178);
            assignment_expr33=assignment_expr();

            state._fsp--;

            result = assignment_expr33;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expr"


    // $ANTLR start "assignment_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:206:1: assignment_expr returns [Expr result] : l1= logical_or_expr (op1= assignment_operator l2= logical_or_expr )* ;
    public final Expr assignment_expr() throws RecognitionException {
        Expr result = null;

        Expr l1 = null;

        JavaletteParser.assignment_operator_return op1 = null;

        Expr l2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:207:4: (l1= logical_or_expr (op1= assignment_operator l2= logical_or_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:208:5: l1= logical_or_expr (op1= assignment_operator l2= logical_or_expr )*
            {

                  List<Expr> ExprList = new ArrayList<Expr>();
                  List<String> Operators = new ArrayList<String>();
                
            pushFollow(FOLLOW_logical_or_expr_in_assignment_expr1214);
            l1=logical_or_expr();

            state._fsp--;

            ExprList.add(l1);
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:213:5: (op1= assignment_operator l2= logical_or_expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==28||(LA17_0>=34 && LA17_0<=40)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:213:6: op1= assignment_operator l2= logical_or_expr
            	    {
            	    pushFollow(FOLLOW_assignment_operator_in_assignment_expr1225);
            	    op1=assignment_operator();

            	    state._fsp--;

            	    pushFollow(FOLLOW_logical_or_expr_in_assignment_expr1229);
            	    l2=logical_or_expr();

            	    state._fsp--;


            	            ExprList.add(l2);
            	            Operators.add((op1!=null?input.toString(op1.start,op1.stop):null));
            	          

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


                  if(ExprList.size() == 1) {
                      result = ExprList.get(0);
                  } else {
                      int lastExpr = ExprList.size() - 1;
                      result = new AssignmentExpr(Operators.get(lastExpr-1),
                                   ExprList.get(lastExpr-1),
                                   ExprList.get(lastExpr));
                      lastExpr -= 2;
                      
                      while(lastExpr >= 0)
                      {
                        result = new AssignmentExpr(Operators.get(lastExpr), //to nie jest blad, narysuj sobie
                                                    ExprList.get(lastExpr),
                                                    result);
                      }
                  }
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "assignment_expr"


    // $ANTLR start "logical_or_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:240:1: logical_or_expr returns [Expr result] : l1= logical_and_expr (op= '||' l2= logical_and_expr )* ;
    public final Expr logical_or_expr() throws RecognitionException {
        Expr result = null;

        Token op=null;
        Expr l1 = null;

        Expr l2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:241:3: (l1= logical_and_expr (op= '||' l2= logical_and_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:241:5: l1= logical_and_expr (op= '||' l2= logical_and_expr )*
            {
            pushFollow(FOLLOW_logical_and_expr_in_logical_or_expr1276);
            l1=logical_and_expr();

            state._fsp--;

            result = l1;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:242:5: (op= '||' l2= logical_and_expr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==41) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:242:6: op= '||' l2= logical_and_expr
            	    {
            	    op=(Token)match(input,41,FOLLOW_41_in_logical_or_expr1287); 
            	    pushFollow(FOLLOW_logical_and_expr_in_logical_or_expr1291);
            	    l2=logical_and_expr();

            	    state._fsp--;

            	    result = new LogicalOrExpr((op!=null?op.getLine():0), result, l2);

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "logical_or_expr"


    // $ANTLR start "logical_and_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:246:1: logical_and_expr returns [Expr result] : e1= equal_expr (op= '&&' e2= equal_expr )* ;
    public final Expr logical_and_expr() throws RecognitionException {
        Expr result = null;

        Token op=null;
        Expr e1 = null;

        Expr e2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:247:3: (e1= equal_expr (op= '&&' e2= equal_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:247:5: e1= equal_expr (op= '&&' e2= equal_expr )*
            {
            pushFollow(FOLLOW_equal_expr_in_logical_and_expr1321);
            e1=equal_expr();

            state._fsp--;

            result = e1;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:248:5: (op= '&&' e2= equal_expr )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==42) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:248:6: op= '&&' e2= equal_expr
            	    {
            	    op=(Token)match(input,42,FOLLOW_42_in_logical_and_expr1333); 
            	    pushFollow(FOLLOW_equal_expr_in_logical_and_expr1337);
            	    e2=equal_expr();

            	    state._fsp--;

            	    result = new LogicalAndExpr((op!=null?op.getLine():0), result, e2);

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "logical_and_expr"


    // $ANTLR start "equal_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:252:1: equal_expr returns [Expr result] : r1= relation_expr (op1= ( '==' | '!=' ) r2= relation_expr )* ;
    public final Expr equal_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr r1 = null;

        Expr r2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:253:3: (r1= relation_expr (op1= ( '==' | '!=' ) r2= relation_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:253:5: r1= relation_expr (op1= ( '==' | '!=' ) r2= relation_expr )*
            {
            pushFollow(FOLLOW_relation_expr_in_equal_expr1367);
            r1=relation_expr();

            state._fsp--;

            result = r1;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:254:5: (op1= ( '==' | '!=' ) r2= relation_expr )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=43 && LA20_0<=44)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:254:6: op1= ( '==' | '!=' ) r2= relation_expr
            	    {
            	    op1=(Token)input.LT(1);
            	    if ( (input.LA(1)>=43 && input.LA(1)<=44) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relation_expr_in_equal_expr1386);
            	    r2=relation_expr();

            	    state._fsp--;

            	    result = new EqualExpr((op1!=null?op1.getText():null), result, r2);

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "equal_expr"


    // $ANTLR start "relation_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:258:1: relation_expr returns [Expr result] : a1= add_expr (op1= ( '<' | '>' | '<=' | '>=' ) a2= add_expr )* ;
    public final Expr relation_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr a1 = null;

        Expr a2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:259:3: (a1= add_expr (op1= ( '<' | '>' | '<=' | '>=' ) a2= add_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:259:5: a1= add_expr (op1= ( '<' | '>' | '<=' | '>=' ) a2= add_expr )*
            {
            pushFollow(FOLLOW_add_expr_in_relation_expr1416);
            a1=add_expr();

            state._fsp--;

            result = a1;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:260:5: (op1= ( '<' | '>' | '<=' | '>=' ) a2= add_expr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=45 && LA21_0<=48)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:260:6: op1= ( '<' | '>' | '<=' | '>=' ) a2= add_expr
            	    {
            	    op1=(Token)input.LT(1);
            	    if ( (input.LA(1)>=45 && input.LA(1)<=48) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_add_expr_in_relation_expr1447);
            	    a2=add_expr();

            	    state._fsp--;

            	    result = new RelationExpr((op1!=null?op1.getLine():0), (op1!=null?op1.getText():null), result, a2);

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "relation_expr"


    // $ANTLR start "add_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:264:1: add_expr returns [Expr result] : m1= mult_expr (op1= ( '+' | '-' ) m2= mult_expr )* ;
    public final Expr add_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr m1 = null;

        Expr m2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:265:3: (m1= mult_expr (op1= ( '+' | '-' ) m2= mult_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:265:5: m1= mult_expr (op1= ( '+' | '-' ) m2= mult_expr )*
            {
            pushFollow(FOLLOW_mult_expr_in_add_expr1478);
            m1=mult_expr();

            state._fsp--;

            result = m1;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:266:5: (op1= ( '+' | '-' ) m2= mult_expr )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=49 && LA22_0<=50)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:266:6: op1= ( '+' | '-' ) m2= mult_expr
            	    {
            	    op1=(Token)input.LT(1);
            	    if ( (input.LA(1)>=49 && input.LA(1)<=50) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mult_expr_in_add_expr1500);
            	    m2=mult_expr();

            	    state._fsp--;

            	    result = new AddExpr((op1!=null?op1.getLine():0), (op1!=null?op1.getText():null), result, m2);

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "add_expr"


    // $ANTLR start "mult_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:270:1: mult_expr returns [Expr result] : c1= constructor_expr (op1= ( '*' | '/' | '%' ) c2= constructor_expr )* ;
    public final Expr mult_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr c1 = null;

        Expr c2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:271:3: (c1= constructor_expr (op1= ( '*' | '/' | '%' ) c2= constructor_expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:271:5: c1= constructor_expr (op1= ( '*' | '/' | '%' ) c2= constructor_expr )*
            {
            pushFollow(FOLLOW_constructor_expr_in_mult_expr1529);
            c1=constructor_expr();

            state._fsp--;

            result = c1; 
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:272:5: (op1= ( '*' | '/' | '%' ) c2= constructor_expr )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=51 && LA23_0<=53)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:272:6: op1= ( '*' | '/' | '%' ) c2= constructor_expr
            	    {
            	    op1=(Token)input.LT(1);
            	    if ( (input.LA(1)>=51 && input.LA(1)<=53) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_constructor_expr_in_mult_expr1555);
            	    c2=constructor_expr();

            	    state._fsp--;

            	    result = new MultExpr((op1!=null?op1.getLine():0), (op1!=null?op1.getText():null), result, c2);

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "mult_expr"


    // $ANTLR start "constructor_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:276:1: constructor_expr returns [Expr result] : (n1= 'new' typename ( ( '[' expr ']' ) | ( '(' ( expr_list )? ')' ) ) | unary_expr );
    public final Expr constructor_expr() throws RecognitionException {
        Expr result = null;

        Token n1=null;
        TypeDescriptor typename34 = null;

        Expr expr35 = null;

        List<Expr> expr_list36 = null;

        Expr unary_expr37 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:277:3: (n1= 'new' typename ( ( '[' expr ']' ) | ( '(' ( expr_list )? ')' ) ) | unary_expr )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==54) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=IDENT && LA26_0<=STRING_LITERAL)||LA26_0==13||(LA26_0>=49 && LA26_0<=50)||(LA26_0>=55 && LA26_0<=57)) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:277:5: n1= 'new' typename ( ( '[' expr ']' ) | ( '(' ( expr_list )? ')' ) )
                    {
                    n1=(Token)match(input,54,FOLLOW_54_in_constructor_expr1583); 
                    pushFollow(FOLLOW_typename_in_constructor_expr1585);
                    typename34=typename();

                    state._fsp--;

                    TypeDescriptor td = typename34;
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:278:5: ( ( '[' expr ']' ) | ( '(' ( expr_list )? ')' ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==19) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==13) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:279:7: ( '[' expr ']' )
                            {
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:279:7: ( '[' expr ']' )
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:279:10: '[' expr ']'
                            {
                            match(input,19,FOLLOW_19_in_constructor_expr1604); 
                            pushFollow(FOLLOW_expr_in_constructor_expr1606);
                            expr35=expr();

                            state._fsp--;

                            match(input,20,FOLLOW_20_in_constructor_expr1608); 
                            result = new ArrayConstructorExpr((n1!=null?n1.getLine():0), td, expr35);      

                            }


                            }
                            break;
                        case 2 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:280:7: ( '(' ( expr_list )? ')' )
                            {
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:280:7: ( '(' ( expr_list )? ')' )
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:280:9: '(' ( expr_list )? ')'
                            {
                            match(input,13,FOLLOW_13_in_constructor_expr1632); 
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:280:13: ( expr_list )?
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( ((LA24_0>=IDENT && LA24_0<=STRING_LITERAL)||LA24_0==13||(LA24_0>=49 && LA24_0<=50)||(LA24_0>=54 && LA24_0<=57)) ) {
                                alt24=1;
                            }
                            switch (alt24) {
                                case 1 :
                                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:280:13: expr_list
                                    {
                                    pushFollow(FOLLOW_expr_list_in_constructor_expr1634);
                                    expr_list36=expr_list();

                                    state._fsp--;


                                    }
                                    break;

                            }

                            match(input,14,FOLLOW_14_in_constructor_expr1637); 
                            result = new SimpleConstructorExpr((n1!=null?n1.getLine():0), td, expr_list36);

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:282:5: unary_expr
                    {
                    pushFollow(FOLLOW_unary_expr_in_constructor_expr1658);
                    unary_expr37=unary_expr();

                    state._fsp--;

                     result = unary_expr37; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "constructor_expr"


    // $ANTLR start "unary_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:285:1: unary_expr returns [Expr result] : (op1= ( '!' | '+' | '-' ) )? prefix_expr ;
    public final Expr unary_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr prefix_expr38 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:286:3: ( (op1= ( '!' | '+' | '-' ) )? prefix_expr )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:286:5: (op1= ( '!' | '+' | '-' ) )? prefix_expr
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:286:5: (op1= ( '!' | '+' | '-' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=49 && LA27_0<=50)||LA27_0==55) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:286:6: op1= ( '!' | '+' | '-' )
                    {
                    op1=(Token)input.LT(1);
                    if ( (input.LA(1)>=49 && input.LA(1)<=50)||input.LA(1)==55 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_prefix_expr_in_unary_expr1692);
            prefix_expr38=prefix_expr();

            state._fsp--;


            	   result = prefix_expr38;
            	   
            	   if(op1!=null)
            	     if((op1!=null?op1.getText():null).equals("!"))
            	     {result = new LogicalNotExpr((op1!=null?op1.getLine():0), result); }
            	     else if ((op1!=null?op1.getText():null).equals("-"))
            	     {result = new UnaryMinusExpr((op1!=null?op1.getLine():0), result); }
            	  // "+" ignoruje.
            	  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unary_expr"


    // $ANTLR start "prefix_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:299:1: prefix_expr returns [Expr result] : (op1= ( '--' | '++' ) )? term_expr ;
    public final Expr prefix_expr() throws RecognitionException {
        Expr result = null;

        Token op1=null;
        Expr term_expr39 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:300:3: ( (op1= ( '--' | '++' ) )? term_expr )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:300:5: (op1= ( '--' | '++' ) )? term_expr
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:300:5: (op1= ( '--' | '++' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=56 && LA28_0<=57)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:300:6: op1= ( '--' | '++' )
                    {
                    op1=(Token)input.LT(1);
                    if ( (input.LA(1)>=56 && input.LA(1)<=57) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_term_expr_in_prefix_expr1726);
            term_expr39=term_expr();

            state._fsp--;


                  result = term_expr39;
                  if(op1!=null)
                  {
                    result = new PrefixIncDecExpr((op1!=null?op1.getLine():0), (op1!=null?op1.getText():null), result);
                  } 
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "prefix_expr"


    // $ANTLR start "expr_list"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:310:1: expr_list returns [List<Expr> result] : e1= expr ( ',' e2= expr )* ;
    public final List<Expr> expr_list() throws RecognitionException {
        List<Expr> result = null;

        Expr e1 = null;

        Expr e2 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:311:3: (e1= expr ( ',' e2= expr )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:311:5: e1= expr ( ',' e2= expr )*
            {
            result = new ArrayList<Expr>(); 
            pushFollow(FOLLOW_expr_in_expr_list1757);
            e1=expr();

            state._fsp--;

            result.add(e1);
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:313:6: ( ',' e2= expr )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==15) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:313:7: ',' e2= expr
            	    {
            	    match(input,15,FOLLOW_15_in_expr_list1773); 
            	    pushFollow(FOLLOW_expr_in_expr_list1777);
            	    e2=expr();

            	    state._fsp--;

            	    result.add(e2);

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expr_list"


    // $ANTLR start "term_expr"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:318:1: term_expr returns [Expr result] : (l1= literal | identifier ( (op= ( '--' | '++' ) ) | ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+ )? | '(' e4= expr ')' );
    public final Expr term_expr() throws RecognitionException {
        Expr result = null;

        Token op=null;
        Token op1=null;
        Token op2=null;
        Token op3=null;
        Expr l1 = null;

        List<Expr> el1 = null;

        Expr e1 = null;

        Expr e2 = null;

        Expr e4 = null;

        JavaletteParser.identifier_return identifier40 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:319:3: (l1= literal | identifier ( (op= ( '--' | '++' ) ) | ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+ )? | '(' e4= expr ')' )
            int alt33=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
            case FLOAT_LITERAL:
            case DOUBLE_LITERAL:
            case LOGICAL_LITERAL:
            case STRING_LITERAL:
                {
                alt33=1;
                }
                break;
            case IDENT:
                {
                alt33=2;
                }
                break;
            case 13:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:319:5: l1= literal
                    {
                    pushFollow(FOLLOW_literal_in_term_expr1808);
                    l1=literal();

                    state._fsp--;

                    result = l1;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:320:5: identifier ( (op= ( '--' | '++' ) ) | ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+ )?
                    {
                    pushFollow(FOLLOW_identifier_in_term_expr1821);
                    identifier40=identifier();

                    state._fsp--;

                    result = new IdentifierExpr((identifier40!=null?identifier40.line:0), (identifier40!=null?input.toString(identifier40.start,identifier40.stop):null));
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:321:5: ( (op= ( '--' | '++' ) ) | ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+ )?
                    int alt32=3;
                    switch ( input.LA(1) ) {
                        case 56:
                        case 57:
                            {
                            alt32=1;
                            }
                            break;
                        case 13:
                            {
                            alt32=2;
                            }
                            break;
                        case 19:
                            {
                            alt32=2;
                            }
                            break;
                        case 58:
                            {
                            alt32=2;
                            }
                            break;
                    }

                    switch (alt32) {
                        case 1 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:321:7: (op= ( '--' | '++' ) )
                            {
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:321:7: (op= ( '--' | '++' ) )
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:321:9: op= ( '--' | '++' )
                            {
                            op=(Token)input.LT(1);
                            if ( (input.LA(1)>=56 && input.LA(1)<=57) ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            result = new SuffixIncDecExpr((op!=null?op.getLine():0), (op!=null?op.getText():null), result);

                            }


                            }
                            break;
                        case 2 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:323:7: ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+
                            {
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:323:7: ( (op1= '(' (el1= expr_list )? ')' ) | (op2= '[' e1= expr ']' ) | (op3= '.' e2= expr ) )+
                            int cnt31=0;
                            loop31:
                            do {
                                int alt31=4;
                                switch ( input.LA(1) ) {
                                case 13:
                                    {
                                    alt31=1;
                                    }
                                    break;
                                case 19:
                                    {
                                    alt31=2;
                                    }
                                    break;
                                case 58:
                                    {
                                    alt31=3;
                                    }
                                    break;

                                }

                                switch (alt31) {
                            	case 1 :
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:324:9: (op1= '(' (el1= expr_list )? ')' )
                            	    {
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:324:9: (op1= '(' (el1= expr_list )? ')' )
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:324:11: op1= '(' (el1= expr_list )? ')'
                            	    {
                            	    op1=(Token)match(input,13,FOLLOW_13_in_term_expr1876); 
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:324:22: (el1= expr_list )?
                            	    int alt30=2;
                            	    int LA30_0 = input.LA(1);

                            	    if ( ((LA30_0>=IDENT && LA30_0<=STRING_LITERAL)||LA30_0==13||(LA30_0>=49 && LA30_0<=50)||(LA30_0>=54 && LA30_0<=57)) ) {
                            	        alt30=1;
                            	    }
                            	    switch (alt30) {
                            	        case 1 :
                            	            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:324:22: el1= expr_list
                            	            {
                            	            pushFollow(FOLLOW_expr_list_in_term_expr1880);
                            	            el1=expr_list();

                            	            state._fsp--;


                            	            }
                            	            break;

                            	    }

                            	    match(input,14,FOLLOW_14_in_term_expr1883); 
                            	    result = new FuncallOperatorExpr((op1!=null?op1.getLine():0), el1, result); 

                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:325:11: (op2= '[' e1= expr ']' )
                            	    {
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:325:11: (op2= '[' e1= expr ']' )
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:325:12: op2= '[' e1= expr ']'
                            	    {
                            	    op2=(Token)match(input,19,FOLLOW_19_in_term_expr1904); 
                            	    pushFollow(FOLLOW_expr_in_term_expr1908);
                            	    e1=expr();

                            	    state._fsp--;

                            	    match(input,20,FOLLOW_20_in_term_expr1910); 
                            	    result = new IndexOperatorExpr((op2!=null?op2.getLine():0), result, e1); 

                            	    }


                            	    }
                            	    break;
                            	case 3 :
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:326:11: (op3= '.' e2= expr )
                            	    {
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:326:11: (op3= '.' e2= expr )
                            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:326:12: op3= '.' e2= expr
                            	    {
                            	    op3=(Token)match(input,58,FOLLOW_58_in_term_expr1937); 
                            	    pushFollow(FOLLOW_expr_in_term_expr1941);
                            	    e2=expr();

                            	    state._fsp--;

                            	    result = new DotOperatorExpr((op3!=null?op3.getLine():0), result, e2); 

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt31 >= 1 ) break loop31;
                                        EarlyExitException eee =
                                            new EarlyExitException(31, input);
                                        throw eee;
                                }
                                cnt31++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:329:5: '(' e4= expr ')'
                    {
                    match(input,13,FOLLOW_13_in_term_expr1978); 
                    pushFollow(FOLLOW_expr_in_term_expr1982);
                    e4=expr();

                    state._fsp--;

                    match(input,14,FOLLOW_14_in_term_expr1984); 
                    result = e4;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "term_expr"


    // $ANTLR start "literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:332:1: literal returns [Expr result] : ( integer_literal | float_literal | double_literal | logical_literal | string_literal );
    public final Expr literal() throws RecognitionException {
        Expr result = null;

        IntegerLiteralExpr integer_literal41 = null;

        FloatLiteralExpr float_literal42 = null;

        DoubleLiteralExpr double_literal43 = null;

        BooleanLiteralExpr logical_literal44 = null;

        StringLiteralExpr string_literal45 = null;


        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:333:3: ( integer_literal | float_literal | double_literal | logical_literal | string_literal )
            int alt34=5;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt34=1;
                }
                break;
            case FLOAT_LITERAL:
                {
                alt34=2;
                }
                break;
            case DOUBLE_LITERAL:
                {
                alt34=3;
                }
                break;
            case LOGICAL_LITERAL:
                {
                alt34=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt34=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:333:5: integer_literal
                    {
                    pushFollow(FOLLOW_integer_literal_in_literal2004);
                    integer_literal41=integer_literal();

                    state._fsp--;

                    result = integer_literal41;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:334:5: float_literal
                    {
                    pushFollow(FOLLOW_float_literal_in_literal2012);
                    float_literal42=float_literal();

                    state._fsp--;

                    result = float_literal42;

                    }
                    break;
                case 3 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:335:5: double_literal
                    {
                    pushFollow(FOLLOW_double_literal_in_literal2022);
                    double_literal43=double_literal();

                    state._fsp--;

                    result = double_literal43;

                    }
                    break;
                case 4 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:336:5: logical_literal
                    {
                    pushFollow(FOLLOW_logical_literal_in_literal2031);
                    logical_literal44=logical_literal();

                    state._fsp--;

                    result = logical_literal44;

                    }
                    break;
                case 5 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:337:5: string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_literal2039);
                    string_literal45=string_literal();

                    state._fsp--;

                    result = string_literal45;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "literal"


    // $ANTLR start "integer_literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:340:1: integer_literal returns [IntegerLiteralExpr result] : INTEGER_LITERAL ;
    public final IntegerLiteralExpr integer_literal() throws RecognitionException {
        IntegerLiteralExpr result = null;

        Token INTEGER_LITERAL46=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:341:3: ( INTEGER_LITERAL )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:341:5: INTEGER_LITERAL
            {
            INTEGER_LITERAL46=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_integer_literal2059); 
            result = new IntegerLiteralExpr((INTEGER_LITERAL46!=null?INTEGER_LITERAL46.getLine():0), (INTEGER_LITERAL46!=null?INTEGER_LITERAL46.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "integer_literal"


    // $ANTLR start "float_literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:344:1: float_literal returns [FloatLiteralExpr result] : FLOAT_LITERAL ;
    public final FloatLiteralExpr float_literal() throws RecognitionException {
        FloatLiteralExpr result = null;

        Token FLOAT_LITERAL47=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:345:3: ( FLOAT_LITERAL )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:345:5: FLOAT_LITERAL
            {
            FLOAT_LITERAL47=(Token)match(input,FLOAT_LITERAL,FOLLOW_FLOAT_LITERAL_in_float_literal2080); 
            result = new FloatLiteralExpr((FLOAT_LITERAL47!=null?FLOAT_LITERAL47.getLine():0), (FLOAT_LITERAL47!=null?FLOAT_LITERAL47.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "float_literal"


    // $ANTLR start "double_literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:348:1: double_literal returns [DoubleLiteralExpr result] : DOUBLE_LITERAL ;
    public final DoubleLiteralExpr double_literal() throws RecognitionException {
        DoubleLiteralExpr result = null;

        Token DOUBLE_LITERAL48=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:349:3: ( DOUBLE_LITERAL )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:349:5: DOUBLE_LITERAL
            {
            DOUBLE_LITERAL48=(Token)match(input,DOUBLE_LITERAL,FOLLOW_DOUBLE_LITERAL_in_double_literal2099); 
            result = new DoubleLiteralExpr((DOUBLE_LITERAL48!=null?DOUBLE_LITERAL48.getLine():0), (DOUBLE_LITERAL48!=null?DOUBLE_LITERAL48.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "double_literal"


    // $ANTLR start "logical_literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:352:1: logical_literal returns [BooleanLiteralExpr result] : LOGICAL_LITERAL ;
    public final BooleanLiteralExpr logical_literal() throws RecognitionException {
        BooleanLiteralExpr result = null;

        Token LOGICAL_LITERAL49=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:353:3: ( LOGICAL_LITERAL )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:353:5: LOGICAL_LITERAL
            {
            LOGICAL_LITERAL49=(Token)match(input,LOGICAL_LITERAL,FOLLOW_LOGICAL_LITERAL_in_logical_literal2120); 
            result = new BooleanLiteralExpr((LOGICAL_LITERAL49!=null?LOGICAL_LITERAL49.getLine():0),(LOGICAL_LITERAL49!=null?LOGICAL_LITERAL49.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "logical_literal"


    // $ANTLR start "string_literal"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:356:1: string_literal returns [StringLiteralExpr result] : STRING_LITERAL ;
    public final StringLiteralExpr string_literal() throws RecognitionException {
        StringLiteralExpr result = null;

        Token STRING_LITERAL50=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:357:3: ( STRING_LITERAL )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:357:5: STRING_LITERAL
            {
            STRING_LITERAL50=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_string_literal2139); 
            result = new StringLiteralExpr((STRING_LITERAL50!=null?STRING_LITERAL50.getLine():0), (STRING_LITERAL50!=null?STRING_LITERAL50.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "string_literal"

    public static class identifier_return extends ParserRuleReturnScope {
        public String result;
        public int line;
    };

    // $ANTLR start "identifier"
    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:360:1: identifier returns [String result, int line] : IDENT ;
    public final JavaletteParser.identifier_return identifier() throws RecognitionException {
        JavaletteParser.identifier_return retval = new JavaletteParser.identifier_return();
        retval.start = input.LT(1);

        Token IDENT51=null;

        try {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:361:3: ( IDENT )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:361:5: IDENT
            {
            IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_identifier2159); 
            retval.result = (IDENT51!=null?IDENT51.getText():null); retval.line = (IDENT51!=null?IDENT51.getLine():0);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA5_eotS =
        "\17\uffff";
    static final String DFA5_eofS =
        "\17\uffff";
    static final String DFA5_minS =
        "\1\4\1\uffff\7\4\1\24\1\15\1\uffff\1\4\2\uffff";
    static final String DFA5_maxS =
        "\1\32\1\uffff\7\23\1\24\1\34\1\uffff\1\23\2\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\4\11\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA5_specialS =
        "\17\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\10\15\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7",
            "",
            "\1\12\16\uffff\1\11",
            "\1\12\16\uffff\1\11",
            "\1\12\16\uffff\1\11",
            "\1\12\16\uffff\1\11",
            "\1\12\16\uffff\1\11",
            "\1\12\16\uffff\1\11",
            "\1\12\10\uffff\1\13\5\uffff\1\11",
            "\1\14",
            "\1\15\1\uffff\1\16\13\uffff\2\16",
            "",
            "\1\12\16\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 88:5: ( ( declaration_stmt ) | ( function_definition ) | ( constructor_definition ) )*";
        }
    }
    static final String DFA6_eotS =
        "\13\uffff";
    static final String DFA6_eofS =
        "\13\uffff";
    static final String DFA6_minS =
        "\10\4\1\uffff\1\4\1\uffff";
    static final String DFA6_maxS =
        "\1\32\7\23\1\uffff\1\71\1\uffff";
    static final String DFA6_acceptS =
        "\10\uffff\1\2\1\uffff\1\1";
    static final String DFA6_specialS =
        "\13\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\7\20\uffff\1\1\1\2\1\3\1\4\1\5\1\6",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "\1\10\10\uffff\1\10\5\uffff\1\11",
            "",
            "\6\10\3\uffff\1\10\6\uffff\1\12\34\uffff\2\10\3\uffff\4\10",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "106:1: typename returns [TypeDescriptor result] : ( array_type | unit_type );";
        }
    }
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\1\4\5\uffff\1\4";
    static final String DFA10_maxS =
        "\1\71\2\uffff\1\72\5\uffff\1\71";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\uffff";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\5\7\3\uffff\1\7\3\uffff\1\1\3\uffff\6\2\1\10\1\uffff\1"+
            "\4\1\uffff\2\5\1\6\17\uffff\2\7\3\uffff\4\7",
            "",
            "",
            "\1\2\10\uffff\1\7\5\uffff\1\11\7\uffff\2\7\5\uffff\24\7\2\uffff"+
            "\3\7",
            "",
            "",
            "",
            "",
            "",
            "\6\7\3\uffff\1\7\6\uffff\1\2\34\uffff\2\7\3\uffff\4\7"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "136:1: stmt returns [Stmt result] : ( compound_stmt | declaration_stmt | if_stmt | loop_stmt | return_stmt | expr_stmt | empty_stmt );";
        }
    }
 

    public static final BitSet FOLLOW_class_definition_in_program67 = new BitSet(new long[]{0x0000000007E10012L});
    public static final BitSet FOLLOW_function_definition_in_program81 = new BitSet(new long[]{0x0000000007E00012L});
    public static final BitSet FOLLOW_typename_in_function_definition112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_function_definition114 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_function_definition116 = new BitSet(new long[]{0x0000000007E04010L});
    public static final BitSet FOLLOW_argument_list_in_function_definition118 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_definition120 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_compound_stmt_in_function_definition122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_constructor_definition148 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_constructor_definition150 = new BitSet(new long[]{0x0000000007E04010L});
    public static final BitSet FOLLOW_argument_list_in_constructor_definition152 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_constructor_definition154 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_compound_stmt_in_constructor_definition156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typename_in_argument_list197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_argument_list201 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_argument_list218 = new BitSet(new long[]{0x0000000007E00010L});
    public static final BitSet FOLLOW_typename_in_argument_list222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_argument_list226 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_16_in_class_definition268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_class_definition270 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_class_definition276 = new BitSet(new long[]{0x0000000007E40010L});
    public static final BitSet FOLLOW_declaration_stmt_in_class_definition292 = new BitSet(new long[]{0x0000000007E40010L});
    public static final BitSet FOLLOW_function_definition_in_class_definition323 = new BitSet(new long[]{0x0000000007E40010L});
    public static final BitSet FOLLOW_constructor_definition_in_class_definition388 = new BitSet(new long[]{0x0000000007E40010L});
    public static final BitSet FOLLOW_18_in_class_definition411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_type_in_typename442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unit_type_in_typename452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_type_in_unit_type476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_named_type_in_unit_type485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unit_type_in_array_type511 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_array_type520 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_array_type522 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_21_in_primitive_type551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_primitive_type559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_primitive_type570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_primitive_type582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_primitive_type591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_primitive_type600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_named_type623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_stmt_in_stmt649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_stmt_in_stmt663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_stmt674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_stmt_in_stmt694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_stmt_in_stmt712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_stmt_in_stmt728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_empty_stmt_in_stmt746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_empty_stmt780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_compound_stmt808 = new BitSet(new long[]{0x03C60003AFE623F0L});
    public static final BitSet FOLLOW_stmt_list_in_compound_stmt810 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_compound_stmt812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_stmt_list841 = new BitSet(new long[]{0x03C60003AFE223F2L});
    public static final BitSet FOLLOW_typename_in_declaration_stmt871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declarator_in_declaration_stmt880 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_15_in_declaration_stmt889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declarator_in_declaration_stmt893 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_27_in_declaration_stmt908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_declarator927 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declarator930 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_declarator932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expr_stmt955 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_expr_stmt957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_if_stmt980 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_if_stmt982 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_if_stmt986 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_stmt988 = new BitSet(new long[]{0x03C60003AFE223F0L});
    public static final BitSet FOLLOW_stmt_in_if_stmt992 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_if_stmt995 = new BitSet(new long[]{0x03C60003AFE223F0L});
    public static final BitSet FOLLOW_stmt_in_if_stmt999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_loop_stmt1024 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_loop_stmt1026 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_loop_stmt1030 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_loop_stmt1032 = new BitSet(new long[]{0x03C60003AFE223F0L});
    public static final BitSet FOLLOW_stmt_in_loop_stmt1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_loop_stmt1046 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_loop_stmt1048 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_loop_stmt1052 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_loop_stmt1054 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_loop_stmt1058 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_loop_stmt1060 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_loop_stmt1064 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_loop_stmt1066 = new BitSet(new long[]{0x03C60003AFE223F0L});
    public static final BitSet FOLLOW_stmt_in_loop_stmt1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_return_stmt1093 = new BitSet(new long[]{0x03C60000080023F0L});
    public static final BitSet FOLLOW_expr_in_return_stmt1095 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_return_stmt1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignment_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expr_in_expr1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_or_expr_in_assignment_expr1214 = new BitSet(new long[]{0x000001FC10000002L});
    public static final BitSet FOLLOW_assignment_operator_in_assignment_expr1225 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_logical_or_expr_in_assignment_expr1229 = new BitSet(new long[]{0x000001FC10000002L});
    public static final BitSet FOLLOW_logical_and_expr_in_logical_or_expr1276 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_logical_or_expr1287 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_logical_and_expr_in_logical_or_expr1291 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_equal_expr_in_logical_and_expr1321 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_logical_and_expr1333 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_equal_expr_in_logical_and_expr1337 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_relation_expr_in_equal_expr1367 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_set_in_equal_expr1378 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_relation_expr_in_equal_expr1386 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_add_expr_in_relation_expr1416 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_set_in_relation_expr1429 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_add_expr_in_relation_expr1447 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_mult_expr_in_add_expr1478 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_set_in_add_expr1490 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_mult_expr_in_add_expr1500 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_constructor_expr_in_mult_expr1529 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_set_in_mult_expr1541 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_constructor_expr_in_mult_expr1555 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_54_in_constructor_expr1583 = new BitSet(new long[]{0x0000000007E00010L});
    public static final BitSet FOLLOW_typename_in_constructor_expr1585 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_19_in_constructor_expr1604 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_constructor_expr1606 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_constructor_expr1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_constructor_expr1632 = new BitSet(new long[]{0x03C60000000063F0L});
    public static final BitSet FOLLOW_expr_list_in_constructor_expr1634 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_constructor_expr1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expr_in_constructor_expr1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unary_expr1682 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_prefix_expr_in_unary_expr1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_prefix_expr1718 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_term_expr_in_prefix_expr1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expr_list1757 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_expr_list1773 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_expr_list1777 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_literal_in_term_expr1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_term_expr1821 = new BitSet(new long[]{0x0700000000082002L});
    public static final BitSet FOLLOW_set_in_term_expr1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_term_expr1876 = new BitSet(new long[]{0x03C60000000063F0L});
    public static final BitSet FOLLOW_expr_list_in_term_expr1880 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_term_expr1883 = new BitSet(new long[]{0x0400000000082002L});
    public static final BitSet FOLLOW_19_in_term_expr1904 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_term_expr1908 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_term_expr1910 = new BitSet(new long[]{0x0400000000082002L});
    public static final BitSet FOLLOW_58_in_term_expr1937 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_term_expr1941 = new BitSet(new long[]{0x0400000000082002L});
    public static final BitSet FOLLOW_13_in_term_expr1978 = new BitSet(new long[]{0x03C60000000023F0L});
    public static final BitSet FOLLOW_expr_in_term_expr1982 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_term_expr1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_literal_in_literal2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_float_literal_in_literal2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_double_literal_in_literal2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_literal_in_literal2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_literal2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_integer_literal2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_LITERAL_in_float_literal2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_LITERAL_in_double_literal2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICAL_LITERAL_in_logical_literal2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_string_literal2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identifier2159 = new BitSet(new long[]{0x0000000000000002L});

}