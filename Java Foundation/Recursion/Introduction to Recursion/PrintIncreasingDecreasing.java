import java.util.*;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printincreasingdecreasing(n, 1);
    }

    public static void printincreasingdecreasing(int n, int i) {
        if (n == i) {
            System.out.println(n);
            return;
        }
        System.out.println(i);
        printincreasingdecreasing(n, i + 1);
        System.out.println(i);
    }
}
