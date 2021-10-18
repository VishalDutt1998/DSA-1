import java.io.*;
import java.util.*;

public class Permutation1 {
	// ci --> current items
	// ti --> total items
	public static void permutations(int[] boxes, int ci, int ti) {
		// Base Case
		if (ci > ti) {
			for (int i = 0; i < boxes.length; i++) {
				System.out.print(boxes[i]);
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == 0) {
				boxes[i] = ci;
				permutations(boxes, ci + 1, ti);
				boxes[i] = 0;
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int nboxes = scn.nextInt();
		int ritems = scn.nextInt();
		permutations(new int[nboxes], 1, ritems);
		scn.close();
	}
}

// 1200
// 1020
// 1002
// 2100
// 0120
// 0102
// 2010
// 0210
// 0012
// 2001
// 0201
// 0021