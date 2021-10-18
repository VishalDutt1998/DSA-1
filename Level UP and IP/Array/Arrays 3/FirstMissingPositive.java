// https://leetcode.com/problems/first-missing-positive/
// Leetcode 41. First Missing Positive

import java.util.*;
public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int num = firstMissingPositive(arr);
        System.out.println(num);
        scn.close();
    }
    public static int firstMissingPositive(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i+1==arr[i]){
                continue;
            }
            if(arr[i]<1 || arr[i]>n){
                continue;
            }

            int idx1 = i;
            int idx2 = arr[i]-1;
            if(arr[idx1] == arr[idx2]){
                continue;
            }
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
            i--;        
        }

        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
