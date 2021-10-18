package Heap;

import java.io.*;
import java.util.*;

public class SortKSortedArray {

    public static void printKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);
            System.out.println(pq.remove());
        }
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

    public static void printKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else if (i < arr.length) {
                pq.add(arr[i]);
                int val = pq.remove();
                System.out.println(val);
            }
        }
        while (pq.size() > 0) {
            int temp = pq.remove();
            System.out.println(temp);
        }
    }

    public static void printKSorted2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                pq.add(arr[i]);
                int val = pq.remove();
                System.out.println(val);
            }
        }
        while (pq.size() > 0) {
            int temp = pq.remove();
            System.out.println(temp);
        }
    }

    public static void printKSorted3(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // printKSortedArray(arr,k);
        // printKSorted(arr,k);
        // printKSorted2(arr,k);
        printKSorted3(arr, k);
    }
}