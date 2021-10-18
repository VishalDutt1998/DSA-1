import java.io.*;
import java.util.*;

public class BinaryTreeMultiSolver {
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

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls + rs + node.data;
    }

    public static int sum1(Node node) {
        if (node == null)
            return 0; // root == null
        if (node.left != null && node.right != null) {
            int lsum = sum1(node.left);
            int rsum = sum1(node.right);
            return lsum + rsum + node.data;
        } else if (node.left != null) {
            int lsum = sum1(node.left);
            return lsum + node.data;
        } else if (node.right != null) {
            int rsum = sum1(node.right);
            return rsum + node.data;
        } else {
            return node.data;
        }
    }

    public static int sum2(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.left != null) {
            sum += sum2(node.left);
        }

        if (node.right != null) {
            sum += sum2(node.right);
        }
        return sum + node.data;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        return Math.max(node.data, Math.max(lmax, rmax));
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        display(root);
        System.out.println("Size : " + size(root));
        System.out.println("Sum : " + sum(root));
        System.out.println("Max : " + max(root));
        System.out.println("Height : " + height(root));
        System.out.println("Sum 1 : " + sum1(root));
        System.out.println("Sum 2 : " + sum2(root));
    }

    public static void main(String[] args) {
        fun();
    }
}
