import java.io.*;
import java.util.*;

public class CountZeros {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countZeros(n);
        System.out.println(ans);
    }

    public static int countZeros(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 0) {
            return countZeros(n / 10) + 1;
        }
        return countZeros(n / 10);
    }

    // Manage Base Case Way 2
    public static int countZeros2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 10) {
            return 0;
        }
        if (n % 10 == 0) {
            return 1 + countZeros2(n / 10);
        }
        return countZeros2(n / 10);
    }

    // Manage Base Case Way 3
    public static int countZeros3(int n) {
        if (n < 10) {
            if (n == 0)
                return 1;
            return 0;
        }
        if (n % 10 == 0) {
            return 1 + countZeros3(n / 10);
        }
        return countZeros3(n / 10);
    }
}
