import java.io.*;
import java.util.*;

public class LargestAreaHistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int area = LargestAreaHistogram(arr);
        System.out.println(area);
    }

    public static int LargestAreaHistogram(int[] arr) {
        // lsi -> left smaller index arr
        // rsi -> right smaller index arr
        int[] lsi = NSEonLeft(arr);
        int[] rsi = NSEonRight(arr);
        // System.out.println(Arrays.toString(lsi));
        // System.out.println(Arrays.toString(rsi));
        int omax = 0;

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = (rsi[i] - lsi[i]) - 1;
            int area = height * width;
            omax = Math.max(omax, area);
        }
        return omax;
    }

    public static int[] NSEonLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] NSEonRight(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int largestAreaHistogramidx(int[] arr) {
        int area = 0;

        int[] lsi = NSEonLeft(arr);
        int[] rsi = NSEonRight(arr);

        int st = 0;
        int end = 0;

        for (int i = 0; i < lsi.length; i++) {
            int width = rsi[i] - lsi[i] - 1;
            int height = arr[i];

            // area = Math.max(area, width * height);
            if (area < width * height) {
                area = width * height;
                st = lsi[i];
                end = rsi[i];
            }
        }

        System.out.println("max area exist in " + (st + 1) + " - " + (end - 1) + " index");
        return area;
    }
}