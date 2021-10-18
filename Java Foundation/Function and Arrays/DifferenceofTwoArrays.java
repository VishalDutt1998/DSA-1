import java.io.*;
import java.util.*;

public class DifferenceofTwoArrays {

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
        int[] ans = new int[n2];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = n2 - 1;
        int borrow = 0;
        while (k >= 0) {
            int diff = (arr2[j] - borrow);
            if (i >= 0) {
                diff -= arr1[i];
            }
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            ans[k] = diff;
            i--;
            j--;
            k--;
        }
        int l = 0;
        while (ans[l] == 0) {
            l++;
        }
        while (l < n2) {
            System.out.println(ans[l]);
            l++;
        }
    }

}