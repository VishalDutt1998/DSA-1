// https://www.lintcode.com/problem/range-addition/description

import java.util.*;
public class RangeAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] query = new int[n][3];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                query[i][j] = scn.nextInt();
            }
        }
        int[] ans = rangeadditionWay1(n,query);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        scn.close();
    }

    public static int[] rangeadditionWay1(int n,int[][] query){
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int si = query[i][0];
            int ei = query[i][1];
            int val = query[i][2];

            ans[si]+=val;

            if(ei+1<n){
                ans[ei+1]-=val;
            }
        }

        int[] prefixarr = new int[n];
        prefixarr[0] = ans[0];

        for(int i=1;i<prefixarr.length;i++){
            prefixarr[i] = prefixarr[i-1]+ans[i];
        }
        return prefixarr;
    }
}


// Given:
// length = 5,
// updates = 
// [
// [1,  3,  2],
// [2,  4,  3],
// [0,  2, -2]
// ]
// return [-2, 0, 3, 5, 3]

// Explanation:
// Initial state:
// [ 0, 0, 0, 0, 0 ]
// After applying operation [1, 3, 2]:
// [ 0, 2, 2, 2, 0 ]
// After applying operation [2, 4, 3]:
// [ 0, 2, 5, 5, 3 ]
// After applying operation [0, 2, -2]:
// [-2, 0, 3, 5, 3 ]