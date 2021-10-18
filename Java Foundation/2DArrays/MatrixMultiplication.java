import java.io.*;
import java.util.*;

public class MatrixMultiplication {

    public static Scanner scn = new Scanner(System.in);

    public static void takeInput(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();
        int[][] arr1 = new int[r1][c1];
        takeInput(arr1);
        int r2 = scn.nextInt();
        int c2 = scn.nextInt();
        int[][] arr2 = new int[r2][c2];
        takeInput(arr2);

        if (c1 != r2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] ans = new int[r1][c2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                // int val = 0;
                for (int k = 0; k < c1; k++) {
                    ans[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        display(ans);
    }

}