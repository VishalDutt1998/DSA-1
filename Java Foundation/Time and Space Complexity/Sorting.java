import java.io.*;
import java.util.*;

public class Sorting {
    public static void main(String[] args) throws Exception {
        // int [] arr = {90,70,20,60,50,30,80,40,10,45};
        // print(arr);
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort2(arr);
        // InsertionSort(arr,arr.length);
        // print(arr);
        // int [] arr = arrayFiller(20,1);
        int[] arr = { 3, 7, 6, 2, 8, 9, 4, 5, 7, 6, 5, 3 };
        char[] charr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' };

        // {2,3,3,4,5,5,6,6,7,7,8,9}
        // {'d','a','l'}
        print(arr);
        // System.out.println(charr);
        printCharr(charr);
        // countSort1(arr,9);
        // StableCountSort(arr,0,9);
        StableSort(arr, charr, 2, 9);
        // System.out.println(charr);
        print(arr);
        printCharr(charr);
        testing();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            swap(arr, i, min_idx);
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void InsertionSort(int A[], int n) {
        int i, j, element;
        for (i = 1; i < n; i++) {
            element = A[i];
            // insert ith element in 0 to i − 1 array
            j = i;
            while ((j > 0) && (A[j - 1] > element))
            // compare if A[j − 1] > element
            {
                A[j] = A[j - 1]; // shift elements
                j = j - 1;
            }
            A[j] = element; // place element at jth position
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partitionIndex(int[] arr, int lo, int hi, int pivot) {
        int i = lo;
        int j = lo;

        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi)
            return;

        int pivot = arr[hi];
        int pi = partitionIndex(arr, lo, hi, pivot);
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
    }

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pi = partitionIndex(arr, lo, hi, pivot);

        int ans = 0;
        if (pi == k) {
            // found
            ans = pivot;
        } else if (pi > k) {
            // answer is on left side
            ans = quickSelect(arr, lo, pi - 1, k);
        } else {
            // answer is on right side
            ans = quickSelect(arr, pi + 1, hi, k);
        }
        return ans;
    }

    public static void countSort1(int[] arr, int hi) {
        int[] fmap = new int[hi + 1];
        // fill fmap
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            fmap[val]++;
        }

        // fill in array
        int idx = 0;
        for (int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i;
            for (int j = 0; j < fq; j++) {
                arr[idx] = val;
                idx++;
            }
        }
    }

    public static void countSort2(int[] arr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        // fill frequency map
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            fmap[idx]++;
        }

        // fill array using frequency map
        int idx = 0;
        for (int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i + min;
            for (int j = 0; j < fq; j++) {
                arr[idx] = val;
                idx++;
            }
        }
    }

    // Stable Count Sort
    public static void StableCountSort(int[] arr, int min, int max) {
        // Generate Frequency Array
        int[] fmap = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int indx = arr[i] - min;
            fmap[indx]++;
        }
        // Generate Prefix Sum
        fmap[0]--;
        for (int i = 1; i < fmap.length; i++) {
            fmap[i] += fmap[i - 1];
        }
        // Make a New Array and fill it in reverse Direction
        // Also Decrease psum[i], while place ith element
        int[] narr = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // Value to be placed
            int val = arr[i];
            // Index in frequency map
            int indx = val - min;
            // Position where we have to place in new array
            int pos = fmap[indx];
            // Place element
            narr[pos] = val;
            // Reduce the position to in prefix array
            fmap[indx]--;
        }
        // Fill the actual array using the new array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = narr[i];
        }
    }

    public static void StableSort(int[] arr, char[] charr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        // Create fmap array from
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            fmap[idx]++;
        }

        // Create prefix array of the fmap array
        fmap[0]--;
        for (int i = 1; i < fmap.length; i++) {
            fmap[i] += fmap[i - 1];
        }

        int[] ans = new int[arr.length];
        char[] chans = new char[charr.length];

        // traverl in original array form the last index
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = arr[i] - min;
            int pos = fmap[idx];
            fmap[idx]--;
            ans[pos] = arr[i];
            chans[pos] = charr[i];
        }
        // fill the original array with sorted array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
            charr[i] = chans[i];
        }
    }

    public static void countSort(int[] arr, int min, int max) {
        int[] farr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }

        // prefix sum array
        farr[0]--;
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        // fill the array from frequency array
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            ans[pos] = val;
            farr[val - min]--;

        }
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printCharr(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] arrayFiller(int size, int digits) {
        int power = (int) Math.pow(10, digits);

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * power);
        }
        return arr;
    }

    public static void testing() {
        int[] arr = arrayFiller(10000, 3);
        Arrays.sort(arr);
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        // insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " milliseconds");
    }

}