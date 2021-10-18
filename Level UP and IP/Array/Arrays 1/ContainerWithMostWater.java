// https://leetcode.com/problems/container-with-most-water/

import java.util.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int ans = mostwater(arr);
        System.out.println(ans);
        scn.close();
    }
    public static int mostwater(int[] height) {
        int i=0;
        int j=height.length-1;
        int omax = Integer.MIN_VALUE;
        while(i<j){
            int storage = (j-i)*Math.min(height[i], height[j]);
            omax = Math.max(omax,storage);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return omax;
    }
}
// 9
// [1,8,6,2,5,4,8,3,7]