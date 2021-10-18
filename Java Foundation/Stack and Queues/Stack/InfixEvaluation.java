// https://www.thealgorists.com/Algo/Infix
// https://algorithms.tutorialhorizon.com/evaluation-of-infix-expressions/

import java.io.*;
import java.util.*;

public class InfixEvaluation {

    public static int priority(char op) {
        if (op == '/' || op == '*') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return 0;
    }

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

    public static int infixEvaluation(String str) {
        Stack<Character> ostack = new Stack<>();
        Stack<Integer> vstack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') {
                vstack.push((int) (ch - '0'));
            } else if (ch == '(') {
                ostack.push(ch);
            } else if (ch == ')') {
                while (ostack.peek() != '(') {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();
                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.pop(); // pop for opening bracket
            } else {
                // Solve for the operator left to right
                while (ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)) {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();
                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.push(ch); // push the operator 
            }
        }
        // Some element may be in the stack
        while (ostack.size() > 0) {
            int val2 = vstack.pop();
            int val1 = vstack.pop();
            char op = ostack.pop();
            int res = evaluate(val1, val2, op);
            vstack.push(res);
        }
        return vstack.pop();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        int res = infixEvaluation(exp);
        System.out.println(res);
    }
}