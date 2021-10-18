import java.io.*;
import java.util.*;

public class SubsetofArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int subsets = (int) Math.pow(2, n);
        for (int i = 0; i < subsets; i++) {
            int binary = deciamToBinary(i);
            int div = (int) Math.pow(10, n - 1);
            for (int j = 0; j < n; j++) {
                int q = binary / div;
                int r = binary % div;
                if (q == 0) {
                    System.out.print("-\t");
                } else {
                    System.out.print(arr[j] + "\t");
                }
                binary = r;
                div = div / 10;
            }
            System.out.println();
        }

        // Another Approach
        // int subsets = (int) Math.pow(2, n);
        // for (int i = 0; i < subsets; i++) {
        //     String ans = "";
        //     int temp = i;
        //     for (int j = arr.length - 1; j >= 0; j--) {
        //         int r = temp % 2;
        //         temp = temp / 2;
        //         if (r == 0) {
        //             ans = "-\t" + ans;
        //         } else {
        //             ans = arr[j] + "\t" + ans;
        //         }
        //     }
        //     System.out.println(ans);
        // }
    }

    public static int deciamToBinary(int n) {
        int pow = 1;
        int ans = 0;
        while (n != 0) {
            int rem = n % 2;
            n = n / 2;
            ans += rem * pow;
            pow = pow * 10;
        }
        return ans;
    }
}