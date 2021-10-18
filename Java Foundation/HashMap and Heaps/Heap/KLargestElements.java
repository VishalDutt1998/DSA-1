package Heap;

import java.io.*;
import java.util.*;

public class KLargestElements {

    public static void printKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

    public static void printKLargestElements2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (pq.size() != 0) {
            int val = pq.remove();
            System.out.println(val);
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
        printKLargestElements(arr, k);
    }

}