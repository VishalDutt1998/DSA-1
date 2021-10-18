import java.io.*;
import java.util.*;

public class MazePathMultipleJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mres = new ArrayList<>();
        for (int jump = 1; jump + sc <= dc; jump++) {
            ArrayList<String> res = getMazePaths(sr, sc + jump, dr, dc);
            for (String s : res) {
                mres.add("h" + jump + s);
            }
        }
        for (int jump = 1; jump + sr <= dr; jump++) {
            ArrayList<String> res = getMazePaths(sr + jump, sc, dr, dc);
            for (String s : res) {
                mres.add("v" + jump + s);
            }
        }
        for (int jump = 1; sr + jump <= dr && jump + sc <= dc; jump++) {
            ArrayList<String> res = getMazePaths(sr + jump, sc + jump, dr, dc);
            for (String s : res) {
                mres.add("d" + jump + s);
            }
        }
        return mres;
    }

    public static ArrayList<String> getMazePaths2(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> tempans = new ArrayList<>();
            tempans.add("");
            return tempans;
        }

        if (sr > dr || sc > dc) {
            ArrayList<String> tempans = new ArrayList<>();
            return tempans;
        }

        ArrayList<String> finalres = new ArrayList<>();

        for (int jump = 1; jump <= dc - sc; jump++) {
            ArrayList<String> smallres1 = getMazePaths2(sr, sc + jump, dr, dc);
            for (int i = 0; i < smallres1.size(); i++) {
                finalres.add("h" + jump + smallres1.get(i));
            }
        }

        for (int jump = 1; jump <= dr - sr; jump++) {
            ArrayList<String> smallres2 = getMazePaths2(sr + jump, sc, dr, dc);
            for (int i = 0; i < smallres2.size(); i++) {
                finalres.add("v" + jump + smallres2.get(i));
            }
        }

        for (int jump = 1; jump <= dr - sr && jump <= dc - sc; jump++) {
            ArrayList<String> smallres3 = getMazePaths2(sr + jump, sc + jump, dr, dc);
            for (int i = 0; i < smallres3.size(); i++) {
                finalres.add("d" + jump + smallres3.get(i));
            }
        }
        return finalres;
    }

    // Answer will be same but the order will be shuffled
    // 2
    // 3
    // // Actual
    // [h1h1v1, h1v1h1, h1d1, v1h1h1, v1h2, d1h1, h2v1]
    // // Expected
    // [h1h1v1, h1v1h1, h1d1, h2v1, v1h1h1, v1h2, d1h1]

    public static ArrayList<String> getMazePathWithJumps2(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        for (int jump = 1; jump + sr <= dr || jump + sc <= dc; jump++) {
            if (jump + sc <= dc) {
                ArrayList<String> res = getMazePathWithJumps2(sr, sc + jump, dr, dc);
                for (String s : res) {
                    mres.add("h" + jump + s);
                }
            }

            if (jump + sr <= dr) {
                ArrayList<String> res = getMazePathWithJumps2(sr + jump, sc, dr, dc);
                for (String s : res) {
                    mres.add("v" + jump + s);
                }
            }

            if (jump + sr <= dr && jump + sc <= dc) {
                ArrayList<String> res = getMazePathWithJumps2(sr + jump, sc + jump, dr, dc);
                for (String s : res) {
                    mres.add("d" + jump + s);
                }
            }
        }
        return mres;
    }

}