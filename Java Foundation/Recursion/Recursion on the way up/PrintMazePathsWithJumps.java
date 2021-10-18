import java.io.*;
import java.util.*;

public class PrintMazePathsWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        for (int jump = 1; jump + sc <= dc; jump++) {
            printMazePaths(sr, sc + jump, dr, dc, psf + "h" + jump);
        }
        for (int jump = 1; jump + sr <= dr; jump++) {
            printMazePaths(sr + jump, sc, dr, dc, psf + "v" + jump);
        }
        for (int jump = 1; jump + sc <= dc && jump + sr <= dr; jump++) {
            printMazePaths(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
        }
    }

    public static void printMazePaths2(int sr, int sc, int dr, int dc, String psf) {
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        for (int jump = 1; jump <= dc - sc; jump++) {
            printMazePaths2(sr, sc + jump, dr, dc, psf + "h" + jump);
        }
        for (int jump = 1; jump <= dr - sr; jump++) {
            printMazePaths2(sr + jump, sc, dr, dc, psf + "v" + jump);
        }
        for (int jump = 1; jump <= dc - sc && jump <= dr - sr; jump++) {
            printMazePaths2(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
        }
    }

    // Wrong Approach 
    public static void printMazePaths3(int sr, int sc, int dr, int dc, String psf) {
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        for (int jump = 1; jump < dr && jump < dc; jump++) {
            if (sc + jump <= dc) {
                printMazePaths3(sr, sc + jump, dr, dc, psf + "h" + jump);
            }
            if (sr + jump <= dr) {
                printMazePaths3(sr + jump, sc, dr, dc, psf + "v" + jump);
            }
            if (sc + jump <= dc && sr + jump <= dr) {
                printMazePaths3(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
            }
        }
    }

}