import java.io.*;
import java.util.*;

public class GetStairPathsArray {
    public static void main(String[] args) {
        // int[] jumps = { 1, 0, 2, 1, 1, 0, 2, 3 };
        int[] jumps = { 1, 0, 2, 1, 4, 0, 2, 3 };
        ArrayList<String> res = getStairPathWithJumps(jumps, 7, 7);
        for (String s : res)
            System.out.println(s);
    }

    public static ArrayList<String> getStairPathWithJumps(int[] jumps, int n, int os) {
        // Positive Base case
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        // Proactive calls
        ArrayList<String> mres = new ArrayList<>();
        for (int jump = 1; jump <= jumps[n] && n - jump >= 0; jump++) {
            ArrayList<String> rres = getStairPathWithJumps(jumps, n - jump, os);
            for (String s : rres) {
                mres.add(jump + s);
            }
        }

        // os original stair
        if (n == os && mres.size() == 0) {
            System.out.println("No Possible Paths");
        }

        return mres;
    }
}
