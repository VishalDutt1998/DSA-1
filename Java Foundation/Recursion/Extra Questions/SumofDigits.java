import java.io.*;
import java.util.*;

public class SumofDigits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = sum(n);
        System.out.println(ans);
    }

    public static int sum(int n) {
        if (n < 10) {
            return n;
        }
        int sum = n % 10 + sum(n / 10);
        return sum;
    }
}
