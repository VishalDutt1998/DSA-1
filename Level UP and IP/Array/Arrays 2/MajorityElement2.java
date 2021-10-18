// https://leetcode.com/problems/majority-element-ii/

import java.io.*;
import java.util.*;
public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        ArrayList<Integer> majority = majorityElement(arr);
        System.out.println(majority);
    }
    public static ArrayList<Integer> majorityElement(int[] arr){
        int val1 = arr[0];
        int val2 = arr[0];
        int count1 = 1;
        int count2 = 0;

        for(int i=1;i<arr.length;i++){
            if(val1==arr[i]){
                count1++;
            }else if(val2==arr[i]){
                count2++;
            }else if(count1==0){
                val1 = arr[i];
                count1=1;
            }else if(count2==0){
                val2 = arr[i];
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }

        int freq1=0;
        int freq2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val1){
                freq1++;
            }
            if(arr[i]==val2){
                freq2++;
            }
        }
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if(freq1>n/3){
            ans.add(val1);
        }
        if(val1!=val2 && freq2>n/3){
            ans.add(val2);
        }
        return ans;
    }
}
