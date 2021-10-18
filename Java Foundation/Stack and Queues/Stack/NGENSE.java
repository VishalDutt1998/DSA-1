import java.io.*;
import java.util.*;

public class NGENSE {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int[] arr = { 2, 5, 9, 10, 1, 0, 4, 6, 8, 7 };
        int[] arr = { 10, 6, 12, 5, 3, 2, 4, 8, 1 };
        int[] ngr = NGER(arr);
        int[] ngl = NGEL(arr);
        int[] nsr = NSER(arr);
        int[] nsl = NSEL(arr);

        System.out.println("ngr => " + Arrays.toString(ngr));
        System.out.println("ngl => " + Arrays.toString(ngl));
        System.out.println("nsr => " + Arrays.toString(nsr));
        System.out.println("nsl => " + Arrays.toString(nsl));

    }

    // Next Greater Element on Right
    public static int[] NGER(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }

    // Next Smaller Element on Right
    public static int[] NSER(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }

    // Next Greater Element on Left
    public static int[] NGEL(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }

    // Next Smaller Element on Left
    public static int[] NSEL(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }
}
