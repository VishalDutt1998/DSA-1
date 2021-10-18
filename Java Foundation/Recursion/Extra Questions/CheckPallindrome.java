import java.io.*;
import java.util.*;

public class CheckPallindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = helper(str);
        System.out.println(ans);
    }

    public static boolean helper(String str) {
        return checkPallindrome(str, 0, str.length() - 1);
    }

    public static boolean checkPallindrome(String str, int si, int ei) {
        // Redundant Base Case
        if (str.length() == 1) {
            return true;
        }

        if (si >= ei) {
            return true;
        }

        if (str.charAt(si) != str.charAt(ei)) {
            return false;
        }
        return checkPallindrome(str, si + 1, ei - 1);
    }

    // Without Helper Function
    public static boolean checkPallindrome2(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return checkPallindrome2(str.substring(1, str.length() - 1));
    }
}
