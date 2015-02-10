
import java.util.ArrayList;

/**
 * Created by bfors on 2/10/15.
 */
public class Reader {

    public Reader(String input) {

        ArrayList<String> tokens = tokenizer(input);

    }

    private ArrayList<String> tokenizer(String input) {

        ArrayList<String> tokens = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        int i=0;
        while(i < input.length()) {
            char c = input.charAt(i);

            if(c == ')' || c == '(' || c == ',') {
                if(sb.length() > 0) {
                    tokens.add(sb.toString());
                    sb = new StringBuffer();
                }
                tokens.add(String.valueOf(c));
            }

            else {
                if(c != ' ') {
                    sb.append(c);
                }
            }

            i++;
        }

        for(String s : tokens)
            System.out.println(s);

        return tokens;
    }
}
