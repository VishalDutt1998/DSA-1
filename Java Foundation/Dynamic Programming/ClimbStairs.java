import java.io.*;
import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int ans = climbstairs(n,new int[n]);
        int ans = climbstairsTab(n);
        System.out.println(ans);
    }

    public static int climbstairs(int n , int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        int nm1 = climbstairs(n-1,dp);
        int nm2 = climbstairs(n-2,dp);
        int nm3 = climbstairs(n-3,dp);
        dp[n]=nm1+nm2+nm3;
        return dp[n];
    }

    public static int climbstairsTab(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3] ;
            }
        }
        return dp[n];
    }
}
