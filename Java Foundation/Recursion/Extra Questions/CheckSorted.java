import java.util.*;
import java.io.*;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        // boolean ans = checkSorted(arr);
        boolean ans = isSorted(arr,0);
        System.out.println(ans);
    }

    public static boolean checkSorted(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        int[] smallarr = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            smallarr[i - 1] = arr[i];
        }
        boolean ans = checkSorted(smallarr);
        if (!ans) {
            return false;
        }
        if (arr[0] <= arr[1]) {
            return true;
        }
        return false;
    }

    // Check first two elements
    public static boolean checkSorted2(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        if (arr[0] > arr[1]) {
            return false;
        }
        int[] smallarr = new int[arr.length - 1];
        // copying element
        for (int i = 1; i < arr.length; i++) {
            smallarr[i - 1] = arr[i];
        }
        boolean ans = checkSorted2(smallarr);
        return ans;
    }

    public static boolean isSorted(int[] arr, int idx) {
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
