import java.io.*;
import java.util.*;

public class IterativePreorderAndPostorder {
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
    public static class PairState {
        Node node;
        int state;

        public PairState(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<PairState> st = new Stack<>();
        st.push(new PairState(node, 0));

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while (!st.empty()) {
            PairState p = st.peek();
            if (p.state == 0) {
                pre.add(p.node.data);
                p.state++;
            } else if (p.state <= p.node.children.size()) {
                Node child = p.node.children.get(p.state - 1);
                p.state++;
                st.push(new PairState(child, 0));
            } else {
                post.add(p.node.data);
                st.pop();
            }
        }

        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
            null, 40, 100, null, null, null };
        Node root = construct(data);
        IterativePreandPostOrder(root);
    }
}
