import java.io.*;
import java.util.*;

public class Fibonacci {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int ans = fib(n,new int[n+1]);
        int ans = fibdp(n);
        System.out.println(ans);
    }
    public static int fib(int n , int[] dp){
        if(n==0 || n==1){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        int fibnm1 = fib(n-1,dp);
        int fibnm2 = fib(n-2,dp);
        dp[n]=fibnm1+fibnm2;
        return dp[n];
    }

    public static int fibdp(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
