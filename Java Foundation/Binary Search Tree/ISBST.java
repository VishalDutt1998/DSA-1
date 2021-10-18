import java.io.*;
import java.util.*;

public class ISBST {
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

    // Time Complexity O(n^2)
    public static boolean isBST1(Node node) {
        if (node == null) {
            return true;
        }
        int lmax = max(node.left);
        int rmin = min(node.right);
        if (lmax > node.data || rmin < node.data) {
            return false;
        }
        // left check && right check
        boolean res = isBST1(node.left) && isBST1(node.right);
        return res;
    }

    public static class BSTPair {
        int min;
        int max;
        boolean isbst;

        public BSTPair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isbst = true;
        }
    }

    // TIme Complexiyt O(n)
    public static BSTPair isBST2(Node node) {
        if (node == null) {
            return new BSTPair();
        }

        BSTPair lres = isBST2(node.left);
        BSTPair rres = isBST2(node.right);

        boolean status = lres.max < node.data && rres.min > node.data;
        BSTPair mres = new BSTPair();
        mres.min = Math.min(node.data, Math.min(lres.min, rres.min));
        mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
        mres.isbst = lres.isbst && rres.isbst && status;
        return mres;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            return new BSTPair();
        }

        BSTPair lres = isBST(node.left);
        BSTPair rres = isBST(node.right);

        BSTPair mres = new BSTPair();
        boolean lbst = lres.isbst;
        boolean rbst = rres.isbst;

        mres.isbst = lbst && rbst && (node.data >= lres.max && node.data <= rres.min);
        if (mres.isbst == false) {
            return mres;
        }

        mres.min = Math.min(node.data, Math.min(lres.min, rres.min));
        mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
        return mres;
    }

    public static void main(String[] args) {
        int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Node root = construct(data, 0, data.length - 1);
        display(root);
        boolean isbst = isBST1(root);
        System.out.println(isbst);
    }
}
