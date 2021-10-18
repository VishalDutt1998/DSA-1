import java.io.*;
import java.util.*;

public class GetBoardPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int src = scn.nextInt();
        int dest = scn.nextInt();
        ArrayList<String> ans = getBoardPath(src, dest);
        // 0 => 10 492 Paths
        // System.out.println(ans);
        System.out.println(ans.size());
    }

    public static ArrayList<String> getBoardPath(int src, int dest) {
        if (src == dest) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("\n");
            return bres;
        }
        if (src > dest) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        for (int dice = 1; dice <= 6; dice++) {
            ArrayList<String> rres = getBoardPath(src + dice, dest);
            for (String s : rres) {
                mres.add(dice + s);
            }
        }
        return mres;
    }

    // i=0 is needed to Check Valid jump form every level before calling
    public static ArrayList<String> getBoardPath2(int src, int dest, int i) {
        if (src == dest) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("\n");
            return bres;
        }
        ArrayList<String> mres = new ArrayList<>();
        for (int dice = 1; dice <= 6 && i + dice <= dest; dice++) {
            ArrayList<String> rres = getBoardPath2(src + dice, dest, i + 1);
            for (String s : rres) {
                mres.add(dice + s);
            }
        }
        return mres;
    }
}