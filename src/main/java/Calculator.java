package main.java;

/**
 * Created by bfors on 2/9/15.
 */
import org.antlr.runtime.*;

public class Calculator {
    public static void main(String[] args) throws Exception {
        // Create an input character stream from standard in
        ANTLRStringStream input = new ANTLRStringStream(args[0]);
        // Create an ExprLexer that feeds from that stream
        main.java.CalculatorLexer lexer = new main.java.CalculatorLexer(input);
        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the token stream
        main.java.CalculatorParser parser = new main.java.CalculatorParser(tokens);
        // Begin parsing at rule prog, get return value structure
        parser.prog();
    }
}
