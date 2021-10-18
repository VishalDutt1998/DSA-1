import java.io.*;
import java.util.*;

public class IterativePrePostAndInorderTraversal {
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

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        st.push(new Pair(node, 0));

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                pre.add(p.node.data);
                p.state++;
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
            } else if (p.state == 1) {
                in.add(p.node.data);
                p.state++;
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
            } else { // state == 2
                post.add(p.node.data);
                st.pop();
            }
        }

        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (int val : in) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        iterativePrePostInTraversal(root);
    }

    public static void main(String[] args) {
        fun();
    }
}
