import java.io.*;
import java.util.*;

public class LowestCommonAncestor {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        for (Node child : node.children) {
            ArrayList<Integer> rres = nodeToRootPath(child, data);
            if (rres.size() > 0) {
                rres.add(node.data);
                return rres;
            }
        }
        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> n2rp1 = nodeToRootPath(node, d1);
        ArrayList<Integer> n2rp2 = nodeToRootPath(node, d2);

        int i = n2rp1.size() - 1;
        int j = n2rp2.size() - 1;
        int res = -1;
        while (i >= 0 && j >= 0 && n2rp1.get(i) == n2rp2.get(j)) {
            res = n2rp1.get(i);
            i--;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };

        Node root = construct(data);
        int lca = lca(root, 120, 80);
        System.out.println(lca);
    }
}
