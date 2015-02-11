package main.java;

/**
 * Created by bfors on 2/9/15.
 */
public class Calculator {


    public static void main(String[] args){

        if(args.length == 1) {
            Reader read = new Reader(args[0]);
            Evaluator eval = new Evaluator(read);
        }

    }
}
