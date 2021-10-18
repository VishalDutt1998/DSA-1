import java.util.*;

public class GCDandLCM {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int dvd = n1;
        int div = n2;
        while (dvd % div != 0) {
            int rem = dvd % div;
            dvd = div;
            div = rem;
        }
        int gcd = div;
        int lcm = n1 * n2 / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}