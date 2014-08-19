// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/akuda/school/JETcompiler/src/jet/Javalette.g 2011-01-23 21:38:37

package jet;
import jet.tree.*;
import jet.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JavaletteLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int BAD_COMMENT=12;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int DOUBLE_LITERAL=7;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__19=19;
    public static final int T__56=56;
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
    public static final int T__33=33;
    public static final int WS=10;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int INTEGER_LITERAL=5;

      @Override
      public void reportError(RecognitionException e) {
        throw new IllegalArgumentException(e);
      }
      


    // delegates
    // delegators

    public JavaletteLexer() {;} 
    public JavaletteLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JavaletteLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/akuda/school/JETcompiler/src/jet/Javalette.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:20:7: ( '(' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:20:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:21:7: ( ')' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:21:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:22:7: ( ',' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:22:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:23:7: ( 'class' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:23:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:24:7: ( '{' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:24:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:25:7: ( '}' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:25:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:26:7: ( '[' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:26:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:27:7: ( ']' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:27:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:28:7: ( 'boolean' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:28:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:29:7: ( 'void' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:29:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:30:7: ( 'int' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:30:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:31:7: ( 'double' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:31:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:32:7: ( 'string' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:32:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:33:7: ( 'float' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:33:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:34:7: ( ';' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:34:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:35:7: ( '=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:35:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:36:7: ( 'if' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:36:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:37:7: ( 'else' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:37:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:38:7: ( 'while' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:38:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:39:7: ( 'for' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:39:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:40:7: ( 'return' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:40:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:41:7: ( '+=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:41:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:42:7: ( '-=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:42:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:43:7: ( '*=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:43:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:44:7: ( '/=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:44:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:45:7: ( '%=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:45:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:46:7: ( '<<=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:46:9: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:47:7: ( '>>=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:47:9: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:48:7: ( '||' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:48:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:49:7: ( '&&' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:49:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:50:7: ( '==' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:50:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:51:7: ( '!=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:51:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:52:7: ( '<' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:52:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:53:7: ( '>' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:53:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:54:7: ( '<=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:54:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:55:7: ( '>=' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:55:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:56:7: ( '+' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:56:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:57:7: ( '-' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:57:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:58:7: ( '*' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:58:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:59:7: ( '/' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:59:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:60:7: ( '%' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:60:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:61:7: ( 'new' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:61:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:62:7: ( '!' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:62:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:63:7: ( '--' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:63:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:64:7: ( '++' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:64:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:65:7: ( '.' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:65:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "INTEGER_LITERAL"
    public final void mINTEGER_LITERAL() throws RecognitionException {
        try {
            int _type = INTEGER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:366:17: ( ( '0' .. '9' )+ )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:366:19: ( '0' .. '9' )+
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:366:19: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:366:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_LITERAL"

    // $ANTLR start "FLOAT_LITERAL"
    public final void mFLOAT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOAT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:367:15: ( ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) | ( '.' ( '0' .. '9' )+ ) ) )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:367:24: ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) | ( '.' ( '0' .. '9' )+ ) )
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:367:24: ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) | ( '.' ( '0' .. '9' )+ ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='.') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:25: ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* )
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:25: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    match('.'); 
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:39: ( ( '0' .. '9' )* )
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:40: ( '0' .. '9' )*
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:40: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:368:41: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:369:27: ( '.' ( '0' .. '9' )+ )
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:369:27: ( '.' ( '0' .. '9' )+ )
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:369:28: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:369:31: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:369:32: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_LITERAL"

    // $ANTLR start "DOUBLE_LITERAL"
    public final void mDOUBLE_LITERAL() throws RecognitionException {
        try {
            int _type = DOUBLE_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:372:16: ( ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) 'd' | ( '.' ( '0' .. '9' )+ ) 'd' ) )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:372:25: ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) 'd' | ( '.' ( '0' .. '9' )+ ) 'd' )
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:372:25: ( ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) 'd' | ( '.' ( '0' .. '9' )+ ) 'd' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='.') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:25: ( '0' .. '9' )+ '.' ( ( '0' .. '9' )* ) 'd'
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:25: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    match('.'); 
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:39: ( ( '0' .. '9' )* )
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:40: ( '0' .. '9' )*
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:40: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:373:41: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }

                    match('d'); 

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:374:27: ( '.' ( '0' .. '9' )+ ) 'd'
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:374:27: ( '.' ( '0' .. '9' )+ )
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:374:28: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:374:31: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:374:32: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    match('d'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_LITERAL"

    // $ANTLR start "LOGICAL_LITERAL"
    public final void mLOGICAL_LITERAL() throws RecognitionException {
        try {
            int _type = LOGICAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:377:17: ( ( 'true' | 'false' ) )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:377:19: ( 'true' | 'false' )
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:377:19: ( 'true' | 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='t') ) {
                alt10=1;
            }
            else if ( (LA10_0=='f') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:377:20: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:377:29: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICAL_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:378:16: ( '\"' ( . )* '\"' )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:378:18: '\"' ( . )* '\"'
            {
            match('\"'); 
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:378:22: ( . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\"') ) {
                    alt11=2;
                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:378:22: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:382:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:382:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:382:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:384:4: ( ( ' ' | '\\n' | '\\t' | '\\r' | '\\f' )+ )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:384:6: ( ' ' | '\\n' | '\\t' | '\\r' | '\\f' )+
            {
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:384:6: ( ' ' | '\\n' | '\\t' | '\\r' | '\\f' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||(LA13_0>='\f' && LA13_0<='\r')||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:3: ( ( '//' | '#' ) ( . )* ( '\\n' | '\\r' ) | '/*' ( . )* '*/' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='/') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='/') ) {
                    alt17=1;
                }
                else if ( (LA17_1=='*') ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA17_0=='#') ) {
                alt17=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:5: ( '//' | '#' ) ( . )* ( '\\n' | '\\r' )
                    {
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:5: ( '//' | '#' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='/') ) {
                        alt14=1;
                    }
                    else if ( (LA14_0=='#') ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:6: '//'
                            {
                            match("//"); 


                            }
                            break;
                        case 2 :
                            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:13: '#'
                            {
                            match('#'); 

                            }
                            break;

                    }

                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:18: ( . )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                            alt15=2;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:387:18: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    _channel = HIDDEN;

                    }
                    break;
                case 2 :
                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:388:5: '/*' ( . )* '*/'
                    {
                    match("/*"); 

                    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:388:10: ( . )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='*') ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1=='/') ) {
                                alt16=2;
                            }
                            else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                                alt16=1;
                            }


                        }
                        else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:388:10: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match("*/"); 

                    _channel = HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "BAD_COMMENT"
    public final void mBAD_COMMENT() throws RecognitionException {
        try {
            int _type = BAD_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken c=null;

            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:13: (c= '/*' (~ ( '*' ) | ( '*' ~ ( '/' ) ) )* )
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:14: c= '/*' (~ ( '*' ) | ( '*' ~ ( '/' ) ) )*
            {
            int cStart = getCharIndex();
            match("/*"); 
            c = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, cStart, getCharIndex()-1);
            // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:20: (~ ( '*' ) | ( '*' ~ ( '/' ) ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\u0000' && LA18_0<=')')||(LA18_0>='+' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }
                else if ( (LA18_0=='*') ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:22: ~ ( '*' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:31: ( '*' ~ ( '/' ) )
            	    {
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:31: ( '*' ~ ( '/' ) )
            	    // /home/akuda/school/JETcompiler/src/jet/Javalette.g:391:33: '*' ~ ( '/' )
            	    {
            	    match('*'); 
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            EarlyExitException e = new EarlyExitException(); e.token = c; reportError(e);

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BAD_COMMENT"

    public void mTokens() throws RecognitionException {
        // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | INTEGER_LITERAL | FLOAT_LITERAL | DOUBLE_LITERAL | LOGICAL_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | BAD_COMMENT )
        int alt19=55;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:286: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 

                }
                break;
            case 48 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:302: FLOAT_LITERAL
                {
                mFLOAT_LITERAL(); 

                }
                break;
            case 49 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:316: DOUBLE_LITERAL
                {
                mDOUBLE_LITERAL(); 

                }
                break;
            case 50 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:331: LOGICAL_LITERAL
                {
                mLOGICAL_LITERAL(); 

                }
                break;
            case 51 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:347: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 52 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:362: IDENT
                {
                mIDENT(); 

                }
                break;
            case 53 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:368: WS
                {
                mWS(); 

                }
                break;
            case 54 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:371: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 55 :
                // /home/akuda/school/JETcompiler/src/jet/Javalette.g:1:379: BAD_COMMENT
                {
                mBAD_COMMENT(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\4\uffff\1\43\4\uffff\6\43\1\uffff\1\61\3\43\1\67\1\72\1\74\1\77"+
        "\1\101\1\104\1\107\2\uffff\1\111\1\43\1\114\1\116\1\43\4\uffff\4"+
        "\43\1\124\5\43\2\uffff\3\43\11\uffff\1\137\13\uffff\1\43\1\142\1"+
        "\uffff\1\142\1\uffff\4\43\1\150\1\uffff\3\43\1\154\4\43\1\uffff"+
        "\1\137\1\uffff\1\163\2\uffff\1\142\3\43\1\167\1\uffff\3\43\1\uffff"+
        "\1\43\1\174\2\43\2\137\1\uffff\1\u0080\1\u0081\1\43\1\uffff\2\43"+
        "\1\u0085\1\u0080\1\uffff\1\u0086\1\43\1\45\2\uffff\1\43\1\u0089"+
        "\1\u008a\2\uffff\1\u008b\1\u008c\4\uffff";
    static final String DFA19_eofS =
        "\u008d\uffff";
    static final String DFA19_minS =
        "\1\11\3\uffff\1\154\4\uffff\2\157\1\146\1\157\1\164\1\141\1\uffff"+
        "\1\75\1\154\1\150\1\145\1\53\1\55\1\75\1\52\1\75\1\74\1\75\2\uffff"+
        "\1\75\1\145\1\60\1\56\1\162\4\uffff\1\141\1\157\1\151\1\164\1\60"+
        "\1\165\1\162\1\157\1\162\1\154\2\uffff\1\163\1\151\1\164\11\uffff"+
        "\1\0\13\uffff\1\167\1\60\1\uffff\1\60\1\uffff\1\165\1\163\1\154"+
        "\1\144\1\60\1\uffff\1\142\1\151\1\141\1\60\1\163\1\145\1\154\1\165"+
        "\2\0\1\uffff\1\60\2\uffff\1\60\1\145\1\163\1\145\1\60\1\uffff\1"+
        "\154\1\156\1\164\1\uffff\1\145\1\60\1\145\1\162\2\0\1\uffff\2\60"+
        "\1\141\1\uffff\1\145\1\147\2\60\1\uffff\1\60\1\156\1\0\2\uffff\1"+
        "\156\2\60\2\uffff\2\60\4\uffff";
    static final String DFA19_maxS =
        "\1\175\3\uffff\1\154\4\uffff\2\157\1\156\1\157\1\164\1\157\1\uffff"+
        "\1\75\1\154\1\150\1\145\6\75\1\76\2\uffff\1\75\1\145\2\71\1\162"+
        "\4\uffff\1\141\1\157\1\151\1\164\1\172\1\165\1\162\1\157\1\162\1"+
        "\154\2\uffff\1\163\1\151\1\164\11\uffff\1\uffff\13\uffff\1\167\1"+
        "\144\1\uffff\1\144\1\uffff\1\165\1\163\1\154\1\144\1\172\1\uffff"+
        "\1\142\1\151\1\141\1\172\1\163\1\145\1\154\1\165\2\uffff\1\uffff"+
        "\1\172\2\uffff\1\144\1\145\1\163\1\145\1\172\1\uffff\1\154\1\156"+
        "\1\164\1\uffff\1\145\1\172\1\145\1\162\2\uffff\1\uffff\2\172\1\141"+
        "\1\uffff\1\145\1\147\2\172\1\uffff\1\172\1\156\1\uffff\2\uffff\1"+
        "\156\2\172\2\uffff\2\172\4\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\6\uffff\1\17\13\uffff"+
        "\1\35\1\36\5\uffff\1\63\1\64\1\65\1\66\12\uffff\1\37\1\20\3\uffff"+
        "\1\26\1\55\1\45\1\27\1\54\1\46\1\30\1\47\1\31\1\uffff\1\50\1\32"+
        "\1\51\1\33\1\43\1\41\1\34\1\44\1\42\1\40\1\53\2\uffff\1\56\1\uffff"+
        "\1\57\5\uffff\1\21\12\uffff\1\67\1\uffff\1\61\1\60\5\uffff\1\13"+
        "\3\uffff\1\24\6\uffff\1\52\3\uffff\1\12\4\uffff\1\22\3\uffff\1\62"+
        "\1\4\3\uffff\1\16\1\23\2\uffff\1\14\1\15\1\25\1\11";
    static final String DFA19_specialS =
        "\76\uffff\1\2\36\uffff\1\1\1\5\22\uffff\1\0\1\3\14\uffff\1\4\15"+
        "\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\44\1\uffff\2\44\22\uffff\1\44\1\35\1\42\1\45\1\uffff\1\30"+
            "\1\34\1\uffff\1\1\1\2\1\26\1\24\1\3\1\25\1\37\1\27\12\40\1\uffff"+
            "\1\17\1\31\1\20\1\32\2\uffff\32\43\1\7\1\uffff\1\10\1\uffff"+
            "\1\43\1\uffff\1\43\1\11\1\4\1\14\1\21\1\16\2\43\1\13\4\43\1"+
            "\36\3\43\1\23\1\15\1\41\1\43\1\12\1\22\3\43\1\5\1\33\1\6",
            "",
            "",
            "",
            "\1\46",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\52\7\uffff\1\51",
            "\1\53",
            "\1\54",
            "\1\57\12\uffff\1\55\2\uffff\1\56",
            "",
            "\1\60",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\66\21\uffff\1\65",
            "\1\71\17\uffff\1\70",
            "\1\73",
            "\1\76\4\uffff\1\45\15\uffff\1\75",
            "\1\100",
            "\1\102\1\103",
            "\1\106\1\105",
            "",
            "",
            "\1\110",
            "\1\112",
            "\12\113",
            "\1\115\1\uffff\12\40",
            "\1\117",
            "",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\52\136\1\135\uffd5\136",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\140",
            "\12\113\52\uffff\1\141",
            "",
            "\12\143\52\uffff\1\141",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\52\162\1\161\4\162\1\45\uffd0\162",
            "\52\136\1\135\uffd5\136",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\12\143\52\uffff\1\141",
            "\1\164",
            "\1\165",
            "\1\166",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "\1\173",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\175",
            "\1\176",
            "\52\136\1\135\4\136\1\177\uffd0\136",
            "\52\136\1\135\uffd5\136",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u0087",
            "\52\136\1\135\uffd5\136",
            "",
            "",
            "\1\u0088",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | INTEGER_LITERAL | FLOAT_LITERAL | DOUBLE_LITERAL | LOGICAL_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | BAD_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_113 = input.LA(1);

                        s = -1;
                        if ( (LA19_113=='/') ) {s = 127;}

                        else if ( ((LA19_113>='\u0000' && LA19_113<=')')||(LA19_113>='+' && LA19_113<='.')||(LA19_113>='0' && LA19_113<='\uFFFF')) ) {s = 94;}

                        else if ( (LA19_113=='*') ) {s = 93;}

                        else s = 95;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_93 = input.LA(1);

                        s = -1;
                        if ( (LA19_93=='/') ) {s = 37;}

                        else if ( (LA19_93=='*') ) {s = 113;}

                        else if ( ((LA19_93>='\u0000' && LA19_93<=')')||(LA19_93>='+' && LA19_93<='.')||(LA19_93>='0' && LA19_93<='\uFFFF')) ) {s = 114;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_62 = input.LA(1);

                        s = -1;
                        if ( (LA19_62=='*') ) {s = 93;}

                        else if ( ((LA19_62>='\u0000' && LA19_62<=')')||(LA19_62>='+' && LA19_62<='\uFFFF')) ) {s = 94;}

                        else s = 95;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_114 = input.LA(1);

                        s = -1;
                        if ( ((LA19_114>='\u0000' && LA19_114<=')')||(LA19_114>='+' && LA19_114<='\uFFFF')) ) {s = 94;}

                        else if ( (LA19_114=='*') ) {s = 93;}

                        else s = 95;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_127 = input.LA(1);

                        s = -1;
                        if ( ((LA19_127>='\u0000' && LA19_127<=')')||(LA19_127>='+' && LA19_127<='\uFFFF')) ) {s = 94;}

                        else if ( (LA19_127=='*') ) {s = 93;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_94 = input.LA(1);

                        s = -1;
                        if ( ((LA19_94>='\u0000' && LA19_94<=')')||(LA19_94>='+' && LA19_94<='\uFFFF')) ) {s = 94;}

                        else if ( (LA19_94=='*') ) {s = 93;}

                        else s = 95;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}