import java.io.*;
import java.util.*;

public class PowerLogarithmic {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xpn = powerlogarithmic(x, n);
        System.out.println(xpn);
    }

    public static int powerlogarithmic(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xpnb2 = powerlogarithmic(x, n / 2);
        int xn = xpnb2 * xpnb2;
        if (n % 2 == 1) {
            xn = xn * x;
        }
        return xn;
    }

}