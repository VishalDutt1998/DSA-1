// https://leetcode.com/problems/majority-element/
// https://www.geeksforgeeks.org/majority-element/
// Moore’s Voting Algorithm
// import java.io.*;
import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int majority = majorityElement(arr);
        System.out.println(majority);
        scn.close();
    }
    public static int majorityElement(int[] arr){
        int val = arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==val){
                count++;
            }else if(count==0){
                val = arr[i];
                count=1;
            }else{
                count--;
            }
        }
        return val;
    }
}
// 10
// 2 4 3 2 2 3 2 2 1 2