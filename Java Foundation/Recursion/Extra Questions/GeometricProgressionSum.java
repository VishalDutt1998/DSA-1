import java.io.*;
import java.util.*;

public class GeometricProgressionSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        double ans = GPSum(n, k);
        System.out.println(ans);
    }

    public static double GPSum(int n, int k) {
        if (n == 0) {
            return 1;
        }
        double ans = GPSum(n - 1, k) + 1 / Math.pow(k, n);
        return ans;
    }

}
