import java.io.*;
import java.util.*;

public class LinearizeGenericTree {

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

    // Linearize the generic tree
    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node slast = node.children.get(node.children.size() - 1);

            Node slasttail = getTail(slast);
            slasttail.children.add(last);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() > 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearize2(Node node) {
        for (Node child : node.children) {
            linearize2(child);
        }

        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node last = node.children.get(i + 1);
            Node slast = node.children.get(i);

            node.children.remove(i + 1);
            Node tail = getTail2(slast);
            tail.children.add(last);
        }
    }

    private static Node getTail2(Node node) {
        Node tail = node;
        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }
        return tail;
    }

    public static Node linearizeEfficient(Node node) {
        if (node.children.size() == 0)
            return node;
        Node lastNode = node.children.get(node.children.size() - 1);
        Node tail = linearizeEfficient(lastNode);
        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node rem = node.children.remove(i + 1);
            Node stail = linearizeEfficient(node.children.get(i));
            stail.children.add(rem);
        }
        return tail;
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        linearize(root);
        linearize2(root);
        linearizeEfficient(root);
        display(root);
    }
}
