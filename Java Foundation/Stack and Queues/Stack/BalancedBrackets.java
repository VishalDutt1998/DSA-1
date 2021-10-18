import java.io.*;
import java.util.*;

public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(')
                    return false;
                st.pop();
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[')
                    return false;
                st.pop();
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{')
                    return false;
                st.pop();
            } else {
                continue;
            }
        }
        return st.size() == 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean res = balancedBrackets(str);
        System.out.println(res);
    }

}