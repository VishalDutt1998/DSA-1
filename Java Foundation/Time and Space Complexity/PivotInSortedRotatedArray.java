import java.io.*;
import java.util.*;

public class PivotInSortedRotatedArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println(pivot);
    }

    public static int findPivot(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }
        int res = 0;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < arr[hi]) {
            res = findPivot(arr, lo, mid);
        } else {
            res = findPivot(arr, mid + 1, hi);
        }
        return res;
    }

    public static int findPivot(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[hi];
    }

}