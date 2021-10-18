import java.io.*;
import java.util.*;

public class PrintStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
        // int res = printStairPaths5(n,"");
        // System.out.println(res);
    }

    public static void printStairPaths(int n, String path) {
        // Positive Base Case
        if (n == 0) {
            System.out.println(path);
            return;
        }
        // Negative Base case
        if (n < 0) {
            return;
        }
        // Reactive Calls
        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }

    // Proactive Calls using Loop
    public static void printStairPaths2(int n, String path) {
        // Positive Base Case
        if (n == 0) {
            System.out.println(path);
        }
        // Proactive Calls
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            printStairPaths2(n - jump, path + jump);
        }
    }

    public static void printStairPaths3(int n, String path) {
        // Negative Base case
        if (n <= 0) {
            // Positive Base Case
            if (n == 0) {
                System.out.println(path);
                return;
            }
            return;
        }
        // Reactive Calls
        printStairPaths3(n - 1, path + "1");
        printStairPaths3(n - 2, path + "2");
        printStairPaths3(n - 3, path + "3");
    }

    // Another Way of Proactive Calls
    public static void printStairPaths4(int n, String path) {
        // Positive Base case
        if (n == 0) {
            System.out.println(path);
            return;
        }
        // Proactive Calls
        if (n - 1 >= 0)
            printStairPaths4(n - 1, path + "1");
        if (n - 2 >= 0)
            printStairPaths4(n - 2, path + "2");
        if (n - 3 >= 0)
            printStairPaths4(n - 3, path + "3");
    }

    // Count the Number of Steps without Golobal Variable
    public static int printStairPaths5(int n, String path) {
        // Positive Base case
        if (n == 0) {
            System.out.println(path);
            return 1;
        }
        int count = 0;
        // Proactive Calls
        if (n - 1 >= 0)
            count += printStairPaths5(n - 1, path + "1");
        if (n - 2 >= 0)
            count += printStairPaths5(n - 2, path + "2");
        if (n - 3 >= 0)
            count += printStairPaths5(n - 3, path + "3");

        return count;
    }

    // Climbing Up Staris
    public static void printStairPaths6(int sr, int dest, String path) {
        // Positive Base Case
        if (sr == dest) {
            System.out.println(path);
            return;
        }
        // Negative Base case
        if (sr > dest) {
            return;
        }
        // Reactive Calls
        printStairPaths6(sr + 1, dest, path + "1");
        printStairPaths6(sr + 2, dest, path + "2");
        printStairPaths6(sr + 3, dest, path + "3");
    }
}