import java.io.*;
import java.util.*;

public class ExitPointMatrix {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int dir = 0;
        int r = 0;
        int c = 0;
        // Manage Direction
        while (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length) {
            dir = (dir + arr[r][c]) % 4;
            if (dir == 0) {
                c++;
            } else if (dir == 1) {
                r++;
            } else if (dir == 2) {
                c--;
            } else {
                r--;
            }
        }
        // Manage Exit Point
        if (dir == 0) {
            c--;
        } else if (dir == 1) {
            r--;
        } else if (dir == 2) {
            c++;
        } else {
            r++;
        }
        System.out.println(r);
        System.out.println(c);
    }
}