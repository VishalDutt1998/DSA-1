import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        smallestNumberFollowingPattern(str);
        smallestNumberFollowingPattern2(str);
    }

    public static void smallestNumberFollowingPattern(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'd') {
                st.push(count);
                count++;
            } else {
                st.push(count);
                count++;
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }

    public static void smallestNumberFollowingPattern2(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            st.push(count);
            count++;
            if (str.charAt(i) == 'i') {
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}