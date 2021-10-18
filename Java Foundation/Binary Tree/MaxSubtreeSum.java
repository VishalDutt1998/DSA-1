import java.io.*;
import java.util.*;

public class MaxSubtreeSum {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        int idx = 0;
        while (st.size() > 0) {
            Pair p = st.peek();

            if (p.state == 0) {
                // left child processing
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // right child processing
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else {
                // pop out the node pair from the stack
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        if (root == null)
            return;

        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }

    // Using Global Variable
    static int maxSum = Integer.MIN_VALUE;
    static int nodeData = 0;

    public static int maxSubTreeSum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = maxSubTreeSum(node.left);
        int rs = maxSubTreeSum(node.right);
        int sum = ls + rs + node.data;
        // maxSum = Math.max(maxSum,sum);
        if (sum > maxSum) {
            maxSum = sum;
            nodeData = node.data;
        }
        return sum;
    }

    // Recursion Will return maxSubtree Sum from the node
    // Time Complexity O(n^2)
    public static int maxSubTreeSum2(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lMaxSubtreeSum = maxSubTreeSum2(node.left);
        int rMaxSubtreeSum = maxSubTreeSum2(node.right);
        // int sum = node.data + sum(node.left) + sum(node.right);
        int sum = sum(node);
        return Math.max(sum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));
    }

    public static class MPair {
        int sum;
        int maxSubtreeSum;

        public MPair() {
            this.sum = 0;
            this.maxSubtreeSum = Integer.MIN_VALUE;
        }
    }

    public static MPair maxSubTreeSum3(Node node) {
        if (node == null) {
            return new MPair();
        }

        MPair lp = maxSubTreeSum3(node.left); // left Pair
        MPair rp = maxSubTreeSum3(node.right);// Right Pair
        MPair sp = new MPair();// Self Pair

        sp.sum = lp.sum + rp.sum + node.data;
        sp.maxSubtreeSum = Math.max(sp.sum, Math.max(lp.maxSubtreeSum, rp.maxSubtreeSum));
        return sp;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Integer[] arr2 = { 10, 20, 40, 60, 70, null, null, null, null, null, 30, null, 60, null, null };
        Integer[] arr3 = { 10, null, null };
        Integer[] arr4 = { 10, 20, 40, 2, null, null, 3, null, null, -60, null, null, -30, 50, 60, 80, null, null, null,
                70, null, null, -100, null, null };
        Node root = construct(arr4);
        // display(root);
        maxSubTreeSum(root);
        System.out.println("Root : " + nodeData + " Sum : " + maxSum);
        System.out.println(maxSubTreeSum2(root));
        System.out.println(maxSubTreeSum3(root).maxSubtreeSum);
    }
}
