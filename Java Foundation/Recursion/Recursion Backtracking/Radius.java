import java.io.*;
import java.util.*;

public class Radius {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // direction();
        direction2();
    }

    public static void direction() {
        int r = 10;
        int c = 10;
        int[] rdir = { -1, 0, 1, 0 };
        int[] cdir = { 0, 1, 0, -1 };

        int[][] dirarr = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        // for radius 1
        int radius = 1;
        for (int rad = 1; rad <= radius; rad++) {
            for (int dir = 0; dir < rdir.length; dir++) {
                int rr = r + (rad * rdir[dir]);
                int cc = c + (rad * cdir[dir]);

                System.out.println("Radius : " + rad + "dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int dir = 0; dir < rdir.length; dir++) {
            for (int rad = 1; rad <= radius; rad++) {
                int rr = r + (rad * rdir[dir]);
                int cc = c + (rad * cdir[dir]);

                System.out.println("Radius : " + rad + " dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }
    }

    public static void direction2() {
        int n = 5;
        int m = 4;
        int r = 1;
        int c = 1;
        int[] rdir = { -1, 0, 1, 0 };
        int[] cdir = { 0, 1, 0, -1 };

        // for radius 1
        int radius = 3;
        System.out.println("Radius Wise Traversal");
        for (int rad = 1; rad <= radius; rad++) {
            for (int dir = 0; dir < rdir.length; dir++) {
                int rr = r + (rad * rdir[dir]);
                int cc = c + (rad * cdir[dir]);
                if (rr >= 0 && rr < n && cc >= 0 && cc < m)
                    System.out.println("Radius : " + rad + " dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Direction Wise Traversal");
        for (int dir = 0; dir < rdir.length; dir++) {
            for (int rad = 1; rad <= radius; rad++) {
                int rr = r + (rad * rdir[dir]);
                int cc = c + (rad * cdir[dir]);

                if (rr >= 0 && rr < n && cc >= 0 && cc < m)
                    System.out.println("Radius : " + rad + " dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }
    }

    public static void demoForQueenTraversal() {
        int n = 8;
        int m = 8;

        int r = 0;
        int c = 0;

        int[][] dirs = { { -1, 0 }, //
                { -1, 1 }, //
                { 0, 1 }, //
                { 1, 1 }, //
                { 1, 0 }, //
                { 1, -1 }, //
                { 0, -1 }, //
                { -1, -1 } //
        };
        int radius = Math.max(n, m);
        System.out.println("Radius Wise Traversal");
        for (int rad = 1; rad <= radius; rad++) {
            for (int dir = 0; dir < dirs.length; dir++) {
                int rr = r + (rad * dirs[dir][0]);
                int cc = c + (rad * dirs[dir][1]);
                if (rr >= 0 && rr < n && cc >= 0 && cc < m)
                    System.out.println("Radius : " + rad + " dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Direction Wise Traversal");
        for (int dir = 0; dir < dirs.length; dir++) {
            for (int rad = 1; rad <= radius; rad++) {
                int rr = r + (rad * dirs[dir][0]);
                int cc = c + (rad * dirs[dir][1]);

                if (rr >= 0 && rr < n && cc >= 0 && cc < m)
                    System.out.println("Radius : " + rad + " dir : " + dir + " -> row : " + rr + " , col : " + cc);
            }
        }
    }

    public static void demoForKnightTraversal() {
        int[] rdir = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] cdir = { 1, 2, 2, 1, -1, -2, -2, -1 };
        int r = 4;
        int c = 4;
        for (int d = 0; d < rdir.length; d++) {
            int rr = r + rdir[d];
            int cc = c + cdir[d];

            System.out.println("row : " + rr + " , col : " + cc);
        }
    }
}

// If Outer Loop is rad loop
// Radius : 1 dir : 0 -> row : 9 , col : 10
// Radius : 1 dir : 1 -> row : 10 , col : 11
// Radius : 1 dir : 2 -> row : 11 , col : 10
// Radius : 1 dir : 3 -> row : 10 , col : 9
// Radius : 2 dir : 0 -> row : 8 , col : 10
// Radius : 2 dir : 1 -> row : 10 , col : 12
// Radius : 2 dir : 2 -> row : 12 , col : 10
// Radius : 2 dir : 3 -> row : 10 , col : 8

// If outer loop is dir loop
// Radius : 1 dir : 0 -> row : 9 , col : 10
// Radius : 2 dir : 0 -> row : 8 , col : 10
// Radius : 1 dir : 1 -> row : 10 , col : 11
// Radius : 2 dir : 1 -> row : 10 , col : 12
// Radius : 1 dir : 2 -> row : 11 , col : 10
// Radius : 2 dir : 2 -> row : 12 , col : 10
// Radius : 1 dir : 3 -> row : 10 , col : 9
// Radius : 2 dir : 3 -> row : 10 , col : 8

// Radius Wise Traversal
// Radius : 1 dir : 0 -> row : 0 , col : 1
// Radius : 1 dir : 1 -> row : 1 , col : 2
// Radius : 1 dir : 2 -> row : 2 , col : 1
// Radius : 1 dir : 3 -> row : 1 , col : 0
// Radius : 2 dir : 1 -> row : 1 , col : 3
// Radius : 2 dir : 2 -> row : 3 , col : 1
// Radius : 3 dir : 2 -> row : 4 , col : 1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Direction Wise Traversal
// Radius : 1 dir : 0 -> row : 0 , col : 1
// Radius : 1 dir : 1 -> row : 1 , col : 2
// Radius : 2 dir : 1 -> row : 1 , col : 3
// Radius : 1 dir : 2 -> row : 2 , col : 1
// Radius : 2 dir : 2 -> row : 3 , col : 1
// Radius : 3 dir : 2 -> row : 4 , col : 1
// Radius : 1 dir : 3 -> row : 1 , col : 0