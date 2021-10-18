import java.io.*;
import java.util.*;

public class CountSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

    public static void countSort1(int[] arr, int hi) {
        int[] fmap = new int[hi + 1];
        // fill fmap
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            fmap[val]++;
        }

        // fill in array
        int idx = 0;
        for (int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i;
            for (int j = 0; j < fq; j++) {
                arr[idx] = val;
                idx++;
            }
        }
    }

    public static void countSort2(int[] arr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        // fill frequency map
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            fmap[idx]++;
        }

        // fill array using frequency map
        int idx = 0;
        for (int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i + min;
            for (int j = 0; j < fq; j++) {
                arr[idx] = val;
                idx++;
            }
        }
    }

    public static void countSortStable(int[] arr, int min, int max) {
        // Generate Frequency Array
        int[] fmap = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int indx = arr[i] - min;
            fmap[indx]++;
        }
        // Generate Prefix Sum
        fmap[0]--;
        for (int i = 1; i < fmap.length; i++) {
            fmap[i] += fmap[i - 1];
        }
        // Make a New Array and fill it in reverse Direction
        // Also Decrease psum[i], while place ith element
        int[] narr = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // Value to be placed
            int val = arr[i];
            // Index in frequency map
            int indx = val - min;
            // Position where we have to place in new array
            int pos = fmap[indx];
            // Place element
            narr[pos] = val;
            // Reduce the position to in prefix array
            fmap[indx]--;
        }
        // Fill the actual array using the new array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = narr[i];
        }
    }

    public static void countSort(int[] arr, int min, int max) {
        int[] farr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }

        // prefix sum array
        farr[0]--;
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        // fill the array from frequency array
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            ans[pos] = val;
            farr[val - min]--;

        }
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
