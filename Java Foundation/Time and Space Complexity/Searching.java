import java.io.*;
import java.util.*;

public class Searching {
    public static void main(String[] args) {
        // int[] arr = {1,2,5,6,7,8,9,10,15,16};
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int data = 10;
        // int idx = linearSearch(arr,data);
        // if(idx>0){
        // System.out.println(Arrays.toString(arr));
        // System.out.println(data + " found at " + idx);
        // }else{
        // System.out.println("Element not found");
        // }

        // boolean ans = binarySearchRec(arr,0,arr.length,40);
        // System.out.println(ans);

        int idx = binarySearchIdx(arr, 0, arr.length, -40);
        if (idx > 0) {
            System.out.println(data + " Found at Index " + idx);
        }
        System.out.println("Element not found");
    }

    //
    public static int linearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (data == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // O(logn)
    public static boolean binarySearchRec(int[] arr, int lo, int hi, int data) {
        if (lo > hi) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        boolean res = false;
        if (arr[mid] == data) {
            res = true;
        } else if (arr[mid] < data) {
            // Right part
            res = binarySearchRec(arr, mid + 1, hi, data);
        } else {
            // Left part
            res = binarySearchRec(arr, lo, mid - 1, data);
        }
        return res;
    }

    public static int binarySearchIdx(int[] arr, int lo, int hi, int data) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        if (arr[mid] == data) {
            res = mid;
        } else if (arr[mid] < data) {
            // Right part
            res = binarySearchIdx(arr, mid + 1, hi, data);
        } else {
            // Left part
            res = binarySearchIdx(arr, lo, mid - 1, data);
        }
        return res;
    }
}
