import java.io.*;
import java.util.*;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char ch = scn.nextLine().charAt(0);
        String ans = removeChar(str, ch);
        System.out.println(ans);
    }

    public static String removeChar(String str, char ch) {
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == ch) {
            return removeChar(str.substring(1), ch);
        }
        return str.charAt(0) + removeChar(str.substring(1), ch);
    }
}
