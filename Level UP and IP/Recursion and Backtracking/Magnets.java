// import java.io.*;
// import java.util.*;

// public class Magnets {

//     public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans, int row, int col) {
//         //Base Case 
//         if(row==arr.length){

//             return false;
//         }
//         int nr = row;
//         int nc = col;

//         if(col==arr[0].length-1){
//             nr++;
//             nc=0;
//         }else {
//             nc++;
//         }
//         if(ans[row][col] == 'X'){
//             if(col+1 < arr[0].length && arr[row][col] == 'L' && arr[row][col+1]=='R');{
//                 if(issafe(ans,top,left,right,bottom,row,col,'+') && issafe(ans,top,left,bottom,right,ans,row,col+1,'-')){
//                     ans[row][col] = '+';
//                     ans[row][col+1] = '-';
//                     boolean flag1 = solution(arr,top,left,right,bottom,ans,nr,nc);
//                     if(flag1 == true){
//                         return true;
//                     }

//                     ans[row][col] = 'X';
//                     ans[row][col+1] ='X';
//                 }

//                 if(issafe(ans,top,left,right,bottom,row,col,'-') && issafe(ans,top,left,bottom,right,ans,row,col+1,'+')){
//                     ans[row][col] = '-';
//                     ans[row][col+1] = '+'; 
//                     boolean flag2 = solution(arr,top,left,right,bottom,ans,nr,nc);
//                     if(flag2 == true){
//                         return true;
//                     }

//                     ans[row][col] = 'X';
//                     ans[row][col+1]='X';
//                 }
//             }

//             if(row+1<arr.length && arr[row][col] == 'T' && arr[row+1][col] == 'B'){
//                 if(true){
//                     ans[row][col] = '+';
//                     ans[row+1][col] = '-';
//                     boolean flag1 = solution(arr,top,left,right,bottom,ans,nr,nc);
//                     if(flag1 == true){
//                         return true;
//                     }

//                     ans[row][col] = 'X';
//                     ans[row+1][col] ='X';
//                 }

//                 if(true){
//                     ans[row][col] = '-';
//                     ans[row+1][col+1] = '+'; 
//                     boolean flag2 = solution(arr,top,left,right,bottom,ans,nr,nc);
//                     if(flag2 == true){
//                         return true;
//                     }

//                     ans[row][col] = 'X';
//                     ans[row+1][col]='X';
//                 }
//             }
//         }
//         //

//         boolean flag3 = solution(arr, top, left, right, bottom, ans, nr, nc);
//         if(flag3==true){
//             return true;
//         }
//         return false;
//     }

//     public static boolean issafe(char[][] ans, int[] top,int[] left,int[] right,int[] bottom,int row,int col,char ch){
//         if(row-1 >=0 && ans[row-1][col] == ch){
//             return false;
//         }
//         if(col -1 >=0 && ans[row][col-1] == ch){
//             return false;
//         }
//         if(row+1 < ans.length && ans[row+1][col] == ch){
//             return false;
//         }
//         if(row+1 < ans[0].length && ans[row][col+1] == ch){
//             return false;
//         }

//         int rowchcount = rowcount(ans, row, col, ch);
//         int colchcount = colcount(ans, row, col, ch);

//         if(ch =='+'){
//             if(top[col]!=-1 && colchcount>=top[col]){
//                 return false;
//             }
//             if(left[row] !=-1 && rowchcount >=left[row]){
//                 return false;
//             }
//         }
//         else{
//             if(bottom[col]!=-1 && colchcount>=bottom[col]){
//                 return false;
//             }
//             if(right[row] !=-1 && rowchcount >=right[row]){
//                 return false;
//             }
//         }
//         return true;
//     }

//     //Cout character row and column
//     public static int rowcount(char[][] ans,int row,int col,char ch){
//         int count=0;
//         for(int j=0;j<ans[0].length;j++){
//             if(ans[row][j]==ch){
//                 count++;
//             }
//         }
//         return count;
//     }

//     public static int colcount(char[][] ans,int row,int col,char ch){
//         int count=0;
//         for(int i=0;i<ans[0].length;i++){
//             if(ans[i][col]==ch){
//                 count++;
//             }
//         }
//         return count;
//     }

