import java.io.*;
import java.util.*;

public class SearchInSorted2dArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int x = scn.nextInt();
        searchInMatrix(arr, x);
    }

    public static void searchInMatrix(int[][] arr, int data) {
        int r = 0;
        int c = arr[0].length - 1;
        while (r < arr.length && c >= 0) {
            if (arr[r][c] == data) {
                System.out.println(r + "\n" + c);
                return;
            } else if (arr[r][c] < data) {
                r++;
            } else {
                c--;
            }
        }
        System.out.println("Not Found");
    }

    public static void searchInMatrix2(int[][] arr, int x) {
        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            if (x == arr[i][j]) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (x < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}