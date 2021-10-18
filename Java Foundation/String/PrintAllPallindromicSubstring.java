import java.io.*;
import java.util.*;

public class PrintAllPallindromicSubstring {

    public static boolean isPallindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);

            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                if (isPallindrome(s) == true) {
                    System.out.println(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}