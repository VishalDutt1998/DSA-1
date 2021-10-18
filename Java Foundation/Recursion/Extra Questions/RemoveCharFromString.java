import java.io.*;
import java.util.*;

public class RemoveCharFromString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char ch = scn.next().charAt(0);
        String ans = removechar(str, ch);
        System.out.println(ans);
    }

    public static String removechar(String str, char ch) {
        if (str.length() == 0) {
            return str;
        }
        String ans = "";
        if (str.charAt(0) != ch) {
            ans = ans + str.charAt(0);
        }
        String smallans = removechar(str.substring(1), ch);
        return ans + smallans;
    }
}
