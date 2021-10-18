import java.io.*;
import java.util.*;

public class Multiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int ans = multiplication(n, m);
        System.out.println(ans);
    }

    public static int multiplication(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        return n + multiplication(n, m - 1);
    }

}