//     // public static int rowcount(char[][] ans, int[] top,int[] left, int right[],)
//     public static void print(char[][] arr) {
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[0].length; j++) {
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int m = scn.nextInt();
//         int n = scn.nextInt();
//         char[][] arr = new char[m][n];
//         for (int i = 0; i < arr.length; i++) {
//             String str = scn.next();
//             arr[i] = str.toCharArray();
//         }
//         int[] top = new int[n];
//         for (int i = 0; i < n; i++) {
//             top[i] = scn.nextInt();
//         }
//         int[] left = new int[m];
//         for (int i = 0; i < m; i++) {
//             left[i] = scn.nextInt();
//         }
//         int[] right = new int[m];
//         for (int i = 0; i < m; i++) {
//             right[i] = scn.nextInt();
//         }
//         int[] bottom = new int[n];
//         for (int i = 0; i < n; i++) {
//             bottom[i] = scn.nextInt();
//         }

//         // write your code here
//         char[][] ans = new char[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 ans[i][j] = 'X';
//             }
//         }
//     }

// }
// // https://www.interviewbit.com/problems/repeat-and-missing-number-array/

// import java.io.*;
// import java.util.*;

// public class Main {

// 	public static void solution(char[][] arr, String[] words, int vidx){
// 		//write your code here
// 		if(vidx ==  words.length){
// 		    print(arr);
// 		    return;
// 		}

//         String word = words[vidx];
//         for(int i=0;i<arr.length;i++){
//             for(int j=0;j<arr.length;j++){
//                 if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
//                     if(checkvertical(arr,word,i,j) == true){
//                         boolean[] vis = new boolean[word.length()];
//                         placevertical(arr,word,i,j,vis);
//                         solution(arr,words,vidx+1);
//                         removevertical(arr,word,i,j,vis);
//                     }
//                     if(checkhorizontal(arr,word,i,j)==true){
//                         boolean[] vis = new boolean[word.length()];
//                         placehorizontal(arr,word,i,j,vis);
//                         solution(arr,words,vidx+1);
//                         removehorizontal(arr,word,i,j,vis);
//                     }
//                 }
//             }
//         }
// 	}

//     public static boolean removehorizontal(char[][] arr,String word,int row,int col,boolean[] vis){
//         int i=col;
//         int idx=0;
//         while(idx<word.length()){
//             if(vis[idx]==true){
//                 arr[row][i]= '-';
//             }
//             i++;
//             idx++;
//         }
//     }

//     public static boolean removevertical(char[][] arr,String word,int row,int col,boolean[] vis){
//         int i=row;
//         int idx=0;
//         while(idx<word.length()){
//             if(vis[idx]==true){
//                 arr[i][col]='-';
//             }
//             i++;
//             idx++;
//         }
//     }

//     public static void placehorizontal(char[][] arr,String word,int row,int col,boolean[] vis){
//         int i = col;
//         int idx=0;
//         while(idx<word.length()){
//             if(arr[row][i] == '-'){
//                 vis[idx] = true;
//             }
//             arr[row][i] = word.charAt(idx);
//             i++;
//             idx++;
//         }
//     }

//     public static void placevertical(char[][] arr, String word,int row,int col, boolean[] vis){
//         int i= row;
//         int idx= 0;
//         while(idx < word.length()){
//             if(arr[i][col]=='-'){
//                 vis[idx] = true;
//             }

//             arr[i][col] = word.charAt(idx);
//             i++;
//             idx++;
//         }
//     }

//     public static boolean checkvertical(char[][] arr,String word,int row,int col){
//         int i=row;
//         while(i-row<word.length()){
//             if(i==arr.length){
//                 return false;
//             }
//             if(arr[i][col] =='-' || arr[i][col] == word.charAt(i-row)){
//                 i++;
//                 continue;
//             }else{
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static boolean checkhorizontal(char[][] arr,String word,int row,int col){
//         int i=col;
//         while(i-col <word.length()){
//             if(i==word.length()){
//                 return false;
//             }
//             if(arr[i][col] =='-' || arr[i][col] == word.charAt(i-col)){
//                 i++;
//                 continue;
//             }else {
//                 return false;
//             }
//         }
//         return true;
//     }

// 	public static void print(char[][] arr){
// 		for(int i = 0 ; i < arr.length; i++){
// 			for(int j = 0 ; j < arr.length; j++){
// 				System.out.print(arr[i][j]);
// 			}
//                   System.out.println();
// 		}

// 	}

// 	public static void main(String[] args) {
// 		Scanner scn = new Scanner(System.in);
// 		char[][] arr = new char[10][10];
// 		for(int i = 0 ; i < arr.length; i++){
// 			String str = scn.next();
// 			arr[i] = str.toCharArray();
// 		}
// 		int n = scn.nextInt();
// 		String[] words = new String[n];
// 		for(int i = 0 ; i  < words.length; i++){
// 			words[i] = scn.next();
// 		}
//         solution(arr,words,0);
// 	}
// }

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         String s1 = scn.nextLine();
//         String s2 = scn.nextLine();
//         String s3 = scn.nextLine();

//         HashMap<Character, Integer> charIntMap = new HashMap<>();
//         String unique = "";
//         for (int i = 0; i < s1.length(); i++) {
//             if (!charIntMap.containsKey(s1.charAt(i))) {
//                 charIntMap.put(s1.charAt(i), -1);
//                 unique += s1.charAt(i);
//             }
//         }

//         for (int i = 0; i < s2.length(); i++) {
//             if (!charIntMap.containsKey(s2.charAt(i))) {
//                 charIntMap.put(s2.charAt(i), -1);
//                 unique += s2.charAt(i);
//             }
//         }

//         for (int i = 0; i < s3.length(); i++) {
//             if (!charIntMap.containsKey(s3.charAt(i))) {
//                 charIntMap.put(s3.charAt(i), -1);
//                 unique += s3.charAt(i);
//             }
//         }

//         boolean[] usedNumbers = new boolean[10];
//         solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
//     }

//     public static long number(String s1, HashMap<Character, Integer> charIntMap) {
//         long num = 0;
//         for (int i = 0; i < s1.length(); i++) {
//             char ch = s1.charAt(i);
//             int val = charIntMap.get(ch);
//             num = num * 10 + val;
//         }
//         return num;
//     }

//     public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
//             String s1, String s2, String s3) {
//         // write your code here
//         if (idx == unique.length()) {
//             long temp1 = number(s1, charIntMap);
//             long temp2 = number(s2, charIntMap);
//             long temp3 = number(s3, charIntMap);

//             if (temp1 + temp2 == temp3) {
//                 for (int i = 0; i < 26; i++) {
//                     char ch = (char) ('a' + i);
//                     if (charIntMap.containsKey(ch) == true) {
//                         System.out.print(ch + "-" + charIntMap.get(ch) + "");
//                     }
//                 }
//                 System.out.println();
//             }
//             return;
//         }
//         char ch=unique.charAt(idx);
//         for(int i=0;i<10;i++){
//             if(usedNumbers[i]==false){
//                 usedNumbers[i]=true;
//                 charIntMap.put(ch,i);
//                 solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);

//                 usedNumbers[i]=false;
//                 charIntMap.put(ch,-1);
//             }
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(char[][] arr, String[] words, int vidx) {
        // write your code here
        if (vidx == words.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (checkvertical(arr, word, i, j) == true) {
                        boolean[] vis = new boolean[word.length()];
                        placevertical(arr, word, i, j, vis);
                        solution(arr, words, vidx + 1);
                        removevertical(arr, word, i, j, vis);
                    }

                    if (checkhorizontal(arr, word, i, j) == true) {
                        boolean[] vis = new boolean[word.length()];
                        placevertical(arr, word, i, j, vis);
                        solution(arr, words, vidx + 1);
                        removehorizontal(arr, word, i, j, vis);
                    }
                }
            }
        }

    }

    public static void removehorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = col;
        int idx = 0;
        while (idx < word.length()) {
            if (vis[idx] == true) {
                arr[row][i] = '-';
            }
            i++;
            idx++;
        }
    }

    public static void removevertical(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = row;
        int idx = 0;
        while (idx < word.length()) {
            if (vis[idx] == true) {
                arr[i][col] = '-';
            }
            i++;
            idx++;
        }
    }

    public static void placevertical(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = row;
        int idx = 0;
        while (idx < word.length()) {
            if (arr[i][col] == '-') {
                vis[idx] = true;
            }
            arr[i][col] = word.charAt(idx);
            i++;
            idx++;
        }
    }

    public static void placehorizontal(char[][] arr, String word, int row, int col, boolean[] vis) {
        int i = col;
        int idx = 0;
        while (idx < word.length()) {
            if (arr[row][i] == '-') {
                vis[idx] = true;
            }
            arr[row][i] = word.charAt(idx);
            i++;
            idx++;
        }
    }

    public static boolean checkvertical(char[][] arr, String word, int row, int col) {
        int i = row;
        while (i - row < word.length()) {
            if (i == arr.length) {
                return false;
            }
            if (arr[i][col] == '-' || arr[i][col] == word.charAt(i - row)) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkhorizontal(char[][] arr, String word, int row, int col) {
        int i = col;
        while (i - col < word.length()) {
            if (i == arr[0].length) {
                return false;
            }

            if (arr[row][i] == '-' || arr[row][i] == word.charAt(i - col)) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}