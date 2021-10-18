import java.io.*;
import java.util.*;

public class GetStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n <= 0) {
            ArrayList<String> bres = new ArrayList<>();
            if (n == 0) {
                bres.add("");
                return bres;
            }
            return bres;
        }
        ArrayList<String> rres1 = getStairPaths(n - 1);
        ArrayList<String> rres2 = getStairPaths(n - 2);
        ArrayList<String> rres3 = getStairPaths(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : rres1) {
            ans.add("1" + s);
        }
        for (String s : rres2) {
            ans.add("2" + s);
        }
        for (String s : rres3) {
            ans.add("3" + s);
        }
        return ans;
    }

    // Manage Base case second way
    public static ArrayList<String> getStairPaths2(int n) {
        if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> rres1 = getStairPaths2(n - 1);
        ArrayList<String> rres2 = getStairPaths2(n - 2);
        ArrayList<String> rres3 = getStairPaths2(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < rres1.size(); i++) {
            ans.add(1 + rres1.get(i));
        }
        for (int i = 0; i < rres2.size(); i++) {
            ans.add(2 + rres2.get(i));
        }
        for (int i = 0; i < rres3.size(); i++) {
            ans.add(3 + rres3.get(i));
        }
        return ans;
    }

}