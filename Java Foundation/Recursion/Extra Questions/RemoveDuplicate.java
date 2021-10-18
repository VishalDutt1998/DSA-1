import java.io.*;
import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = removeDuplicate(str);
        System.out.println(ans);
    }

    public static String removeDuplicate(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return removeDuplicate(str.substring(1));
        }
        return str.charAt(0) + removeDuplicate(str.substring(1));
    }
}
