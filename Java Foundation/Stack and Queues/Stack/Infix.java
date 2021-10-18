import java.io.*;
import java.util.*;

public class Infix {

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
                // operands can be one or more digits long
                int num1 = 0;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    char ch1 = str.charAt(i);
                    int num2 = ch1 - '0';
                    num1 = num1 * 10 + num2;
                    num2 = 0;
                    i++;
                }
                i--;
                vstack.push(num1);
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
                while (ostack.size() > 0 && ostack.peek() != '(' && priority(ch) <= priority(ostack.peek())) {
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();
                    char op = ostack.pop();
                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.push(ch);
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
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String exp = br.readLine();
        String exp = "2*(5*(3+6))/15-2";
        int res = infixEvaluation(exp);
        System.out.println(res);
    }
}

// 2*(5*(3+6))/15-2
// op = 4