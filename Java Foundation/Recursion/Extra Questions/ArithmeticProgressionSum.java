import java.io.*;
import java.util.*;

public class ArithmeticProgressionSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int d = scn.nextInt();
        int n = scn.nextInt();
        int ans = APSum(a, d, n);
        System.out.println(ans);
    }

    public static int APSum(int a, int d, int n) {
        if (n == 0) {
            return 0;
        }
        return a + APSum(a + d, d, n - 1);
    }
}
