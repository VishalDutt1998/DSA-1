// https://leetcode.com/problems/max-chunks-to-make-sorted/
// Leetcode 769
import java.io.*;
import java.util.*;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int ans = maxChunksToSorted(arr);
        System.out.println(ans);
    }
    
    public static int maxChunksToSorted(int[] arr){
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            if(max==i){
                ans++;
            }
        }
        return ans;
    }
}


// 9
// 2 1 3 0 5 4 7 8 6