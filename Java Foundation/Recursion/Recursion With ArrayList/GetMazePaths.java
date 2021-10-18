import java.io.*;
import java.util.*;

public class GetMazePaths {

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
        if (sr > dr || sc > dc) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> fans = new ArrayList<>();
        ArrayList<String> hres = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> vres = getMazePaths(sr + 1, sc, dr, dc);
        for (String s : hres) {
            fans.add("h" + s);
        }
        for (String s : vres) {
            fans.add("v" + s);
        }
        return fans;
    }

    // Get Maze path Proactive Calls
    public static ArrayList<String> getMazePaths2(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); // don't move
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        // horizontal calls
        if (sc + 1 <= dc) {
            ArrayList<String> hres = getMazePaths2(sr, sc + 1, dr, dc);
            for (String s : hres) {
                mres.add("h" + s);
            }
        }
        // vertical calls
        if (sr + 1 <= dr) {
            ArrayList<String> vres = getMazePaths2(sr + 1, sc, dr, dc);
            for (String s : vres) {
                mres.add("v" + s);
            }
        }
        return mres;
    }

    public static ArrayList<String> getMazePath3(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        ArrayList<String> mres = new ArrayList<>();
        ArrayList<String> hres = getMazePath3(sr, sc + 1, dr, dc);
        ArrayList<String> vres = getMazePath3(sr + 1, sc, dr, dc);

        for (String s : hres)
            mres.add("h" + s);

        for (String s : vres)
            mres.add("v" + s);

        return mres;
    }
}