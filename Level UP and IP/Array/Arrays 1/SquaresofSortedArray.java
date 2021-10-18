// https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.*;

public class SquaresofSortedArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int[] ans = sortedSquares(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] +" ");
        }
        scn.close();
    }
    public static int[] sortedSquares(int[] arr){
        int[] ans = new int[arr.length];
        int i=0;
        int j=arr.length-1;
        int k=ans.length-1;
        while(i<=j){
            ans[k] = Math.max(arr[i]*arr[i],arr[j]*arr[j]);
            if(arr[j]*arr[j]>arr[i]*arr[i]){
                j--;
            }else{
                i++;
            }
            k--;
        }
        return ans;
    }
}
// [-4,-1,0,3,10]
// [-7,-3,2,3,11]