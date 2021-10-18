import java.io.*;
import java.util.*;

public class BinaryTree {
    public static class Node {
        int data;
        Node left, right;

        // Constructor
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // As we have to maintain the pair for the each node so we have to make a pair
    // class also
    // state 1 means we have to attach the node on the left of the top element of
    // the stack
    // state 2 means we have to attach the node on the right of the top element of
    // the stack
    // state 3 means we have to pop the elements from the stack
    // If we find the null in the traversal simply increase the state of the node
    // element
    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        // rtp is root pair
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;

                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        // display(root);
        // System.out.println(size(root));
        // int ht = height(root);
        // System.out.println(ht);
        ArrayList<ArrayList<Integer>> res = levelOrderTraversal(root);
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    // Display a Binary Tree
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.data;
        str += " <= " + node.data + " => ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // Level order Traversal of a Binary tree
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                Node rem = queue.removeFirst();
                temp.add(rem.data);
                if (rem.left != null) {
                    queue.addLast(rem.left);
                }
                if (rem.right != null) {
                    queue.addLast(rem.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    // Size of the binary tree
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int temp1 = size(node.left);
        int temp2 = size(node.right);
        return temp1 + temp2 + 1;
    }

    // Sum of the binary tree
    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls + rs + node.data;
    }

    // Height of the Binary Tree
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int ht = Math.max(lh, rh);
        return ++ht;
    }

    // Maximun in Binary Tree
    public static int Maximun(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int lmax = Maximun(node.left);
        int rmax = Maximun(node.right);
        return Math.max(node.data, Math.max(lmax, rmax));
    }

    // Find node in binary tree
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        boolean temp1 = find(node.left, data);
        if (temp1 == true) {
            return true;
        }
        boolean temp2 = find(node.right, data);
        if (temp2 == true) {
            return true;
        }
        return false;
    }
}
