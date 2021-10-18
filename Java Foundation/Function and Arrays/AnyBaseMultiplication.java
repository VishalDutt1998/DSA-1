import java.util.*;

public class AnyBaseMultiplication {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int anyBaseAddition(int b, int n1, int n2) {
        // write ur code here
        int pow = 1;
        int carry = 0;
        int ans = 0;
        while (n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int sum = d1 + d2 + carry;
            int q = sum / b;
            int r = sum % b;
            ans += r * pow;
            pow = pow * 10;
            carry = q;
        }
        return ans;
    }

    public static int getProductSingleDigit(int b, int n1, int d2) {
        int pow = 1;
        int ans = 0;
        int carry = 0;
        while (n1 != 0 || carry != 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;
            int product = d1 * d2 + carry;
            int q = product / b;
            int r = product % b;
            ans += r * pow;
            carry = q;
            pow = pow * 10;
        }
        return ans;
    }

    public static int getProduct(int b, int n1, int n2) {
        int ans = 0;
        int pow = 1;
        while (n2 != 0) {
            int ld = n2 % 10;
            n2 = n2 / 10;
            int pwsd = getProductSingleDigit(b, n1, ld);
            ans = anyBaseAddition(b, ans, pwsd * pow);
            pow = pow * 10;
        }
        return ans;
    }

}