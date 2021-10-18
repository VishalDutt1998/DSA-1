import java.util.*;
import java.io.*;

public class HelperFunctionSorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        boolean ans = helper(arr);
        System.out.println(ans);
    }

    public static boolean helper(int[] arr) {
        return isSorted(arr, 0);
    }

    private static boolean isSorted(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return true;
        }
        if (arr[idx] > arr[idx + 1]) {
            return false;
        }
        boolean ans = isSorted(arr, idx + 1);
        return ans;
    }

}
