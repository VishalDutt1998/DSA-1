import java.io.*;
import java.util.*;

public class ReplacePi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = replace(str);
        System.out.println(ans);
    }

    public static String replace(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == 'p' && str.length() >= 2 && str.charAt(1) == 'i') {
            return "3.14" + replace(str.substring(2, str.length()));
        }
        return str.charAt(0) + replace(str.substring(1, str.length()));
    }

    // Another Approach
    public static String replacePi(String str) {
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            String ans = replacePi(str.substring(2));
            return "3.14" + ans;
        }
        String ans = replacePi(str.substring(1));
        return str.charAt(0) + ans;
    }

    public static String replacePi2(String str) {
        String op;
        if (str.length() <= 1)
            return str;
        String small = replacePi2(str.substring(1));
        if (str.charAt(0) == 'p' && small.charAt(0) == 'i') {
            op = "3.14" + small.substring(1);
        } else {
            op = str.charAt(0) + small;
        }
        return op;
    }
}
