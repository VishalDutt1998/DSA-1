import java.io.*;
import java.util.*;

public class PrefixEvaluation {

    public static int evaluate(int val1, int val2, char op) {
        if (op == '*') {
            return val1 * val2;
        } else if (op == '/') {
            return val1 / val2;
        } else if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }

    public static void prefixEvaluation(String str) {
        Stack<Integer> vstack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                vstack.push(ch - '0');
            } else {
                int val1 = vstack.pop();
                int val2 = vstack.pop();
                int res = evaluate(val1, val2, ch);
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        prefixEvaluation(exp);
    }
}
