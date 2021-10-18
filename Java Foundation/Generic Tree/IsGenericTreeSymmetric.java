import java.io.*;
import java.util.*;

public class IsGenericTreeSymmetric {
    public static class Node {
        int data;
        ArrayList<Node> children;

        public Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (data != null) {
                Node nn = new Node(data);
                if (st.size() == 0) {
                    root = nn;
                    st.push(nn);
                } else {
                    st.peek().children.add(nn);
                    st.push(nn);
                }
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        String str = "[" + root.data + "] -> ";
        for (Node child : root.children) {
            str += child.data + ", ";
        }
        System.out.println(str + " .");

        for (int i = 0; i < root.children.size(); i++) {
            Node child = root.children.get(i);
            display(child);
        }
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        int j = n2.children.size() - 1;
        // for (int i = 0; i < n1.children.size(); i++) {
        for (int i = 0; i < n1.children.size(); i++, j--) {
            // int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            boolean res = areMirror(c1, c2);
            if (res == false) {
                return false;
            }
        }
        return true;
    }

    // If a tree is mirror to itself then the tree is symmetric
    // Travel and change strategy
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }

    public static boolean IsSymmetric2(Node node) {
        boolean res = true;
        int j = node.children.size() - 1;
        for (int i = 0; i < node.children.size() / 2; i++) {
            Node child1 = node.children.get(i);
            Node child2 = node.children.get(j);
            j--;
            if (child1.children.size() != child2.children.size()) {
                return false;
            }
            boolean res1 = IsSymmetric2(child1);
            boolean res2 = IsSymmetric2(child2);
            res = res1 && res2;
        }
        return res;
    }

    public static void main(String[] args) {
        // Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110,
        // null, 120, null, null, 90, null,
        // null, 40, 100, null, null, null };

        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, null, 90, null, null, 40, 100, null, 110,
                null, null, null };
        Node root = construct(data);
        boolean res = IsSymmetric(root);
        System.out.println(res);
    }
}
