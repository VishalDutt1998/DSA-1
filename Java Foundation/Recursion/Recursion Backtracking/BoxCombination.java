import java.io.*;
import java.util.*;

public class BoxCombination {
    public static void main(String[] args) {
        printWaysToSelectBox(0, 4, "");
        // printWaysToSelectBox2(0, 4, 0, "");
        // printWaysToSelectBox3(0, 4, 0, "");
        // printWays2D(2,2,0,0,0,"");
    }

    // cb -> current box
    // tb -> total box
    // asf -> answer so far
    // current box will decide it will select or not
    // Print all possibility to select all boxes
    public static void printWaysToSelectBox(int cb, int tb, String asf) {
        if (cb == tb) {
            System.out.println(asf);
            return;
        }
        // Yes Call
        printWaysToSelectBox(cb + 1, tb, asf + "b" + cb + " ");
        // No call
        printWaysToSelectBox(cb + 1, tb, asf);
    }

    public static void printWaysToSelectBox2(int cb, int tb, int bsf, String asf) {
        if (cb == tb) {
            // System.out.println(asf);
            System.out.println("box selected : " + bsf + " ways : " + asf);
            return;
        }
        printWaysToSelectBox2(cb + 1, tb, bsf + 1, asf + "b" + cb + " ");
        // No call
        printWaysToSelectBox2(cb + 1, tb, bsf, asf);
    }

    // Print All possibility to select r boxes from n boxes
    // bsf -> box so far
    public static void printWaysToSelectBox3(int cb, int tb, int bsf, String asf) {
        if (cb == tb) {
            // Printing only if box selected is equal to r
            if (bsf == 2) {
                System.out.println(asf);
                return;
            }
            return;
        }
        // Yes Call
        printWaysToSelectBox3(cb + 1, tb, bsf + 1, asf + "b" + cb + " ");
        // No call
        printWaysToSelectBox3(cb + 1, tb, bsf, asf);
    }

    // Proactive Approach
    // However the below code will still generate the possibility to select box less
    // than r but they are not printed
    public static void printWaysToSelectBox4(int cb, int tb, int bsf, String asf) {
        if (cb == tb) {
            // System.out.println(asf);
            if (bsf == 2) {
                System.out.println(asf);
                return;
            }
            return;
        }
        // Yes Call
        // Proactive Call
        if (bsf + 1 <= 2)
            printWaysToSelectBox4(cb + 1, tb, bsf + 1, asf + "b" + cb + " ");
        // No call
        printWaysToSelectBox4(cb + 1, tb, bsf, asf);
    }

    // dimension of box -> n(total row) * m (total col),
    // r-> row, c -> col, bsf -> box so far, asf-> answer so far

    // Print all Possibility to select all boxes in 2D Matrix
    public static void printWaysIn2D(int n, int m, int r, int c, int bsf, String asf) {
        if (r == n) {
            System.out.println(asf);
            return;
        }
        // Yes Call
        if (c + 1 < m)
            printWaysIn2D(n, m, r, c + 1, bsf + 1, asf + "(" + r + "-" + c + "), ");
        else
            printWaysIn2D(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c + "), ");

        // No Call
        if (c + 1 < m)
            printWaysIn2D(n, m, r, c + 1, bsf, asf);
        else
            printWaysIn2D(n, m, r + 1, 0, bsf, asf);
    }

    // Print Possibility to select r boxes from n boxes in 2d Matrx
    public static void printWays2D(int n, int m, int r, int c, int bsf, String asf) {
        if (r == n) {
            // r boxes
            if (bsf == 2)
                System.out.println(asf);
            return;
        }
        // Yes Call
        if (c + 1 < m)
            printWays2D(n, m, r, c + 1, bsf + 1, asf + "(" + r + "-" + c + "), ");
        else
            printWays2D(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c + "), ");

        // No Call
        if (c + 1 < m)
            printWays2D(n, m, r, c + 1, bsf, asf);
        else
            printWays2D(n, m, r + 1, 0, bsf, asf);
    }

    // Print Possibility to select r boxes from n boxes in 2d Matrx such that only
    // one box is selected form each row
    public static void printWaysIn2D2(int n, int m, int r, int c, int bsf, String asf) {
        if (r == n) {
            if (bsf == 2)
                System.out.println(asf);
            return;
        }

        if (c + 1 < m) { // next column is valid
            // yes call
            printWaysIn2D2(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c + "), ");
            // no call
            printWaysIn2D2(n, m, r, c + 1, bsf, asf);
        } else { // next column is invalid
            // yes call
            printWaysIn2D2(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c + "), ");
            // no call
            printWaysIn2D2(n, m, r + 1, 0, bsf, asf);
        }
    }
}
