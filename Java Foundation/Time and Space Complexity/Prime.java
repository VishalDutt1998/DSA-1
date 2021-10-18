import java.io.*;
import java.util.*;

public class Prime {
    public static void main(String[] args) throws Exception {
        int[] narr = arrayFiller(50, 1);
        // int[] narr = { 7, 6, 3, 2, 5, 9, 3, 5, 9, 7, 5, 8, 9, 5, 7, 2, 6, 6, 2, 2, 6, 2, 2, 8, 8, 9, 6, 6, 7, 7, 4, 8, 7, 7, 6, 2, 3, 3, 6 };
        // printPrime(narr);
        sieve(narr, 9);
    }

    public static int[] arrayFiller(int size, int digits) {
        int power = (int) Math.pow(10, digits);

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * power);
        }
        return arr;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // O(m√n)
    public static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num == 0 || num == 1)
                continue;
            if (isPrime(num)) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }
    }

    // O(nlog(logn))
    public static void sieve(int[] queries, int hi) {
        boolean[] Prime = new boolean[hi + 1];
        // mark element as true
        Arrays.fill(Prime, true);

        // pre calculate Prime
        for (int i = 2; i * i <= hi; i++) {
            if (Prime[i] == true) {
                // Marking multiple of i
                for (int j = i + i; j <= hi; j += i) {
                    Prime[j] = false;
                }
            }
        }

        // Solve for every Queries
        for (int i = 0; i < queries.length; i++) {
            int num = queries[i];
            if (num == 0 || num == 1) {
                continue;
            }
            if (Prime[num] == true) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }
    }

    // public static void sieve(int[] queries, int hi) {
    //     boolean[] isPrime = new boolean[hi + 1];
    //     // marks element element as true, just for conviniency
    //     Arrays.fill(isPrime, true);

    //     // pre calculate prime
    //     for (int i = 2; i * i <= hi; i++) {
    //         if (isPrime[i] == true) {
    //             for (int j = i + i; j <= hi; j += i) {
    //                 isPrime[j] = false;
    //             }
    //         }
    //     }

    //     // solve for every queries
    //     for (int i = 0; i < queries.length; i++) {
    //         int num = queries[i];
    //         if (num == 0 || num == 1)
    //             continue;

    //         if (isPrime[num] == true) {
    //             System.out.println(num + " is prime");
    //         } else {
    //             System.out.println(num + " is not prime");
    //         }
    //     }
    // }
}
