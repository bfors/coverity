grammar Calculator;

@lexer::header {
package antlr;
}

@parser::header {
package antlr;
import java.util.HashMap;
}

@members {
//Map variable name to Integer object holding value
HashMap memory = new HashMap();
}

prog:   exp {System.out.println($exp.value);}
        ;

exp returns [int value]
    :   e=numExp {$value = $e.value;}
    |   e=varExp {$value = $e.value;}
    |   e=addExp {$value = $e.value;}
    |   e=subExp {$value = $e.value;}
    |   e=multExp {$value = $e.value;}
    |   e=divExp {$value = $e.value;}
    |   e=letExp{$value = $e.value;}
    ;

varExp returns [int value]
    :	ID //Variable reference
        {
        //Look up value of variable
        Integer v = (Integer)memory.get($ID.text);
        if ( v!=null )
            $value = v.intValue();
        else
            System.err.println("Undefined variable "+$ID.text);
        }
    ;

numExp returns [int value]
    :   INT {$value = Integer.parseInt($INT.text);}
    ;

//add(<exp>, <exp>)
addExp returns [int value]
    :   'add' '(' e1=exp ',' e2=exp ')' {$value = $e1.value + $e2.value;}
    ;

//sub(<exp>, <exp>)
subExp returns [int value]
    :   'sub' '(' e1=exp ',' e2=exp ')' {$value = $e1.value - $e2.value;}
    ;

//mult(<exp>, <exp>)
multExp returns [int value]
    :   'mult' '(' e1=exp ',' e2=exp ')' {$value = $e1.value * $e2.value;}
    ;

//div(<exp>, <exp>)
divExp returns [int value]
    :   'div' '(' e1=exp ',' e2=exp ')' {$value = $e1.value / $e2.value;}
    ;

//let(<ID>, <exp>, <exp>)
letExp returns [int value]
    :   'let' '(' v=ID','
                  e=exp ',' {memory.put($v.text, new Integer($e.value));}  //Must be executed before the body
                  body=exp ')' {$value = $body.value;}
    ;

//Tokens
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;