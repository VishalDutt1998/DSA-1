import java.io.*;
import java.util.*;

public class RemoveLeavesInBinaryTree {
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

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null)
            return;

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        }

        if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static void printSingleChildNodes2(Node node, Node parent) {
        if (node.left == null && node.right == null) {
            return;
        } else if (node.left != null && node.right != null) {
            printSingleChildNodes2(node.left, parent);
            printSingleChildNodes2(node.right, parent);
        } else if (node.left != null) {
            System.out.println(node.left.data);
            printSingleChildNodes2(node.left, parent);
        } else {
            System.out.println(node.right.data);
            printSingleChildNodes2(node.right, parent);
        }
    }

    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public static Node removeLeaves2(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null && node.right != null) {
            node.left = removeLeaves2(node.left);
            node.right = removeLeaves2(node.right);
        } else if (node.left != null) {
            node.left = removeLeaves2(node.left);
        } else if (node.right != null) {
            node.right = removeLeaves2(node.right);
        } else {
            // Leaf Node
            node = null;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        printSingleChildNodes(root, null);
    }
}
