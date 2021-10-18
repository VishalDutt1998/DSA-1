// https://leetcode.com/problems/largest-number-at-least-twice-of-others/


import java.util.Scanner;
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int ans = dominantIndex(arr); 
        System.out.println(ans);
        scn.close();
    }
    public static int dominantIndex(int[] arr){
        int max1 = arr[0];
        int pos = 0;
        int max2 = Integer.MIN_VALUE;

        for(int i=1;i<arr.length;i++){
            if(arr[i]>max1){
                max2 = max1;
                max1 = arr[i];
                pos = i;
            }else if(arr[i]>max2){
                max2 = arr[i];
            }
        }
        if(max1>=2*max2){
            return pos;
        }else{
            return -1;
        }
    }
}

// Test Cases
// 0 0 3 2
