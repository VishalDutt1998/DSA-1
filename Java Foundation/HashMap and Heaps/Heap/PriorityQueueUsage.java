package Heap;

import java.io.*;
import java.util.*;

public class PriorityQueueUsage {

    public static void demo() {
        // Default PriorityQueue => min
        // By Default PriorityQueue of
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(9);
        System.out.println("peek : " + pq.peek());
        pq.add(7);
        pq.add(11);
        System.out.println("peek : " + pq.peek());
        // Time complexity of loop is O(nlogn)
        while (pq.size() > 0) {
            System.out.println(pq);
            int rem = pq.remove();
            System.out.println(rem);
        }
        System.out.println(pq);

        System.out.println();

        // Max PriorityQueue
        PriorityQueue<Integer> pqm = new PriorityQueue<>(Collections.reverseOrder());
        pqm.add(10);
        pqm.add(9);
        System.out.println("peek : " + pqm.peek());
        pqm.add(7);
        pqm.add(11);
        pqm.add(20);
        System.out.println("peek : " + pqm.peek());
        while (pqm.size() > 0) {
            System.out.println(pqm);
            int rem = pqm.remove();
            System.out.println(rem);
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
