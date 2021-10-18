import java.io.*;
import java.util.*;

public class PrintSubsequenceIterative {

    
    public static class Pair {
        String ques;
        int state;
        String ans;

        public Pair(String ques, int state, String ans) {
            this.ques = ques;
            this.state = state;
            this.ans = ans;
        }
    }

    public static void PrintSubsequence(String str) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(str, 0, ""));
        // ArrayList<String> res = new ArrayList<>();
        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.ques.length() == 0) {
                // res.add(p.ans);
                System.out.println(p.ans);
                st.pop();
                continue;
            }

            String roq = p.ques.substring(1);
            char ch = p.ques.charAt(0);
            if (p.state == 0) {
                p.state++;
                st.push(new Pair(roq, 0, p.ans + ch + " "));
            } else if (p.state == 1) {
                p.state++;
                st.push(new Pair(roq, 0, p.ans + "- "));
            } else {
                st.pop();
            }
        }

        // for (String val : res) {
        //     System.out.println(val);
        // }
    }

    public static void main(String[] args) {
        PrintSubsequence("abc");
    }
}
