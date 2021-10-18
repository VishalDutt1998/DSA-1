// import java.io.*;
// import java.util.*;

// public class CountNumberofIslands {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 		int m = Integer.parseInt(br.readLine());
// 		int n = Integer.parseInt(br.readLine());
// 		int[][] arr = new int[m][n];

// 		for (int i = 0; i < arr.length; i++) {
// 			String parts = br.readLine();
// 			for (int j = 0; j < arr[0].length; j++) {
// 				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
// 			}
// 		}

// 		boolean[][] visited = new boolean[arr.length][arr[0].length];
// 		int count = 0;
// 		for (int i = 0; i < arr.length; i++) {
// 			for (int j = 0; j < arr[0].length; j++) {
// 				if (arr[i][j] == 0 && visited[i][j] == false) {
// 					traversal(arr, visited, i, j);
// 					count++;
// 				}
// 			}
// 		}
// 		System.out.println(count);
// 	}

//  Reactive Calls
// 	public static void traversal(int[][] arr, boolean[][] visited, int i, int j) {
// 		if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 1 || visited[i][j] == true) {
// 			return;
// 		}
// 		visited[i][j] = true;
// 		traversal(arr, visited, i - 1, j);
// 		traversal(arr, visited, i, j + 1);
// 		traversal(arr, visited, i + 1, j);
// 		traversal(arr, visited, i, j - 1);
// 	}

//  Proactive Calls
// 	public static void numberofislands(int[][] arr, boolean[][] visited, int i, int j) {
// 		visited[i][j] = true;
// 		if (i - 1 >= 0 && arr[i - 1][j] == 0 && visited[i - 1][j] == false) {
// 			numberofislands(arr, visited, i - 1, j);
// 		}
// 		if (j + 1 < arr[0].length && arr[i][j + 1] == 0 && visited[i][j + 1] == false) {
// 			numberofislands(arr, visited, i, j + 1);
// 		}
// 		if (i + 1 < arr.length && arr[i + 1][j] == 0 && visited[i + 1][j] == false) {
// 			numberofislands(arr, visited, i + 1, j);
// 		}
// 		if (j - 1 >= 0 && arr[i][j - 1] == 0 && visited[i][j - 1] == false) {
// 			numberofislands(arr, visited, i, j - 1);
// 		}
// 	}
// }

// Converting 0 to 1
import java.io.*;
import java.util.*;

public class CountNumberofIslands {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					numberofislands(arr, i, j);
					count++;
				}
			}
		}
		System.out.println(count);

	}

	// Reactive Calls
	// public static void numberofislands(int[][] arr, int i, int j) {
	// 	if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 1) {
	// 		return;
	// 	}
	// 	arr[i][j] = 1;
	// 	numberofislands(arr, i - 1, j);
	// 	numberofislands(arr, i, j + 1);
	// 	numberofislands(arr, i + 1, j);
	// 	numberofislands(arr, i, j - 1);
	// }

	// Proactive Calls
	public static void numberofislands(int[][] arr, int i, int j) {
		arr[i][j] = 1;
		if (i - 1 >= 0 && arr[i - 1][j] == 0) {
			numberofislands(arr, i - 1, j);
		}
		if (j + 1 < arr[0].length && arr[i][j + 1] == 0) {
			numberofislands(arr, i, j + 1);
		}
		if (i + 1 < arr.length && arr[i + 1][j] == 0) {
			numberofislands(arr, i + 1, j);
		}
		if (j - 1 >= 0 && arr[i][j - 1] == 0) {
			numberofislands(arr, i, j - 1);
		}
	}
}

// Input
// 8
// 8
// 0 0 1 1 1 1 1 1
// 0 0 1 1 1 1 1 1
// 1 0 0 1 1 1 1 0
// 1 1 0 0 0 0 0 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 1 1 1 0
// 1 1 1 1 1 1 1 0

// Output
// 1