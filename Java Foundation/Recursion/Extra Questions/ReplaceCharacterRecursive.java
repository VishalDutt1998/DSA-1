import java.io.*;
import java.util.*;

public class ReplaceCharacterRecursive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char ch1 = scn.next().charAt(0);
        char ch2 = scn.next().charAt(0);
        String ans = replaceChar(str, ch1, ch2);
        System.out.println(ans);
    }

    public static String replaceChar(String str, char ch1, char ch2) {
        if (str.length() == 0) {
            return "";
        }
        char c;
        if (str.charAt(0) == ch1) {
            c = ch2;
        } else {
            c = str.charAt(0);
        }
        String ans = replaceChar(str.substring(1), ch1, ch2);
        return c + ans;
    }
}
