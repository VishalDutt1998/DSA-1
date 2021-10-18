import java.io.*;
import java.util.*;

public class StringToInteger {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int ans = convert(str);
        System.out.println(ans);
    }

    public static int convert(String str) {
        if (str.length() == 1) {
            return str.charAt(0) - '0';
        }
        int ans = convert(str.substring(0, str.length() - 1));
        int digit = str.charAt(str.length() - 1) - '0';
        return ans * 10 + digit;
    }

    public static int convert2(String str) {
        if (str.length() == 1) {
            return str.charAt(0) - '0';
        }
        int ans = convert2(str.substring(1));
        int digit = str.charAt(0) - '0';
        digit = digit * (int) Math.pow(10, str.length() - 1) + ans;
        return digit;
    }
}
