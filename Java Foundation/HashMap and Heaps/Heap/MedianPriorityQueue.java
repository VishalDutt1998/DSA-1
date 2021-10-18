package Heap;

import java.io.*;
import java.util.*;

public class MedianPriorityQueue {

    public static class MedianPQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            // Balancing
            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if (left.size() + right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (right.size() > left.size()) {
                int data = right.remove();
                return data;
            } else {
                int data = left.remove();
                return data;
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (right.size() > left.size()) {
                return right.peek();
            } else {
                return left.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }
    }

    public static class MedianPQ {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPQ() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            // Both PriorityQueue size are equal then the element will be added
            // in the right PriorityQueue
            if (left.size() == right.size()) {
                right.add(val);
                left.add(right.remove());
            } else {
                left.add(val);
                right.add(left.remove());
            }
        }

        public int remove() {
            if (left.size() + right.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (left.size() == right.size()) {
                int data = left.remove();
                // We have to add extra element in 
                left.add(right.remove());
                return data;
            } else {
                return left.remove();
            }
        }

        public int peek() {
            if (left.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return left.peek();
        }

        public int size() {
            return left.size() + right.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // MedianPQueue qu = new MedianPQueue();
        MedianPQ qu = new MedianPQ();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
