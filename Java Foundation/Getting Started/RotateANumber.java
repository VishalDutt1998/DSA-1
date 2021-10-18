import java.util.*;

public class RotateANumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int temp = n;
        int digits = 0;
        while (temp != 0) {
            temp = temp / 10;
            digits++;
        }
        k = k % digits;
        if (k < 0) {
            k = k + digits;
        }
        int div = (int) Math.pow(10, k);
        int mult = (int) Math.pow(10, digits - k);
        int q = n / div;
        int r = n % div;
        int ans = (r * mult) + q;
        System.out.println(ans);
    }
}