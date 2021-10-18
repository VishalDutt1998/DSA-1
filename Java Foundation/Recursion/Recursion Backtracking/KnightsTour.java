import java.io.*;
import java.util.*;

public class KnightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);

        // printKnightsTour2(chess, r, c, 1);

        // board[r][c]=1;
        // printKnightsTour3(board,r,c,1);
        // board[r][c]=0;
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        }

        if (upcomingMove == chess.length * chess.length) {
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Level and Options
    // level -> cell
    // option -> places
    public static int[] xdir = { -2, -1, 1, 2, 2, 1, -1, -2 };
    public static int[] ydir = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public static int counting = 1;

    public static void printKnightsTour2(int[][] board, int r, int c, int count) {
        if (count == board.length * board.length) {
            board[r][c] = count;
            displayBoard(board);
            board[r][c] = 0;
            return;
        }
        // mark
        board[r][c] = count;
        for (int d = 0; d < xdir.length; d++) {
            int rr = r + xdir[d];
            int cc = c + ydir[d];
            if (rr >= 0 && rr < board.length && cc >= 0 && cc < board.length && board[rr][cc] == 0) {
                printKnightsTour2(board, rr, cc, count + 1);
            }
        }
        // unmark
        board[r][c] = 0;
    }

    public static void printKnightsTour3(int[][] board, int r, int c, int count) {
        if (count == board.length * board.length) {
            // board[r][c] = count;
            displayBoard(board);
            // board[r][c] = 0;
            return;
        }
        // mark
        // board[r][c] = count;
        for (int d = 0; d < xdir.length; d++) {
            int rr = r + xdir[d];
            int cc = c + ydir[d];
            if (rr >= 0 && rr < board.length && cc >= 0 && cc < board.length && board[rr][cc] == 0) {
                // Marking Where we are going
                board[rr][cc] = count + 1;
                printKnightsTour3(board, rr, cc, count + 1);
                board[rr][cc] = 0;
            }
        }
        // unmark
        // board[r][c] = 0;
    }

    // public static void displayBoard(int[][] board) {
    // System.out.println("~~~~~~~" + counting + "~~~~~~");
    // for (int[] arr : board) {
    // for (int val : arr) {
    // System.out.print(val + " ");
    // }
    // System.out.println();
    // }
    // System.out.println("~~~~~~~" + counting + "~~~~~~");
    // }

}