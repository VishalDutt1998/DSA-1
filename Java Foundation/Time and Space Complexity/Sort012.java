import java.io.*;
import java.util.*;

public class Sort012 {

    // partition of Regions
    // 0's Region 0 to i-1
    // 1's Region i to j-1
    // 2's Region k+1 to arr.length-1
    // Unknown Regioon j to k (j and k are inclusive)
    public static void sort012(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 1) {
                j++;
            } else if (arr[j] == 0) {
                swap(arr, j, i);
                i++;
                j++;
            } else { // arr[j]==2
                swap(arr, j, k);
                k--;
            }
        }
    }

    // partition of Regions
    // 0's Region 0 to k-1
    // 1's Region i to i-1
    // 2's Region k+1 to arr.length-1
    // Unknown Regioon i to k (i and k are inclusive)

    public static void sort012way2(int[] arr) {
        // write your code here
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else { // arr[j]==2
                swap(arr, i, k);
                k--;
            }
        }
    }

    // Continuous Area
    public static void sort012Continuous(int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr.length) {
            if (arr[i] == 2) {
                i++;
            } else if (arr[i] == 1) {
                swap(arr, i, k);
                i++;
                k++;
            } else {
                swap(arr, i, j);
                swap(arr, i, k);
                i++;
                j++;
                k++;
            }
        }
    }

    public static void sort012way4(int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr.length) {
            if (arr[i] == 2) {
                i++;
            } else if (arr[i] == 1) {
                swap(arr, i, k);
                i++;
                k++;
            } else {
                swap(arr, i, j);
                j++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }

}