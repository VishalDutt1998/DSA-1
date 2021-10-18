import java.io.*;
import java.util.*;

public class SumofTwoArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }
        int m = Math.max(n1, n2);
        int[] ans = new int[m];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = ans.length - 1;
        int carry = 0;
        while (k >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += arr1[i];
            }
            if (j >= 0) {
                sum += arr2[j];
            }
            int q = sum / 10;
            int r = sum % 10;
            ans[k] = r;
            carry = q;
            i--;
            j--;
            k--;
        }
        if (carry != 0) {
            System.out.println(carry);
        }
        for (int val : ans) {
            System.out.println(val);
        }
    }

}