import java.io.*;
import java.util.*;

public class Polynomial {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(polynomial(x, n));
    }

    // f(x, n) = 1.x^n + 2.x^(n-1) + 3.x^(n-2) + - - - - - - - - + n.x
    public static int polynomial(int x, int N) {
        if (x == 0)
            return 0;

        int xval = x;
        int sum = 0;

        for (int n = N; n >= 1; n--) {
            sum += n * xval;
            xval *= x;
        }
        return sum;
    }

}
