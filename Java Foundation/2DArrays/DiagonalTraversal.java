import java.io.*;
import java.util.*;

public class DiagonalTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int gap = 0; gap < arr.length; gap++) {
            for (int left = 0; left <= arr.length - 1 - gap; left++) {
                int right = left + gap;
                System.out.println(arr[left][right]);
            }
        }
    }

    public static void diagonalTraversal(int[][] arr) {
        for (int gap = 0; gap < arr.length; gap++) {
            for (int i = 0, j = gap; j < arr.length; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}