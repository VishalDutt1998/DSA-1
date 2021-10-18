import java.io.*;
import java.util.*;

public class PredecessorAndSuccessorOfAnElement {

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

    static Node predecessor;
    static Node successor;
    static int state = 0;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
            return;
        }
        // for (Node child : node.children) {
        // predecessorAndSuccessor(child, data);
        // }
        for (Node child : node.children) {
            if (state < 2)
                predecessorAndSuccessor(child, data);
            else
                return;
        }
    }

    public static void predecessorAndSuccessorOptimised(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
            return;
        }
        if (state < 2) {
            for (Node child : node.children) {
                predecessorAndSuccessorOptimised(child, data);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        predecessorAndSuccessor(root, 70);
        System.out.println(predecessor.data + " " + successor.data);
    }
}
