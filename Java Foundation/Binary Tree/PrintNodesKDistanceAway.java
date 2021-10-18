import java.io.*;
import java.util.*;

public class PrintNodesKDistanceAway {
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

    public static void printKLevelsDown(Node node, int k) {
        if (node == null)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static ArrayList<Node> nodeToRoot(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Node> bres = new ArrayList<>();
            bres.add(node);
            return bres;
        }

        ArrayList<Node> lres = nodeToRoot(node.left, data);
        if (lres.size() > 0) {
            lres.add(node);
            return lres;
        }

        ArrayList<Node> rres = nodeToRoot(node.right, data);
        if (rres.size() > 0) {
            rres.add(node);
            return rres;
        }

        return new ArrayList<>();
    }

    public static void printKDown(Node node, Node blockage, int k) {
        if (node == null || node == blockage || k < 0)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKDown(node.left, blockage, k - 1);
        printKDown(node.right, blockage, k - 1);
    }

    public static void printKNodesFar(Node root, int data, int k) {
        ArrayList<Node> n2rp = nodeToRoot(root, data);
        Node blockage = null;
        for (int i = 0; i < n2rp.size() && k >= 0; i++) {
            Node node = n2rp.get(i);
            printKDown(node, blockage, k);
            k--;
            blockage = node;
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void printKNodesFar2(Node node, int data, int k) {
        ArrayList<Node> path = nodeToRoot(node, data);
        printKLevelsDown(path.get(0), k);

        for (int i = 1; i < path.size(); i++) {
            Node par = path.get(i);
            Node child = path.get(i - 1);

            if (i < k) {
                if (child == par.left) {
                    printKLevelsDown(par.right, k - i - 1);
                } else {
                    printKLevelsDown(par.left, k - i - 1);
                }
            } else if (i == k) {
                System.out.println(par.data);
            } else {
                break;
            }
        }
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        printKNodesFar(root, 37, 2);
    }

    public static void main(String[] args) {
        fun();
    }
}
