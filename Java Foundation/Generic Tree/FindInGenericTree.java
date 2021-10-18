import java.io.*;
import java.util.*;

public class FindInGenericTree {
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

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        boolean found = false;
        for (Node child : node.children) {
            found = find(child, data);
            if (found == true)
                return true;
            // found = found || find(child, data);
        }
        return found;
    }

    public static boolean isAvl = false;

    public static void find2(Node node, int data) {
        if (node.data == data) {
            isAvl = true;
            return;
        }
        for (Node child : node.children) {
            find(child, data);
            if (isAvl == true)
                return;
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        System.out.println(find(root, 110));
        find2(root, 110);
        // System.out.println(isAvl);
    }
}
