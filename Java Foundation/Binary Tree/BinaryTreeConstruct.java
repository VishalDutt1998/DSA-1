import java.io.*;
import java.util.*;

public class BinaryTreeConstruct {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;
    private int size = 0;

    BinaryTreeConstruct() {
        Scanner scn = new Scanner(System.in);
        this.root = takeInput(scn, null, false);
    }

    private Node takeInput(Scanner scn, Node parent, boolean isLeftOrRight) {
        if (parent == null) {
            System.out.println("Enter The Data for Root Node");

        } else {
            if (isLeftOrRight) {
                System.out.println("Enter the data for left child of " + parent.data);
            } else {
                System.out.println("Enter the data for right child of " + parent.data);
            }
        }

        int nodeData = scn.nextInt();
        Node node = new Node(nodeData, null, null);
        this.size++;

        boolean choice = false;
        System.out.println("Do You have left child of " + node.data);
        choice = scn.nextBoolean();
        if (choice) {
            node.left = takeInput(scn, node, true);
        }

        choice = false;
        System.out.println("Do You have right child of " + node.data);
        choice = scn.nextBoolean();

        if (choice) {
            node.right = takeInput(scn, node, false);
        }

        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + node.left.data + "=>";
        } else {
            str = str + "END=>";
        }

        str = str + node.data;
        if (node.right != null) {
            str = str + "<=" + node.right.data;
        } else {
            str = str + "<=END";
        }

        System.out.println(str);
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeConstruct tree = new BinaryTreeConstruct();
        tree.display();
    }
}

// 50 true 25 true 38 false false true 48 true 18 false false false true 45 true
// 85 false false true 60 false false