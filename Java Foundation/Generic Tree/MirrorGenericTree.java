import java.io.*;
import java.util.*;

public class MirrorGenericTree {

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

    // Mirror A Generic Tree
    public static void mirror(Node node) {
        // Reverse Children ArrayList in Preorder Area
        Collections.reverse(node.children);
        for (Node child : node.children) {
            mirror(child);
        }
    }

    public static void mirror2(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        // Reverse Children ArrayList in Postorder Area
        Collections.reverse(node.children);
    }

    public static void mirror3(Node node) {
        int si = 0;
        int ei = node.children.size() - 1;
        while (si < ei) {
            Node temp = node.children.get(si);
            node.children.set(si, node.children.get(ei));
            node.children.set(ei, temp);
            si++;
            ei--;
        }

        for (Node child : node.children) {
            mirror(child);
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        display(root);
        mirror(root);
        System.out.println();
        display(root);
    }
}
