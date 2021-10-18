import java.io.*;
import java.util.*;

public class IsBalancedBInaryTree {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    // Time Complexity O(n^2)
    public static boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        boolean lb = isBalanced(node.left); // Left Balanced
        boolean rb = isBalanced(node.right); // Right Balanced
        int factor = height(node.left) - height(node.right); // Balancing Bactor
        if (lb && rb && factor >= -1 && factor <= 1) {
            return true;
        }
        return false;
    }

    // Using Travel and Change Strategy
    // Here isBalanced2 is calculating height and in Global making changes in isBal
    static boolean isBal = true;

    public static int isBalanced2(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = isBalanced2(node.left);
        int rh = isBalanced2(node.right);

        int factor = Math.abs(lh - rh);
        if (factor > 1) {
            isBal = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    // Using pair Class
    // Time Complexity O(n)
    public static class BPair {
        int ht;
        boolean isBalance;

        public BPair() {
            this.ht = -1;
            this.isBalance = true;
        }
    }

    public static BPair isBalanced3(Node node) {
        if (node == null) {
            return new BPair();
        }

        BPair lres = isBalanced3(node.left); // left result
        BPair rres = isBalanced3(node.right);// right result

        boolean factor = Math.abs(lres.ht - rres.ht) <= 1;
        BPair mres = new BPair();// Main Result
        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.isBalance = factor && lres.isBalance && rres.isBalance;
        return mres;
    }

    public static BPair isBalanced4(Node node) {
        if (node == null) {
            return new BPair();
        }

        BPair lres = isBalanced4(node.left);
        BPair rres = isBalanced4(node.right);

        int factor = Math.abs(lres.ht - rres.ht);
        BPair mres = new BPair();
        mres.ht = Math.max(lres.ht, rres.ht) + 1;

        if (lres.isBalance && rres.isBalance && factor >= -1 && factor <= 1) {
            mres.isBalance = true;
        } else {
            mres.isBalance = false;
        }
        return mres;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Integer[] arr2 = { 10, 20, 40, 60, 70, null, null, null, null, null, 30, null, 60, null, null };
        Integer[] arr3 = { 10, null, null };
        Node root = construct(arr3);
        // System.out.println(isBalanced(root));
        System.out.println(isBalanced3(root).isBalance);
    }
}
