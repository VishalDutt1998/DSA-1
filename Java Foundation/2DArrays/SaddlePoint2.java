import java.util.*;
import java.io.*;

public class SaddlePoint2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        printSaddlePoint(arr);
    }

    public static void printSaddlePoint(int[][] arr) {
        // find column index of min element from the rth row
        for (int r = 0; r < arr.length; r++) {
            int minCI = getMinColIdxFromR(arr, r);
            int maxRI = getMaxRowIdxFromC(arr, minCI);
            if (maxRI == r) {
                System.out.println(arr[r][minCI]);
                return;
            }
        }
        System.out.println("Invalid input");
    }

    public static int getMinColIdxFromR(int[][] arr, int r) {
        int c = 0;
        for (int j = 1; j < arr[0].length; j++) {
            if (arr[r][j] < arr[r][c]) {
                c = j;
            }
        }
        return c;
    }

    public static int getMaxRowIdxFromC(int[][] arr, int c) {
        int r = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][c] > arr[r][c]) {
                r = i;
            }
        }
        return r;
    }
}
