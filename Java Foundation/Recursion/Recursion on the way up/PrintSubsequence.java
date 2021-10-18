import java.io.*;
import java.util.*;

public class PrintSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printSubsequence(str, "");
    }

    public static void printSubsequence(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        // Yes Call
        printSubsequence(ros, asf + ch);
        // No Call
        printSubsequence(ros, asf);
    }

}