package main.java;

import java.util.ArrayList;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

/**
 * Created by bfors on 2/10/15.
 */
public class Reader {

    CommonTree ast;

    public Reader(String input) {

        try {

            ANTLRStringStream stream = new ANTLRStringStream(input);
            TokenStream tokens = new CommonTokenStream(new main.java.CalculatorLexer(stream));

            main.java.CalculatorParser parser = new main.java.CalculatorParser(tokens);
            main.java.CalculatorParser.expression_return ret = parser.expression();

            ast = (CommonTree) ret.tree;
            System.out.println(ast.toStringTree());

        } catch (RecognitionException e) {
            throw new IllegalStateException();
        }

    }
}
