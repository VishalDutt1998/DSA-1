package HashMap;

import java.io.*;
import java.util.*;

public class LongestConsecutiveSequence {

    public static void printLongestConsecutiveSequence(int[] arr) {
        // 1. Create map for presence
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, true);
        }
        // 2. Make Starting Point of Sequence
        for (int key : arr) {
            if (map.containsKey(key - 1) == true) {
                map.put(key, false);
            }
        }
        // 3. Get Length and Starting point of Sequence
        int maxLenght = 0;
        int starting = 0;
        for (int key : arr) {
            if (map.get(key) == true) {
                // Key is the Starting Point
                int len = 1;
                int st = key;
                while (map.containsKey(key + 1) == true) {
                    len++;
                    key++;
                }
                if (maxLenght < len) {
                    maxLenght = len;
                    starting = st;
                }
                map.put(key, false);
            }
        }
        // 4. Print Answer
        for (int i = 0; i < maxLenght; i++) {
            System.out.println(starting);
            starting++;
        }
    }

    // Time Complexity O(n) Single Pass
    public static int longestConsecutive(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0; // maximun Consecutive length
        int fsp = 0; // final starting point
        int fep = 0; // final ending point
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];

            if (map.containsKey(n) == false) {
                int sp = n;
                int ep = n;

                // If Element attach to the end of the older sequence
                // Then Element is the ending Point calulate Starting point
                if (map.containsKey(n - 1) == true) {
                    sp = sp - map.get(n - 1);
                }

                // If Element attach to the front of the older sequence
                // Then Element is the Starting Point calulate end point
                if (map.containsKey(n + 1) == true) {
                    ep = ep + map.get(n + 1);
                }

                int len = ep - sp + 1;
                map.put(sp, len);
                map.put(ep, len);

                // Add the Element if if combines two sequence
                // To Avoid again processing its copy
                if (sp != n && ep != n) {
                    map.put(n, 1);
                }
                // max = Math.max(max, len);
                // fsp = sp;
                // fep = ep;
                if (len > max) {
                    max = len;
                    fsp = sp;
                    fep = ep;
                }
            }
        }

        // System.out.print(fsp + " " + fep);
        for (int i = fsp; i <= fep; i++) {
            System.out.print(i + " ");
        }
        return max;
    }

    public static void longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int os = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (map.containsKey(n) == false) {
                int sp = n;
                int ep = n;

                if (map.containsKey(n - 1) == true) {
                    sp = sp - map.get(n - 1);
                }

                if (map.containsKey(n + 1) == true) {
                    ep = ep + map.get(n + 1);
                }

                int newlen = ep - sp + 1;

                map.put(sp, newlen);
                map.put(ep, newlen);

                if (sp != n && ep != n) {
                    map.put(n, 1);
                }
                if (newlen == max && os > sp) {
                    os = sp;
                }
                if (newlen > max) {
                    os = sp;
                    max = newlen;
                }
            }
        }
        for (int i = os; i < (max + os); i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // printLongestConsecutiveSequence(arr);
        int len = longestConsecutive(arr);
        System.out.println();
        System.out.println(len);
    }
}

// 6
// 100 4 200 1 3 2
// OUTPUT
// 1 2 3 4
// 4

// 10
// 0 3 7 2 5 8 4 6 0 1
// OUTPUT
// 0 1 2 3 4 5 6 7 8
// 9

// 9
// 2 3 4 5 10 9 8 7 6
// OUTPUT
// 2 3 4 5 6 7 8 9 10
// 9

// 4 0 -4 -2 2 5 2 0 -8 -8 -8 -8 -1 7 5 5 -4 6 6 -3
// [4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 5, 5, -4, 6, 6, -3]
// OUTPUT
// 5
