import java.io.*;
import java.util.*;

public class InfixToPrefix {

    public static int priority(char op) {
        if (op == '/' || op == '*') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return 0;
    }

    public static void infixToPrefix(String str) {
        Stack<Character> ostack = new Stack<>();
        Stack<String> vstack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch >= 'a' && ch <= 'z') {
                vstack.push("" + ch);
            } else if (ch == '(') {
                ostack.push(ch);
            } else if (ch == ')') {
                while (ostack.peek() != '(') {
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.pop(); // pop for opening bracket
            } else {
                // Solve for the operator left to right
                while (ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)) {
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();
                    char op = ostack.pop();
                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.push(ch); // push the operator
            }
        }
        // Some element may be in the stack
        while (ostack.size() > 0) {
            String val2 = vstack.pop();
            String val1 = vstack.pop();
            char op = ostack.pop();
            String res = op + val1 + val2;
            vstack.push(res);
        }
        System.out.println(vstack.pop());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        infixToPrefix(exp);
    }
}