import java.io.*;
import java.util.*;

public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        int exp = 1;
        while (exp <= max) { // max/exp>0
            countSortForRadix(arr, exp);
            exp *= 10;
        }
    }

    public static void countSortForRadix(int[] arr, int exp) {
        int[] farr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int idx = (arr[i] / exp) % 10;
            farr[idx]++;
        }
        farr[0]--;
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = (arr[i] / exp) % 10;
            int pos = farr[val];
            ans[pos] = arr[i];
            farr[val]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}
