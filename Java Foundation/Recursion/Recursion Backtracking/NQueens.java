import java.io.*;
import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        Nqueens(chess, "", 0);
        nqueens(chess, 0, 0, 0, "");
        nqueens(chess, 0, 0, 0, "");
    }

    public static void Nqueens(int[][] chess, String qpsf, int row) {
        if (row == chess.length) {
            System.out.println(qpsf + ".");
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (IsQueenSafe(chess, row, col) == true) {
                chess[row][col] = 1;
                Nqueens(chess, qpsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // Vertical Check
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    // Nqueens using Direction Array
    public static boolean isValidToPlace(int[][] chess, int r, int c) {
        int[][] dir = { { -1, 0 }, { -1, 1 }, { -1, -1 } };

        int radius = chess.length;
        for (int rad = 1; rad < radius; rad++) {
            for (int d = 0; d < dir.length; d++) {
                int rr = r + (rad * dir[d][0]);
                int cc = c + (rad * dir[d][1]);

                // calls
                if (rr >= 0 && rr < radius && cc >= 0 && cc < radius) {
                    if (chess[rr][cc] == 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static void nqueens(int[][] chess, int sr, int sc, int qpsf, String asf) {
        if (sr == chess.length) {
            // Print only if qpsf == chess.length
            if (qpsf == chess.length)
                System.out.println(asf);
            return;
        }
        if (sc + 1 < chess[0].length) {
            // Yes + isValid
            if (isValidToPlace(chess, sr, sc) == true) {
                chess[sr][sc] = 1;
                nqueens(chess, sr + 1, 0, qpsf + 1, asf + "(" + sr + "-" + sc + "),");
                chess[sr][sc] = 0;
            }
            // No Call
            nqueens(chess, sr, sc + 1, qpsf, asf);
        } else { // Next Column is not valid
            // Yes + isValid
            if (isValidToPlace(chess, sr, sc) == true) {
                chess[sr][sc] = 1;
                nqueens(chess, sr + 1, 0, qpsf + 1, asf + "(" + sr + "-" + sc + "),");
                chess[sr][sc] = 0;
            }
            // No Call
            nqueens(chess, sr + 1, 0, qpsf, asf);
        }
    }

    // Nqueens optimized as subsequence
    public static void nqueens(int[][] chess, int row, String asf) {
        if (row == chess.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isValidToPlace(chess, row, col) == true) {
                chess[row][col] = 1;
                nqueens(chess, row + 1, asf + row + "-" + col + ", ");
                chess[row][col] = 0;
            }
        }
    }
}
