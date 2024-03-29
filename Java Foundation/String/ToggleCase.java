import java.io.*;
import java.util.*;

public class ToggleCase {

    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // lowercase ==> uppercase
                sb.append((char) (ch - 'a' + 'A'));
            } else { // uppercase ==> lowercase
                sb.append((char) (ch - 'A' + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}