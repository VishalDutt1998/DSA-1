import java.io.*;
import java.util.*;

public class MaximumofArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int misa = maxOfArray(arr, idx + 1);
        if (misa > arr[idx]) {
            return misa;
        }
        return arr[idx];
    }

    public static int maxOfArray2(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }
        int misa = maxOfArray2(arr, idx + 1);
        return Math.max(misa,arr[idx]);
    }

}