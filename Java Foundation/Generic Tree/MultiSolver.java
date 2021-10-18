import java.io.*;
import java.util.*;

public class MultiSolver {

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

    // Mulitsolver using global Variable
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int ht = 0;
    static int size = 0;

    public static void multiSolver1(Node node, int depth) {
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        ht = Math.max(ht, depth);
        size++;

        for (Node child : node.children) {
            multiSolver1(child, depth + 1);
        }
    }

    public static void multiSolver(Node node, int depth) {
        // min = Integer.MAX_VALUE;
        // max = Integer.MIN_VALUE;
        // ht = 0;
        // size = 0;
        // multiSolver1(node, 0);
        // System.out.println("Min : " + min);
        // System.out.println("Max : " + max);
        // System.out.println("Height : " + ht);
        // System.out.println("Size : " + size);

        // MultiSolver2 Using Pair Class
        multiSolver res = multiSolver2(node);
        System.out.println("Min : " + res.min);
        System.out.println("Max : " + res.max);
        System.out.println("Height : " + res.ht);
        System.out.println("Size : " + res.sz);

    }

    // Mulit Solver using multisolver Pair Class return type
    public static class multiSolver {
        int min;
        int max;
        int ht;
        int sz;

        public multiSolver(int min, int max, int ht, int sz) {
            this.max = max;
            this.min = min;
            this.ht = ht;
            this.sz = sz;
        }

        public multiSolver() {
            this.max = Integer.MAX_VALUE;
            this.min = Integer.MIN_VALUE;
            this.ht = -1;
            this.sz = 0;
        }
    }

    public static multiSolver multiSolver2(Node node) {
        multiSolver mres = new multiSolver(node.data, node.data, -1, 1);

        for (Node child : node.children) {
            multiSolver rres = multiSolver2(child);
            mres.min = Math.min(mres.min, rres.min);
            mres.max = Math.max(mres.max, rres.max);
            mres.ht = Math.max(mres.ht, rres.ht);
            mres.sz += rres.sz;
        }
        mres.ht += 1;
        return mres;
    }

    public static void main(String[] args) {

        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        multiSolver(root, 0);

    }
}
