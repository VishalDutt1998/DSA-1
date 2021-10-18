import java.io.*;
import java.util.*;

public class MultiSolver {
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

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        Node nn = new Node(arr[mid]);
        nn.left = construct(arr, lo, mid - 1);
        nn.right = construct(arr, mid + 1, hi);
        return nn;
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }
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
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize + rsize + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        } else if (node.right == null) {
            return node.data;
        } else {
            return max(node.right);
        }
    }

    public static int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.left == null) {
            return node.data;
        } else {
            return min(node.left);
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Node root = construct(data, 0, data.length - 1);
        // display(root);
        System.out.println("Size : " + size(root));
        System.out.println("Sum : " + sum(root));
        System.out.println("Max : " + max(root));
        System.out.println("Min : " + min(root));
        System.out.println("Height : " + height(root));
    }
}
