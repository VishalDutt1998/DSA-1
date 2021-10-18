import java.io.*;
import java.util.*;

public class Sort01 {

    // Regions Defined
    // 0's Region => 0 to i-1
    // 1's Region => i to j-1
    // 2's Region => j to arr.length-1
    public static void sort01(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                swap(arr, j, i);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    public static void sort01way2(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0)
                ;
            swap(arr, j, i);
            i++;
        }
    }

    // Regions Defined
    // 0's Region => 0 to j-1
    // 1's Region => j to i-1
    // 2's Region => i to arr.length-1
    public static void sort01way3(int[] arr) {
        // write your code here
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
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
        sort01(arr);
        print(arr);
    }

}