import java.util.*;

public class AnyBaseToAnyBase {
    public static int anyBaseToDecimal(int n, int b) {
        int ans = 0;
        int pow = 1;
        while (n != 0) {
            int rem = n % 10;
            n = n / 10;
            ans += rem * pow;
            pow = pow * b;
        }
        return ans;
    }

    public static int DecimalToAnyBase(int n, int b) {
        int ans = 0;
        int pow = 1;
        while (n != 0) {
            int dig = n % b;
            n = n / b;
            ans += dig * pow;
            pow = pow * 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int decno = anyBaseToDecimal(n, sourceBase);
        int ans = DecimalToAnyBase(decno, destBase);
        System.out.println(ans);
    }
}