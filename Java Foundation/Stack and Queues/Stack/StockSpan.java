import java.io.*;
import java.util.*;

public class StockSpan {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = stockSpan(a);
        display(span);
    }

    public static int[] stockSpan(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = idx - i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int idx = st.pop();
            ans[idx] = idx + 1;
        }
        return ans;
    }

    public static int[] stockSpan1(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            ans[st.pop()] = -1;
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = i - ans[i];
        }
        return ans;
    }

    public static int[] stockSpan2(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = i + 1;
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = idx - i;
            }
            st.push(i);
        }
        return ans;
    }

}