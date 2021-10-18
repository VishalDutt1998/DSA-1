import java.io.*;
import java.util.*;

public class ConstructBinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node takeTreeInput2() {
        System.out.println("Enter Root Data");
        Scanner scn = new Scanner(System.in);
        int rootData = scn.nextInt();
        if (rootData == -1) {
            return null;
        }
        Node root = new Node(rootData);
        Node leftChild = takeTreeInput2();
        Node rightChild = takeTreeInput2();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static Node takeTreeInput(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter Root Data");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner scn = new Scanner(System.in);
        int rootData = scn.nextInt();
        if (rootData == -1) {
            return null;
        }
        Node root = new Node(rootData);
        Node leftChild = takeTreeInput(false, rootData, true);
        Node rightChild = takeTreeInput(false, rootData, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " : ");
        if (root.left != null) {
            System.out.print("L " + root.left.data + ", ");
        }
        if (root.right != null) {
            System.out.print("R " + root.right.data + ", ");
        }

        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static void display2(Node root) {
        if (root == null)
            return;

        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : root.right.data;
        System.out.println(str);

        display2(root.left);
        display2(root.right);
    }

    public static void nodesWithoutSibling(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right != null) {
            System.out.println(node.left.data);
        } else if (node.left != null && node.right == null) {
            System.out.println(node.left.data);
        }
        nodesWithoutSibling(node.left);
        nodesWithoutSibling(node.right);
    }

    public static void main(String[] args) {
        Node root = takeTreeInput(true, 0, true);
        display(root);
    }
}
