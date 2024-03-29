import java.io.*;
import java.util.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            if (arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int candidate = st.pop();

        for (int i = 0; i < arr.length; i++) {
            if (i != candidate) {
                if (arr[i][candidate] == 0 || arr[candidate][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(candidate);
    }

    public static void findCelebrityway2(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            if (arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int candidate = st.pop();

        // Row Check
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[candidate][c] == 1) {
                System.out.println("none");
                return;
            }
        }
        // Col Check
        for (int r = 0; r < arr.length; r++) {
            if (r != candidate && arr[r][candidate] == 0) {
                System.out.println("none");
                return;
            }
        }
        System.out.println(candidate);
    }

    public static void findCelebritywithoutStack(int[][] arr) {
        int candidate = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[candidate][i] == 1) {
                candidate = i;
            } else {
                candidate = candidate;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != candidate) {
                if (arr[i][candidate] == 0 || arr[candidate][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(candidate);
    }

}