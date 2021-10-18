import java.util.*;

public class GenericTree {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        // int[] arr = {10,12,-1,14,18,-1,20,22,-1,24,-1,26,-1,-1,-1,16,28,-1,-1,-1};
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node n = new Node();
                n.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(n);
                    st.push(n);
                } else {
                    st.push(n);
                    root = n;
                }
            }
        }
        // display(root);
        // System.out.println(size(root));
        // System.out.println(max(root));
        // System.out.println(height(root));
        // traversals(root);
        // levelOrder(root);
        // levelOrderLinewise(root);
        // levelOrderLinewiseZZ(root);
        // mirror(root);
        // System.out.println("Display After Mirror Function is Called");
        // removeLeaves(root);
        // // linearize(root);
        // linearizeEfficient(root);
        // System.out.println("After Fucntion Called:");
        // display(root);
        boolean find = find(root, 900);
        System.out.println(find);

    }

    // Display tree level order traversal
    public static void display(Node node) {
        String str = node.data + " -> ";
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            str += child.data + ",";
        }

        System.out.println(str + " . ");

        for (Node child : node.children) {
            display(child);
        }
    }

    // Find the size of the tree
    public static int size(Node node) {
        // The base in the generic tree is redundant
        if (node.children.size() == 0) {
            return 1;
        }
        int count = 0;
        for (Node child : node.children) {
            int temp = size(child);
            count += temp;
        }
        count++;
        return count;
    }

    // Maximun of a generic Tree
    public static int max(Node node) {
        if (node.children.size() == 0) {
            return node.data;
        }
        int maximun = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int temp = max(child);
            maximun = Math.max(maximun, temp);
        }
        maximun = Math.max(maximun, node.data);
        return maximun;
    }

    // Height of a Generic Tree
    public static int height(Node node) {
        if (node.children.size() == 0) {
            return 0;
        }
        int ht = -1;
        for (Node child : node.children) {
            int temp = height(child);
            ht = Math.max(ht, temp);
        }
        ht++;
        return ht;
    }

    // Generic Tree traversals pre and post order
    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }

    // Level order traversal of a generic tree
    // public static void levelOrder(Node node) {
    // System.out.print(node.data+ " ");
    // for(Node child:node.children){
    // levelOrder(child);
    // }
    // }

    // Level order traversal of a generic tree using queue
    public static void levelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size() > 0) {
            Node rem = queue.removeFirst();
            System.out.print(rem.data + " ");
            for (Node child : rem.children) {
                queue.addLast(child);
            }
        }
        System.out.println(".");
    }

    // Linewise Level order traversal of a generic tree
    // The first loop changes the level of the tree and the inner loop is doing the
    // printing of the data
    public static void levelOrderLinewise(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.removeLast();
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    queue.addFirst(child);
                }
                size--;
            }
            System.out.println(" ");
        }
    }

    // Zig zag Level order traversal of the geric tree
    public static void levelOrderLinewiseZZ(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        queue.addLast(node);
        int level = 0;
        // If the level of the tree is even
        while (queue.size() > 0) {
            int size = queue.size();
            if (level % 2 == 0) {
                while (size-- > 0) {
                    Node temp = queue.removeFirst();
                    System.out.print(temp.data + " ");
                    for (Node child : temp.children) {
                        queue.addLast(child);
                    }
                }
            }
            // If the level of the tree is odd
            else {
                while (size-- > 0) {
                    Node temp = queue.removeFirst();
                    stack.addFirst(temp.data);
                    for (Node child : temp.children) {
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

    // Mirror a Generic Tree
    // public static void mirror(Node node){
    // for(Node child:node.children){
    // mirror(child);
    // }
    // Collections.reverse(node.children);
    // }

    // public static void mirror(Node node){
    // for(Node child:node.children){
    // mirror(child);
    // }
    // ArrayList<Node> temp = node.children;
    // for(int i=0;i<temp.size()/2;i++){
    // Node t = temp.get(i);
    // temp.set(i, temp.get(temp.size() - i - 1));
    // temp.set(temp.size() - i - 1, t);
    // }
    // }
    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        int si = 0;
        int ei = node.children.size() - 1;
        while (si < ei) {
            Node temp = node.children.get(si);
            node.children.set(si, node.children.get(ei));
            node.children.set(ei, temp);
            si++;
            ei--;
        }
    }

    public static void removeLeaves(Node node) {
        // We delete roots in arraylist from the end because removal of elements from
        // end takes less complexity
        // Removal has to be done in the preorder traversal
        // Because if we remove the node in the post order we will be resulting in the
        // deletion of all the nodes in the tree
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static void linearize(Node node) {
        // Time complexity of the code is o(n^2)
        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            // Get and remove the last node in the children arraylist
            Node lastch = node.children.remove(node.children.size() - 1);
            // Get the second last child in the arraylist
            Node seclch = node.children.get(node.children.size() - 1);
            // Get the tail of the second last child
            Node seclchtail = gettail(seclch);
            // Add the last children node removed from the array list in the tail of the
            // second last child
            seclchtail.children.add(lastch);
        }
    }

    // Function to get the tail of second last child in the arraylist
    public static Node gettail(Node node) {
        // node.children.size==0 is also a valid condition in while loop
        while (node.children.size() > 0) {
            node = node.children.get(0);
        }
        return node;
    }

    // Linearize a Generic Tree using efficeint approach
    public static Node linearizeEfficient(Node node) {
        // If the leaf is the only node and it is linearized
        if (node.children.size() == 0) {
            return node;
        }
        Node lastchtail = linearizeEfficient(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node lastch = node.children.remove(node.children.size() - 1);
            Node seclch = node.children.get(node.children.size() - 1);
            // Get the Node of the second last child by calling linerarize fucntion
            Node seclchtail = linearizeEfficient(seclch);
            seclchtail.children.add(lastch);
        }
        return lastchtail;
    }

    // Find the element is the Generic Tree
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean temp = find(child, data);
            if (temp == true) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        for (Node child : node.children) {
            ArrayList<Integer> rres = nodeToRootPath(child, data);
            if (rres.size() > 0) {
                rres.add(node.data);
                return rres;
            }
        }
        return new ArrayList<>();
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        return i + j + 2;
    }

    // while calling in the recursion --k is allowed but we have to do it in one
    // call only for eg
    // func(--k);
    // fucn(k);
}
