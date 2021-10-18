import java.util.*;
import java.io.*;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countdigits(n);
        System.out.println(ans);
    }

    public static int countdigits(int n) {
        if (n == 0) {
            return 0;
        }
        int smallAns = countdigits(n / 10);
        return smallAns + 1;
    }
}
