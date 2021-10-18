import java.io.*;
import java.util.*;

public class PowerLinear {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xpn = power(x, n);
        System.out.println(xpn);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xpnm1 = power(x, n - 1);
        int xn = x * xpnm1;
        return xn;
    }

}