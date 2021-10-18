import java.io.*;
import java.util.*;

public class PathToLeafFromRootInRange {
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

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static void pathToLeafFromRoot2(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            pathToLeafFromRoot2(node.left, path + node.data + " ", sum + node.data, lo, hi);
            pathToLeafFromRoot2(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRoot2(node.left, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRoot2(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else {
            // Leaf Node
            sum += node.data;
            path += node.data;
            if (lo <= sum && sum <= hi) {
                // print path
                System.out.println(path);
            }
        }
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null,
                null, 87, null, null };
        Node root = construct(data);
        // display(root);
        pathToLeafFromRoot2(root, "", 0, 150, 250);
    }

    public static void main(String[] args) {
        fun();
    }
}
