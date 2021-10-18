package Sorting;

import java.io.*;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] arr = { 90, 70, 20, 60, 50, 30, 80, 40, 10, 45 };
        print(arr);
        bubbleSort(arr);
        print(arr);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}