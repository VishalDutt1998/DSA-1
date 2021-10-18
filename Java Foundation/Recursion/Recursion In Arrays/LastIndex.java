import java.io.*;
import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        int li = lastIndex(arr, 0, data);
        System.out.println(li);
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int ans = lastIndex(arr, idx + 1, x);
        if (ans != -1) {
            return ans;
        }

        if (arr[idx] == x) {
            return idx;
        }
        return -1;
    }

    public static int lastIndex2(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }
        int li = lastIndex2(arr, idx + 1, x);
        if (li == -1 && arr[idx] == x) {
            li = idx;
        }
        return li;
    }
}