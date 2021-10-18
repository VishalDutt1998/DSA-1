// Leetcode 238
// https://leetcode.com/problems/product-of-array-except-self

import java.util.*;
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        // int[] ans = productExceptSelf(arr);
        int[] ans = productExceptSelfconst(arr);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        scn.close();
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixprod = new int[n];
        int[] suffixprod = new int[n];
        
        prefixprod[0] = nums[0];
        suffixprod[n-1] = nums[n-1];
        
        for(int i=1;i<n;i++){
            prefixprod[i] = prefixprod[i-1]*nums[i];
        }
        
        for(int i=n-2;i>=0;i--){
            suffixprod[i] = suffixprod[i+1]*nums[i];
        }
        
        for(int i=0;i<n;i++){
            if(i==0){
                nums[i]=suffixprod[i+1];
            }
            if(i==n-1){
                nums[i] = prefixprod[i-1];
            }
            else if(i>=1 && i<=n-1){
                nums[i] = prefixprod[i-1]*suffixprod[i+1];
            }
        }
        return nums;
    }

    public static int[] productExceptSelfconst(int[] nums) {
        int n = nums.length;
        int[] prefixprod = new int[n];
        int suffixprod = 1;
        
        prefixprod[0] = nums[0];
        
        for(int i=1;i<n;i++){
            prefixprod[i] = prefixprod[i-1]*nums[i];
        }
        
        int i=n-1;
        while(i>=0){
            int numsi = nums[i];
            if(i==0){
                nums[i]=suffixprod;
                i--;
            }else{
                nums[i] = prefixprod[i-1]*suffixprod;
                suffixprod*= numsi;
                i--;                
            }
        }
        return nums;
    }
}
// 5
// -1 1 0 -3 3
// 0 0 9 0 0