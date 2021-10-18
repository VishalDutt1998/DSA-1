import java.io.*;
import java.util.*;

public class AddStarConsecutive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = pairStar(str);
        System.out.println(ans);
    }

    public static String addStar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String ans = addStar(str.substring(1));
        if (str.charAt(0) == str.charAt(1)) {
            ans = str.charAt(0) + "*" + str.charAt(1) + ans.substring(1);
        } else {
            ans = str.charAt(0) + ans;
        }
        return ans;
    }

    public static String pairStar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            String ans = str.charAt(0) + "*" + pairStar(str.substring(1));
            return ans;
        }
        return str.charAt(0) + pairStar(str.substring(1));
    }
}
