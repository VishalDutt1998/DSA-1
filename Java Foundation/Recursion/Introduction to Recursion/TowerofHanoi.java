import java.util.*;

public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        toh(n, 'A', 'B', 'C');
    }

    public static void toh(int n, char src, char dst, char hlp) {
        if (n == 0) {
            return;
        }
        toh(n - 1, src, hlp, dst);
        System.out.println("move " + n + " th disc from " + src + " to " + dst);
        toh(n - 1, hlp, dst, src);
    }
}