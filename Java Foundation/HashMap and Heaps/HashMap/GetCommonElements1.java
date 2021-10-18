package HashMap;

import java.io.*;
import java.util.*;

public class GetCommonElements1 {
    public static void printCommonElement1(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 1. Prepare map for array 1 elements
        for (int key : arr1) {
            map.put(key, 1);
        }

        // 2. Travel in arr2 and check if arr2 element is present in HashMap or not
        for (int key : arr2) {
            if (map.containsKey(key) == true) {
                System.out.println(key);
                map.remove(key);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }
        printCommonElement1(arr1, arr2);
    }
}
