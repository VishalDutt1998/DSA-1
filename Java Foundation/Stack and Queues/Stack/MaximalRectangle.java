// Leetcode 85. Maximal Rectangle
// https://leetcode.com/problems/maximal-rectangle/

import java.io.*;
import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int res = 0;
        int[] ans = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    ans[j] = 0;
                } else {
                    ans[j] = ans[j] + (matrix[i][j] - '0');
                }
            }
            res = Math.max(res, LargestAreaHistogram(ans));
        }
        return res;
    }

    public static int LargestAreaHistogram(int[] arr) {
        int[] lsi = NSEonLeft(arr);
        int[] rsi = NSEonRight(arr);
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
}