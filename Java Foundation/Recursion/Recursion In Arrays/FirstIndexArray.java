import java.io.*;
import java.util.*;

public class FirstIndexArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        int fi = find(arr, 0, data);
        System.out.println(fi);
    }

    public static int find(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == data) {
            return idx;
        }
        return find(arr, idx + 1, data);
    }

    public static int findpost(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return -1;
        }
        int fiisa = find(arr, idx + 1, data);
        if (arr[idx] == data) {
            return idx;
        } else {
            return fiisa;
        }
    }
}