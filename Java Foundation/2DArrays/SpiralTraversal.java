import java.io.*;
import java.util.*;

public class SpiralTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int tne = r * c;
        int count = 0;
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        while (count < tne) {
            // left wall
            for (int i = minr, j = minc; i <= maxr && count < tne; i++) {
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;
            // bottom wall
            for (int i = maxr, j = minc; j <= maxc && count < tne; j++) {
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;
            // right wall
            for (int i = maxr, j = maxc; i >= minr && count < tne; i--) {
                System.out.println(arr[i][j]);
                count++;
            }
            // bottom wall
            maxc--;
            for (int i = minr, j = maxc; j >= minc && count < tne; j--) {
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }

}