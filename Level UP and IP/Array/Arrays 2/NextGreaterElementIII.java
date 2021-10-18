// https://leetcode.com/problems/next-greater-element-iii/submissions/
// Leetcode 556 Next Greater Element III
// import java.util.*;
// public class NextGreaterElementIII {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         String str = scn.nextLine();
//         int n = str.length()-2;
//         int pos=0;

//         scn.close();
//     }
// }

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String num = String.valueOf(n);
        long ans = nextGreaterElement(num);
        System.out.println(ans);
    }

    public static long nextGreaterElement(String str) {
        char[] charr = str.toCharArray(); // 8 7 3 9 4 8 7 5 3 2
        int len = str.length(); 
        int pos = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (charr[i + 1] > charr[i]) {
                pos = i;
                break;
            }
        }
        int cidx = 0;
        char c = 'A';
        for (int j = pos + 1; j < len; j++) {
            if ((charr[j] > charr[pos]) && (charr[j] < c)) {
                c = charr[j];
                cidx = j;
            }
        }
        char temp = charr[pos];
        charr[pos] = charr[cidx];
        charr[cidx] = temp;

        int si = pos + 1;
        int ei = charr.length - 1;
        while (si < ei) {
            if (charr[si] > charr[ei]) {
                char tmp = charr[si];
                charr[si] = charr[ei];
                charr[ei] = tmp;
            }
            si++;
            ei--;
        }
        long ans = convertToInt(charr);
        if (ans > Integer.MAX_VALUE)
            return -1;
        int res = (int) ans;
        if (res <= n)
            return -1;
        return res;
    }

    public static long convertToInt(char[] s) {
        long num = s[0] - '0';
        for (int i = 1; i < s.length; i++) {
            num = num * 10 + (s[i] - '0');
            System.out.println(num);
        }
        return num;
    }
}

// 321
// -1