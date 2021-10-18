import java.io.*;
import java.util.*;

public class PostfixToPrefix {

    public static void postfixToPrefix(String str) {
        Stack<String> vstack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                vstack.push("" + ch);
            } else {
                String val2 = vstack.pop();
                String val1 = vstack.pop();
                String res = ch + val1 + val2;
                vstack.push(res);
            }
        }
        System.out.println(vstack.pop());
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        postfixToPrefix(exp);
    }
}
