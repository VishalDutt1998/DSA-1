import java.io.*;
import java.util.*;

public class LevelorderLinewiseZigZag {
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

    public static void levelOrderLinewiseZigZag(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        queue.addLast(node);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            if (level % 2 == 0) {
                while (size-- > 0) {
                    Node rem = queue.removeFirst();
                    System.out.print(rem.data + " ");
                    for (Node child : rem.children) {
                        queue.addLast(child);
                    }
                }
            } else {
                while (size-- > 0) {
                    Node rem = queue.removeFirst();
                    stack.addFirst(rem.data);
                    for (Node child : rem.children) {
                        queue.addLast(child);
                    }
                }
                while (stack.size() > 0) {
                    System.out.print(stack.removeFirst() + " ");
                }
            }
            level++;
            System.out.println();
        }
    }

    // ZigZag using two stack
    public static void levelOrderLinewiseZigZag2(Node node) {
        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();
        mainS.push(node);
        int level = 1;
        while (mainS.size() > 0) {
            // int size = mainS.size();
            while (mainS.size() > 0) {
                Node rem = mainS.pop();
                System.out.print(rem.data + " ");
                if (level % 2 == 1) {
                    // Odd Level -> Add left to right
                    for (Node child : rem.children) {
                        childS.push(child);
                    }
                } else {
                    // Even Level -> Add Right to left
                    for (int i = rem.children.size() - 1; i >= 0; i--) {
                        Node child = rem.children.get(i);
                        childS.push(child);
                    }
                }
            }
            System.out.println();
            level++;
            Stack<Node> temp = mainS;
            mainS = childS;
            childS = temp;
        }
    }

    // Using Two Stack but using Single Loop
    public static void levelOrderLinewiseZigZag3(Node node) {
        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();
        mainS.push(node);
        int level = 1;
        while (mainS.size() > 0) {
            Node rem = mainS.pop();
            System.out.print(rem.data + " ");
            if (level % 2 == 1) {
                // Odd Level -> Add left to right
                for (Node child : rem.children) {
                    childS.push(child);
                }
            } else {
                // Even Level -> Add Right to left
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    Node child = rem.children.get(i);
                    childS.push(child);
                }
            }
            if (mainS.size() == 0) {
                System.out.println();
                level++;
                Stack<Node> temp = mainS;
                mainS = childS;
                childS = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        levelOrderLinewiseZigZag(root);
        levelOrderLinewiseZigZag2(root);
        levelOrderLinewiseZigZag3(root);
    }
}
