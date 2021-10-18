// Place K- Nights Such that key do no kill Each onter
import java.io.*;
import java.util.*;

public class PlaceKknights {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        boolean[][] board = new boolean[3][3];
        Nknights(board, 0, 0, 0, board.length, "");
    }

    public static int count = 0;

    public static void Nknights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {
        if (kpsf == tk) {
            System.out.println(++count + "." + ans);
            return;
        }

        if (col == board[0].length) {
            row++;
            col = 0;
        }

        if (row == board.length) {
            return;
        }

        // Yes Call
        if (isNknightSafe(board, row, col)) {
            board[row][col] = true;
            Nknights(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "-" + col + "}");
            board[row][col] = false;
        }

        // No Call
        Nknights(board, row, col + 1, kpsf, tk, ans);
    }

    public static boolean isNknightSafe(boolean[][] board, int row, int col) {
        int[] rowArr = { -1, -2, -2, -1 };
        int[] colArr = { 2, 1, -1, -2 };

        for (int i = 0; i < 4; i++) {
            int r = row + rowArr[i];
            int c = col + colArr[i];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }


    // https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/
    // lqpb = last queen palce box
    // KNights Proactive
    public static int counter=1;
    public static void NKnightsproactive(boolean[][] chess, int qpsf, String asf, int lqpb) {

        if (qpsf == chess.length) {
            counter++;
            System.out.println(counter + ". " + asf);
            return;
        }

        for (int b = lqpb + 1; b < chess.length * chess.length; b++) {
            int row = b / chess.length;
            int col = b % chess.length;

            if (chess[row][col] == false) {
                if (theKnightIsSafe(chess, row, col) == true) {
                    chess[row][col] = true;
                    NKnightsproactive(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                    chess[row][col] = false;
                }
            }
        }
    }

    public static boolean theKnightIsSafe(boolean[][] chess, int row, int col) {
        int[][] dirs = { { +1, -2 }, // N
                { +2, -1 }, // NE
                { +2, +1 }, // E
                { +1, +2 }, // SE
                { -1, +2 }, // S
                { -2, +1 }, // SW
                { -2, -1 }, // W
                { -1, -2 }, // NW
        };

        for (int di = 0; di < dirs.length; di++) {
            int ekcol = col + dirs[di][0];
            int ekrow = row + dirs[di][1];

            // Check for boundary conditions
            if (ekcol < 0 || ekrow < 0 || ekcol >= chess[0].length || ekrow >= chess.length) {
                continue;
            }

            if (chess[ekrow][ekcol] == true) {
                return false;
            }
        }
        return true;
    }

}
