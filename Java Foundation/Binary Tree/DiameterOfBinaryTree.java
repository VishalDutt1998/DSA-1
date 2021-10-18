import java.io.*;
import java.util.*;

public class DiameterOfBinaryTree {
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

    // Time Complexity is O(n^2)
    public static int diameter(Node node) {
        if (node == null) {
            return 0;
        }

        int lres = diameter(node.left);
        int rres = diameter(node.right);
        int mres = height(node.left) + height(node.right) + 2;

        int dia = Math.max(mres, Math.max(lres, rres));
        return dia;
    }

    // Time Complexity O(n)
    static int diameter = 0;

    public static int heightForDiameter(Node root) {
        if (root == null) {
            return -1; // on the Basis of Edge
        }

        int lh = heightForDiameter(root.left);
        int rh = heightForDiameter(root.right);
        diameter = Math.max(diameter, lh + rh + 2);
        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        // diameter = 0;
        heightForDiameter(root);
        return diameter;
    }

    // Calculate Diameter Using Pair Class
    static class DiaPair {
        int dia;
        int ht;

        public DiaPair() {
            this.dia = 0;
            this.ht = -1;
        }

        public DiaPair(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            return new DiaPair();
        }

        DiaPair lres = diameter2(node.left);
        DiaPair rres = diameter2(node.right);

        DiaPair mres = new DiaPair();

        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.dia = Math.max(lres.ht + rres.ht + 2, Math.max(lres.dia, rres.dia));
        return mres;
    }

    public static int diameterOfBinaryTree2(Node root) {
        DiaPair res = diameter2(root);
        return res.dia;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        int dia = 0;
        dia = diameterOfBinaryTree(root);
        System.out.println(dia);
    }
}
