// https://leetcode.com/problems/reverse-vowels-of-a-string/
// Leetcode 345. Reverse Vowels of a String

// import java.io.*;
import java.util.Scanner;
public class ReverseVowelsofString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // StringBuffer str = scn.nextLine();
        StringBuffer str = new StringBuffer(scn.nextLine());
        StringBuffer ans = reverseVowels(str);
        System.out.println(ans);
        scn.close();
    }
    public static boolean vowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
    public static StringBuffer reverseVowels(StringBuffer str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            boolean bool1 = vowel(str.charAt(i));
            boolean bool2 = vowel(str.charAt(j));
            if(bool1==true && bool2==true){
                swap(str.charAt(i),str.charAt(j));
                i++;
                j--;
            }
            if(bool1==false){
                i++;
            }else if(bool2==false){
                j--;
            }
        }
        return str;
    }
    public static void swap(char c1, char c2){
        char temp = c1;
        c1 = c2;
        c2 = temp;
    }
}
// https://leetcode.com/problems/reverse-vowels-of-a-string/
// Leetcode 345. Reverse Vowels of a String

// import java.io.*;
// import java.util.*;
// public class Main {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         String str = scn.nextLine();
//         String ans = reverseVowels(str);
//         System.out.println(ans);
//         scn.close();
//     }
//     public static boolean vowel(char ch){
//         if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
//             return true;
//         }
//         return false;
//     }
//     public static String reverseVowels(String str){
//         int i=0;
//         int j=str.length()-1;
//         while(i<j){
//             boolean bool1 = vowel(str.charAt(i));
//             boolean bool2 = vowel(str.charAt(j));
//             if(bool1==true && bool2==true){
//                 str =  swap(str,i,j);
//                 i++;
//                 j--;
//             }
//             if(bool1==false){
//                 i++;
//             }else if(bool2==false){
//                 j--;
//             }
//         }
//         return str;
//     }
//     public static String swap(String s,int i, int j){
//         char[] charr = s.toCharArray();
//         char temp = charr[i];
//         charr[i] = charr[j];
//         charr[j] = temp;
//         String ans = new String(charr);
//         return ans;
//     }
// }

// public int[] productExceptSelf(int[] nums) {
//     int n = nums.length;
//     int[] prefixprod = new int[n];
//     int suffixprod = 1;
    
//     prefixprod[0] = nums[0];
    
//     for(int i=1;i<n;i++){
//         prefixprod[i] = prefixprod[i-1]*nums[i];
//     }
    
//     int i=n-1;
//     while(i>=0){
//         int numsi = nums[i];
//         if(i==0){
//             nums[i]=suffixprod;
//             i--;
//         }else{
//             nums[i] = prefixprod[i-1]*suffixprod;
//             suffixprod*= numsi;
//             i--;                
//         }
//     }
//     return nums;
// }

