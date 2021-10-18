import java.io.*;
import java.util.*;

public class AddDeleteNode {
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

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        Node nn = new Node(arr[mid]);
        nn.left = construct(arr, lo, mid - 1);
        nn.right = construct(arr, mid + 1, hi);
        return nn;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            Node nn = new Node(data, null, null);
            return nn;
        }
        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        }
        return node;
    }

    // Remove Node in BST
    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data < data) {
            node.right = remove(node.right, data);
        } else if (node.data > data) {
            node.left = remove(node.left, data);
        } else {
            node = delete(node);
        }
        return node;
    }

    public static Node delete(Node node) {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            int lmax = max(node.left);
            node.data = lmax;
            node.left = remove(node.left, lmax);
            return node;
        }
    }

    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        }
        return node.data;
    }

    // Remove Node in BST Approach 2
    public Node deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data < data) {
            node.right = deleteNode(node.right, data);
        } else if (node.data > data) {
            node.left = deleteNode(node.left, data);
        } else {
            node = delete2(node);
        }
        return node;
    }

    public Node delete2(Node node) {
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            Node leftp1 = node.left;
            while (leftp1.right != null) {
                leftp1 = leftp1.right;
            }
            leftp1.right = node.right;
            return node.left;
        }
    }

    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null) {
            return;
        }
        rwsol(node.right);
        int data = node.data;
        node.data = sum;
        sum += data;
        rwsol(node.left);
    }

    public static void main(String[] args) {
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(data);
        display(root);
        root = remove(root, 50);
        display(root);
        rwsol(root);
    }

}

// 25 <- 37 -> 75
// 12 <- 25 -> 30
// . <- 12 -> .
// . <- 30 -> .
// 62 <- 75 -> 87
// . <- 62 -> 70
// . <- 70 -> .
// . <- 87 -> .
