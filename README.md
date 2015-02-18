# coverity
A calculator program in Java that evaluates expressions in a very simple integer expression language. The program takes an input on the command line, computes the result, and prints it to the console.  

Example:
$ java -jar calculator-0.1.0.jar "let(a, let(b, 10, add(b, b)), let(b, 20, add(a, b)))"
40
