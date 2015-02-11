grammar Calculator;

options
{
  language = Java;
  output = AST;
}

@lexer::header {
package main.java;
}

@parser::header {
package main.java;
}

// lexer rules:
//the grammar must contain at least one lexer rule

 exp :
		addexp
		| numexp
		;


 numexp :
 	    Number
 	    ;

 addexp :
        'add' '(' exp ',' exp')'
        ;

//ENDSYMBOL:'!';


// parser rules:
 expression : exp;

 Number : DIGIT+ ;
 fragment DIGIT: ('0'..'9');