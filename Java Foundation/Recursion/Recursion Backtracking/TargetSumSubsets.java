import java.io.*;
import java.util.*;

public class TargetSumSubsets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        printTargetSumSubset(arr, 0, 0, tar, "");
    }

    public static void printTargetSumSubset(int[] arr, int idx, int ssf, int tar, String asf) {
        if (idx == arr.length) {
            if (tar == ssf) {
                System.out.println(asf + ".");
            }
            return;
        }
        if (ssf + arr[idx] <= tar) {
            printTargetSumSubset(arr, idx + 1, ssf + arr[idx], tar, asf + arr[idx] + ", ");
        }
        printTargetSumSubset(arr, idx + 1, ssf, tar, asf);
    }

    public static void printTargetSumSubset1(int[] arr, int idx, int ssf, int tar, String asf) {
        if (idx == arr.length) {
            if (tar == ssf) {
                System.out.println(asf + ".");
            }
            return;
        }
        printTargetSumSubset1(arr, idx + 1, ssf + arr[idx], tar, asf + arr[idx] + ", ");
        printTargetSumSubset1(arr, idx + 1, ssf, tar, asf);
    }

}