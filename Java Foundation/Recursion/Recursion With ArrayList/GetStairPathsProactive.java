import java.io.*;
import java.util.*;

public class GetStairPathsProactive {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        // Base case
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> ans = new ArrayList<>();
        // Proactive Call
        if (n - 1 >= 0) {
            ArrayList<String> rres1 = getStairPaths(n - 1);
            for (String s : rres1) {
                ans.add("1" + s);
            }
        }
        // Proactive Call
        if (n - 2 >= 0) {
            ArrayList<String> rres2 = getStairPaths(n - 2);
            for (String s : rres2) {
                ans.add("2" + s);
            }
        }
        // Proactive Call
        if (n - 3 >= 0) {
            ArrayList<String> rres3 = getStairPaths(n - 3);
            for (String s : rres3) {
                ans.add("3" + s);
            }
        }
        return ans;
    }

    public static ArrayList<String> getStairPaths2(int n) {
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            ArrayList<String> rres = getStairPaths2(n - jump);
            for (String s : rres) {
                ans.add(jump + s);
            }
        }
        return ans;
    }

}