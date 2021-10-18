// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
// Leetcode 795

// import java.io.*;
import java.util.*;

public class NumberofSubarrayswithBoundedMaximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int L = scn.nextInt();
        int R = scn.nextInt();
        int ans = numSubarrayBoundedMax(arr,L,R);
        System.out.println(ans);
        scn.close();
    }

    public static int numSubarrayBoundedMax(int[] arr, int L, int R){
        int i=0;
        int ans = 0;
        int PrevValidCount = 0;

        for(int j=0;j<arr.length;j++){
            if(arr[j]>=L && arr[j]<=R){
                ans+= (j-i+1);

                PrevValidCount = j-i+1;
            }else if(arr[j]<L){
                ans+= PrevValidCount;
            }else {
                i=j+1;
                PrevValidCount = 0;
            }
        }
        return ans;
    }
}
// 9
// [0,3,1,4,2,1,5,10,6]
// 0 3 1 4 2 1 5 10 6
// 3
// 6