import java.io.*;
import java.util.*;

public class RemoveLeavesInGenericTree {

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

    // Gives concurrent Modification Error
    // As we are iterating in iterator and also deleting from the iterator
    public static void removeLeaves(Node node) {
        // Preorder -> removal of leaves
        for (Node child : node.children) {
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    // Some nodes which are leaves will not be removed but they are leaf nodes
    // When we delete from starting the iterator moves in forward direction and on
    // deleting the elements in the array list are shifted in forward directin and
    // indexes corresponding to the element changes too so the elements get skipped.
    public static void removeLeaves2(Node node) {
        // Preorder -> removal of leaves
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves2(child);
        }
    }

    public static void removeLeaves3(Node node) {
        // Remove Time Complexity is O(n) for every index
        // Preorder -> removal of leaves
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
                i--;
            }
        }

        for (Node child : node.children) {
            removeLeaves3(child);
        }
    }

    public static void removeLeaves4(Node node) {
        // Removal time Complexity is O(1) for some node it will be O(n);
        // Preorder -> removal of leaves
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
                // node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves4(child);
        }
    }

    public static void removeLeaves5(Node node) {
        // Removal time Complexity is O(1) for every Index
        for (Node child : node.children) {
            removeLeaves5(child);
        }

        // Postorder -> Removal of Leaves
        // If we remove in post order then those nodes will also be removed which are
        // not leaves
        // Eventually all the nodes in tree will be removed only root be remained
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }
    }

    // Most Optimised Apprach Using O(n) Space and time complexity is also O(n)
    // It optimizes the removal appraoch
    public static void removeLeaves6(Node node) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            if (child.children.size() != 0) {
                list.add(child);
            }
        }
        // Replace node.children Arraylist with list which has no leaf nodes
        node.children = list;

        for (Node child : node.children) {
            removeLeaves6(child);
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(data);
        removeLeaves2(root);
        System.out.println();
        System.out.println();
        removeLeaves6(root);
    }
}
