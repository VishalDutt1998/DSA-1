import java.io.*;
import java.util.*;

public class PrintMazePaths {

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
        // Positive Base Case
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        // Negative Base Case
        if (sc > dc || sr > dr) {
            return;
        }
        // Reactive Calls
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }

    public static void printMazePaths2(int sr, int sc, int dr, int dc, String psf) {
        // Positive Base Case
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        // Proactive Calls
        if (sc + 1 <= dc) {
            printMazePaths2(sr, sc + 1, dr, dc, psf + "h");
        }
        if (sr + 1 <= dr) {
            printMazePaths2(sr + 1, sc, dr, dc, psf + "v");
        }
    }

}