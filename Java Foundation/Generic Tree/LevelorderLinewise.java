import java.io.*;
import java.util.*;

public class LevelorderLinewise {
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

    // levelorder using two queue
    public static void levelOrderLineWise(Node node) {
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        mainQ.add(node);
        int level = 0;
        System.out.print("level - " + level + " : ");
        while (mainQ.size() > 0) {
            Node rem = mainQ.remove();
            System.out.print(rem.data + " ");
            for (Node child : rem.children) {
                childQ.add(child);
            }
            if (mainQ.size() == 0) {
                System.out.println();
                level++;
                // Swap mainQ and childQ
                Queue<Node> temp = mainQ;
                mainQ = childQ;
                childQ = temp;
                if (mainQ.size() != 0)
                    System.out.print("level - " + level + " : ");
            }
        }
    }

    // levelorder using delimiter and single queue
    public static void levelOrderLineWise2(Node node) {
        // Adapt Queue using LinkedList as ArrayDeque does not allow null values to hold
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (queue.size() > 0) {
            Node rem = queue.remove();
            if (rem == null) {
                System.out.println();
                if (queue.size() > 0) {
                    queue.add(null);
                }
            } else {
                System.out.print(rem.data + " ");
                for (Node child : rem.children) {
                    queue.add(child);
                }
            }
        }
    }

    // Levelorder using two single loop and two loops
    public static void levelOrderLineWise3(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                // Remove the node from the queue
                Node rem = queue.removeFirst();
                // Print the data
                System.out.print(rem.data + " ");
                // Add the children of the removed node
                for (Node child : rem.children) {
                    queue.addLast(child);
                }
            }
            // change the Level
            System.out.println();
        }
    }

    // LevelOrder traversal using Pair Class
    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderLineWise4(Node node) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(node, 1));
        int level = 1;
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.level > level) {
                level = rem.level;
                System.out.println();
            }
            System.out.print(rem.node.data + " ");
            for (Node child : rem.node.children) {
                Pair pair = new Pair(child, rem.level + 1);
                queue.add(pair);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        levelOrderLineWise(root);
    }
}
