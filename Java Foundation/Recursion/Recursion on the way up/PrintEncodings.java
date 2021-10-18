import java.io.*;
import java.util.*;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        int n1 = str.charAt(0) - '0';
        if (n1 == 0) {
            return;
        }
        char ch1 = (char) (n1 + 'a' - 1);
        String ros1 = str.substring(1);
        printEncodings(ros1, asf + ch1);
        if (str.length() > 1) {
            int n2 = str.charAt(1) - '0';
            int n = n1 * 10 + n2;
            if (n <= 26) {
                char ch2 = (char) (n + 'a' - 1);
                String ros2 = str.substring(2);
                printEncodings(ros2, asf + ch2);
            }
        }
    }

}