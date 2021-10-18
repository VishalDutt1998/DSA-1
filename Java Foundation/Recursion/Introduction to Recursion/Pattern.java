import java.util.*;

public class Pattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // pattern(n, 1, 1);
        pattern2(n, 0, 0);
        scn.close();
    }

    public static void pattern(int n, int row, int col) {
        if (row > n) {
            return;
        }
        if (col > row) {
            System.out.println("\t");
            pattern(n, row + 1, 1);
            return;
        }
        System.out.print("*\t");
        pattern(n, row, col + 1);
    }

    public static void pattern2(int n, int row, int col) {
        if (row == n) {
            return;
        }
        if (col > row) {
            System.out.println("");
            pattern2(n, row + 1, 0);
            return;
        }
        System.out.print("*\t");
        pattern2(n, row, col + 1);
    }
}
