// https://leetcode.com/problems/maximum-product-of-three-numbers/

import java.util.*;


public class MaxProduct3Num{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scn.nextInt();
		}

		int fmax = Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;
		int tmax = Integer.MIN_VALUE;

		int fmin = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;

		for(int i=0;i<n;i++){
			int curr = arr[i];
			if(curr>fmax){
				tmax = smax;
				smax = fmax;
				fmax = curr;
			}else if(smax<curr){
				tmax = smax;
				smax = curr;
			}else if(tmax<curr) {
				tmax = curr;
			}

			if(curr<fmin){
				smin = fmin;
				fmin = curr;
			}else if(curr<smin){
				smin = curr;
			}
		}

		int ans = Math.max(fmax*smax*tmax,fmin*smin*fmax);
		System.out.println(ans);
		scn.close();
	}
}
