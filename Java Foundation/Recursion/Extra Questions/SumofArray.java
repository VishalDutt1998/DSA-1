import java.util.*;
import java.io.*;

public class SumofArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = sum(arr, 0);
        System.out.println(ans);
    }

    public static int sum(int[] arr, int idx) {
        if (idx == arr.length) {
            return 0;
        }
        return arr[idx] + sum(arr, idx + 1);
        // int ans = sum(arr, idx + 1);
        // int tans = sum + arr[idx];
        // return tans;
    }
}
