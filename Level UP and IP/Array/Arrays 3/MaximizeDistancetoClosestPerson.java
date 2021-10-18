// // https://leetcode.com/problems/maximize-distance-to-closest-person/
// // Leetcode 849. Maximize Distance to Closest Person

// import java.util.*;

// public class MaximizeDistancetoClosestPerson {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i] = scn.nextInt();
//         }
//         int ans = maxDistToClosest(arr);
//         System.out.println(ans);
//         scn.close();
//     }
//     public static int maxDistToClosest(int[] arr){
//         int ans = Integer.MIN_VALUE;

//         return ans;
//     }
// }
// public class Solution {
//     public static int nextGreaterElement(int n) {
//         String str = String.valueOf(n);
//         char[] charr = str.toCharArray();
//         int len = str.length();
//         int pos = 0;
//         for (int i = len - 2; i >= 0; i--) {
//             if (charr[i + 1] > charr[i]) {
//                 pos = i;
//                 break;
//             }
//         }
//         int cidx = 0;
//         char c = 'A';
//         for (int j = pos + 1; j < len; j++) {
//             if ((charr[j] > charr[pos]) && (charr[j] < c)) {
//                 c = charr[j];
//                 cidx = j;
//             }

//         }
//         char temp = charr[pos];
//         charr[pos] = charr[cidx];
//         charr[cidx] = temp;

//         int si = pos + 1;
//         int ei = charr.length - 1;
//         while (si < ei) {
//             if (charr[si] > charr[ei]) {
//                 char tmp = charr[si];
//                 charr[si] = charr[ei];
//                 charr[ei] = tmp;
//             }
//             si++;
//             ei--;
//         }
//         long ans = convertToInt(charr);
//         int s = (int) ans;
//         if (ans > Integer.MAX_VALUE)
//             return -1;
//         else if (ans == n) {
//             return -1;
//         } else {
//             return s;
//         }
//     }

//     public static long convertToInt(char[] s) {
//         long num = s[0] - '0';
//         for (int i = 1; i < s.length; i++) {
//             num = num * 10 + (s[i] - '0');
//         }
//         return num;
//     }
// }