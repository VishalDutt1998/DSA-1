import java.io.*;
import java.util.*;

public class CeilAndFloorInGenericTree {
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

    static int ceil = Integer.MAX_VALUE; // Qualified Minimum
    static int floor = Integer.MIN_VALUE; // Qualified Maximum

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            // Ceil => Smallest among the largest
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            // Floor => Largest among the smallest
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static void main(String[] args) {

        Integer[] data = { 10, 20, -50, null, -60, null, null, 30, 70, null, -80, 110, null, -120, null, null, 90, null,
                null, 40, -100, null, null, null };

        // Integer[] data = { 10, 20, -50, null, -60, null, null, 30, 70, null, -80,
        // 110, null, -120, null, null, 90, null,
        // null, -40, -100, null, null, null };

        Node root = construct(data);
        Scanner scn = new Scanner(System.in);
        int val = scn.nextInt();
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, val);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
    }
}
