package main.java;

/**
 * Created by bfors on 2/9/15.
 */
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) throws Exception {

        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");

        // Create a String stream from first argument
        ANTLRStringStream input = new ANTLRStringStream(args[0]);
        // Create a CalculatorLexer (generated from grammar) that feeds from that stream
        antlr.CalculatorLexer lexer = new antlr.CalculatorLexer(input);
        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser (also generated from grammar) that draws meaning from the token stream
        antlr.CalculatorParser parser = new antlr.CalculatorParser(tokens);
        // Begin parsing at rule prog, return result
        parser.prog();
    }

}
