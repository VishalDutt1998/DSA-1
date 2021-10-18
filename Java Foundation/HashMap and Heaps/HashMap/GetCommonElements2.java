package HashMap;

import java.io.*;
import java.util.*;

public class GetCommonElements2 {

    public static void printCommonElement2(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr1) {
            if (map.containsKey(key) == true) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int key : arr2) {
            if (map.containsKey(key) == true && map.get(key) > 0) {
                System.out.println(key);
                map.put(key, map.get(key) - 1);
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
        printCommonElement2(arr1, arr2);
    }
}
