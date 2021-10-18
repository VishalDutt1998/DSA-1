import java.io.*;
import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        // boolean[][] chess = new boolean[4][4];
        boolean[][] chess = new boolean[4][4];
        // boolean[][] chess = new boolean[3][3];

        long start = System.currentTimeMillis();
        NQueenscombinations(chess, 0, "", -1);
        NQueens(chess, 0, "", -1);
        // NQueensproactive(chess, 0 , " ", -1);
        // NQueensLikeASS(chess, 0, 0, "");
        // NKnightsproactive(chess, 0, "", -1);

        // check base case kpsf 5 the two ans is possible
        // NKnightsproactive(chess, 0, "", -1);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static int counter = 0;

    // This Function Generates all the combination of the chess board
    public static void NQueenscombinations(boolean[][] chess, int qpsf, String asf, int lqpb) {

        if (qpsf == chess.length) {
            counter++;
            System.out.println(counter + ". " + asf);
            return;
        }

        for (int b = lqpb + 1; b < chess.length * chess.length; b++) {
            int row = b / chess.length;
            int col = b % chess.length;

            if (chess[row][col] == false) {
                chess[row][col] = true;
                NQueenscombinations(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                chess[row][col] = false;
            }
        }
    }

    // This function generate all the combinations and then check for the validity
    // of the queen
    // Reactive Approach
    public static void NQueens(boolean[][] chess, int qpsf, String asf, int lqpb) {

        if (qpsf == chess.length) {
            counter++;
            if (theChessBoardIsValid(chess) == true) {
                System.out.println(counter + ". " + asf);
            }
            return;
        }

        for (int b = lqpb + 1; b < chess.length * chess.length; b++) {
            int row = b / chess.length;
            int col = b % chess.length;

            if (chess[row][col] == false) {
                chess[row][col] = true;
                NQueens(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                chess[row][col] = false;
            }
        }
    }

    // Proactive Approach
    public static void NQueensproactive(boolean[][] chess, int qpsf, String asf, int lqpb) {

        if (qpsf == chess.length) {
            counter++;
            System.out.println(counter + ". " + asf);
            return;
        }

        for (int b = lqpb + 1; b < chess.length * chess.length; b++) {
            int row = b / chess.length;
            int col = b % chess.length;

            if (chess[row][col] == false) {
                if (theQueenIsSafe(chess, row, col) == true) {
                    chess[row][col] = true;
                    NQueensproactive(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                    chess[row][col] = false;
                }
            }
        }
    }

    public static boolean theChessBoardIsValid(boolean[][] chess) {
        for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess[row].length; col++) {
                if (chess[row][col] == true) {
                    if (theQueenIsSafe(chess, row, col) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean theQueenIsSafe(boolean[][] chess, int row, int col) {
        int[][] dirs = { { 0, -1 }, // N
                { +1, -1 }, // NE
                { +1, 0 }, // E
                { +1, +1 }, // SE
                { 0, +1 }, // S
                { -1, +1 }, // SW
                { -1, 0 }, // W
                { -1, -1 }, // NW
        };

        for (int di = 0; di < dirs.length; di++) {
            for (int dist = 1; true; dist++) {
                int eqcol = col + dist * dirs[di][0];
                int eqrow = row + dist * dirs[di][1];

                // Check for boundary conditions
                if (eqcol < 0 || eqrow < 0 || eqcol >= chess[0].length || eqrow >= chess.length) {
                    break;
                }

                if (chess[eqrow][eqcol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    // NQueens Like Subsequence
    public static void NQueensLikeASS(boolean[][] chess, int box, int qpsf, String asf) {

        if (qpsf == chess.length) {
            System.out.println(asf);
            return;
        }

        // Negative Base case
        if (box >= chess.length * chess.length) {
            return;
        }

        NQueensLikeASS(chess, box + 1, qpsf, asf);

        int row = box / chess.length;
        int col = box % chess.length;
        if (chess[row][col] == false) {
            if (theQueenIsSafe(chess, row, col) == true) {
                chess[row][col] = true;
                NQueensLikeASS(chess, box + 1, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + box + " ");
                chess[row][col] = false;
            }
        }
    }

    // https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/
    // lqpb = last queen palce box
    // KNights Proactive
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