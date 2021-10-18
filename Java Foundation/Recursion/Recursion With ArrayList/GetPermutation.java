import java.io.*;
import java.util.*;

public class GetPermutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = getPermutation(str);
        System.out.println(ans);
        // ArrayList<String> ans2 = getPermutation(str);
        // for (String s : ans2) {
        //     System.out.println(s);
        // }
        scn.close();
    }

    // Add Character At Every index of the recursion result String
    public static ArrayList<String> getPermutation(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mres = new ArrayList<>();
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getPermutation(ros);
        for (String s : rres) {
            for (int i = 0; i <= s.length(); i++) {
                String val = s.substring(0, i) + ch + s.substring(i);
                mres.add(val);
            }
        }
        return mres;
    }

    // Add Character at the Starting of the recursion Result String
    public static ArrayList<String> getPermutation2(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String roq = str.substring(0, i) + str.substring(i + 1);
            ArrayList<String> rres = getPermutation2(roq);
            for (String s : rres) {
                mres.add(ch + s);
            }
        }
        return mres;
    }
}