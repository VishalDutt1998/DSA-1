import java.io.*;
import java.util.*;

public class BinarySearch {
	public static void main(String[] args) {
		// Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int data = -10;
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (data > arr[mid]) {
				l = mid + 1;
			} else if (data < arr[mid]) {
				h = mid - 1;
			} else {
				System.out.println(mid);
				return;
			}
		}
		System.out.println(-1);
	}
}