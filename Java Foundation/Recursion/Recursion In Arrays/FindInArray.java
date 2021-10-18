import java.io.*;
import java.util.*;

public class FindInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        boolean ans = find(arr, 0, data);
        System.out.println(ans);
    }

    public static boolean find(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == data) {
            return true;
        }
        return find(arr, idx + 1, data);
    }
}