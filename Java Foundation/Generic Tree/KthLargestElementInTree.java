import java.io.*;
import java.util.*;

public class KthLargestElementInTree {
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

    static int floor;

    public static void floor(Node node, int data) {
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            floor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int data = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            // Reset the Floor value every time before call other wise the floor will never
            // be updated as the floor is the maximun among the all which is smaller than
            // value
            floor = Integer.MIN_VALUE;
            floor(node, data);
            data = floor;
        }
        return data;
    }

    public static void main(String[] args) {
        // Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110,
        // null, 120, null, null, 90, null,
        // null, 40, 100, null, null, null };

        Integer[] data = { 10, 20, -50, null, 60, null, null, 30, 70, null, -80, 110, null, -120, null, null, 90, null,
                null, 40, -100, null, null, null };
        Node root = construct(data);
        int kthLargest = kthLargest(root, 8);
        System.out.println(kthLargest);
    }
}
