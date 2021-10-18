import java.io.*;
import java.util.*;

public class BinaryTreeNodetorootpath {
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

    public static boolean find(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            return true;
        }

        // Left result
        boolean lres = find(node.left, data);
        if (lres == true)
            return true;

        // Right result
        boolean rres = find(node.right, data);
        if (rres == true)
            return true;

        return false;
    }

    public static boolean find2(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        boolean res = false;
        res = find2(node.left, data);
        // if left gives true then it will not call to right call
        res = res || find2(node.right, data);
        return res;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            // ArrayList<Integer> bres = new ArrayList<>();
            // return bres;
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        ArrayList<Integer> lres = nodeToRootPath(node.left, data);
        if (lres.size() > 0) {
            lres.add(node.data);
            return lres;
        }

        ArrayList<Integer> rres = nodeToRootPath(node.right, data);
        if (rres.size() > 0) {
            rres.add(node.data);
            return rres;
        }

        return new ArrayList<>();
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    public static boolean find3(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            ans.add(node.data);
            return true;
        }

        boolean lres = find3(node.left, data);
        if (lres == true) {
            ans.add(node.data);
            return true;
        }

        boolean rres = find3(node.right, data);
        if (rres == true) {
            ans.add(node.data);
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath2(Node node, int data) {
        return ans;
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        System.out.println(find(root, 30));
        System.out.println(find2(root, 30));
        ArrayList<Integer> ans = nodeToRootPath(root, 30);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        fun();
    }
}
