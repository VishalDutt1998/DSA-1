import java.io.*;
import java.util.*;

public class FloodFill {

    public static int[] rdir = { -1, 0, 1, 0 };
    public static int[] cdir = { 0, -1, 0, 1 };
    public static char[] chArr = { 't', 'l', 'd', 'r' };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
        // Negative Base Case
        if (sr < 0 || sc < 0 || sr > maze.length - 1 || sc > maze[0].length - 1 || maze[sr][sc] == 1 || visited[sr][sc] == true) {
            return;
        }

        // Positive Base Case
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }

        // Reactive Calls
        // Marking
        visited[sr][sc] = true;
        floodfill(maze, sr - 1, sc, asf + "t", visited);
        floodfill(maze, sr, sc - 1, asf + "l", visited);
        floodfill(maze, sr + 1, sc, asf + "d", visited);
        floodfill(maze, sr, sc + 1, asf + "r", visited);
        // Unmarking
        visited[sr][sc] = false;
    }

    // Using Direction Array
    public static void floodfill(int[][] maze, int sr, int sc, String asf) {

        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }
        maze[sr][sc] = 1;
        for (int d = 0; d < 4; d++) {
            int rr = sr + rdir[d];
            int cc = sc + cdir[d];
            char dir = chArr[d];
            if (rr >= 0 && rr < maze.length && cc >= 0 && cc < maze[0].length && maze[rr][cc] != 1) {
                floodfill(maze, rr, cc, asf + dir);
            }
        }
        maze[sr][sc] = 0;
    }
}
