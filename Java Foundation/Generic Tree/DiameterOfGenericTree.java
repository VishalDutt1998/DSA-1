import java.io.*;
import java.util.*;

public class DiameterOfGenericTree {
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

    public static int height(Node node) {
        int ht = -1;
        for (Node child : node.children) {
            ht = Math.max(ht, height(child));
        }
        ht++;
        return ht;
    }

    public static int diameter(Node node) {
        int mh = -1; // max height
        int smh = -1; // Second max height

        for (Node child : node.children) {
            int ht = height(child);
            if (ht >= mh) {
                smh = mh;
                mh = ht;
            } else if (ht > smh) {
                smh = ht;
            }
        }

        int dfc = 0; // diameter from child
        for (Node child : node.children) {
            dfc = Math.max(diameter(child), dfc);
        }
        return Math.max(dfc, mh + smh + 2);
    }

    public static int diameter = 0;

    public static int heigthForDiameter(Node node) {
        int maxHt = -1;
        int smaxHt = -1;

        for (Node child : node.children) {
            int ht = heigthForDiameter(child);
            if (ht >= maxHt) {
                smaxHt = maxHt;
                maxHt = ht;
            } else if (ht > smaxHt) {
                smaxHt = ht;
            }
        }
        diameter = Math.max(diameter, maxHt + smaxHt + 2);

        return maxHt + 1;
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        // int diameter = diameter(root);
        int diameter = heigthForDiameter(root);
        System.out.println(diameter);
    }
}
