import java.io.*;
import java.util.*;

public class BST {
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

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize + rsize + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        } else if (node.right == null) {
            return node.data;
        } else {
            return max(node.right);
        }
    }

    public static int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.left == null) {
            return node.data;
        } else {
            return min(node.left);
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
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

    private static Node delete(Node node) {
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

    public static boolean isBST1(Node node) {
        if (node == null) {
            return true;
        }
        int lmax = max(node.left);
        int rmin = min(node.right);
        if (lmax > node.data || rmin < node.data) {
            return false;
        }
        boolean res = isBST1(node.left) && isBST1(node.right);
        return res;
    }

    public static class BSTPair {
        int min;
        int max;
        boolean isbst;

        public BSTPair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isbst = true;
        }
    }

    // TIme Complexiyt O(n)
    public static BSTPair isBST(Node node) {
        if (node == null) {
            return new BSTPair();
        }

        BSTPair lres = isBST(node.left);
        BSTPair rres = isBST(node.right);

        boolean status = lres.max < node.data && rres.min > node.data;
        BSTPair mres = new BSTPair();
        mres.min = Math.min(node.data, Math.min(lres.min, rres.min));
        mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
        mres.isbst = lres.isbst && rres.isbst && status;
        return mres;
    }

    public static int lca(Node node, int d1, int d2) {
        if (d1 > node.data && d2 > node.data) { // lca -> right side
            return lca(node.right, d1, d2);
        } else if (d1 < node.data && d2 < node.data) { // lca -> left side
            return lca(node.left, d1, d2);
        } else { // lca found
            return node.data;
        }
    }

    // Print In Range
    public static void pir(Node node, int d1, int d2) {
        if (node == null) {
            return;
        }
        if (d1 > node.data && d2 > node.data) { // Range -> Right Side
            pir(node.right, d1, d2);
        } else if (d1 < node.data && d2 < node.data) {// Range -> Left Side
            pir(node.left, d1, d2);
        } else {
            pir(node.left, d1, d2);
            System.out.println(node.data);
            pir(node.right, d1, d2);
        }
    }

    public static void printTargetSumPair1(Node root, Node node, int tar) {
        if (node == null) {
            return;
        }

        int data = node.data;
        int comp = tar - data;
        printTargetSumPair1(root, node.left, tar);
        if (data < comp) {
            if (find(root, comp) == true) {
                System.out.println(data + " " + comp);
            }
        }
        printTargetSumPair1(root, node.right, tar);
    }

    public static void inorderFiller(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        inorderFiller(node.left, list);
        list.add(node.data);
        inorderFiller(node.right, list);
    }

    public static void printTargetSumPair2(Node node, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderFiller(node, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                System.out.println(list.get(left) + " " + list.get(right));
                left++;
                right--;
            }
        }
    }

    // Using Iterative Inorder Traversal

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static int inorderItr(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair p = st.peek();

            if (p.state == 0) {
                // left child
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // right child
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
                return p.node.data;
            } else {
                // pop
                st.pop();
            }
        }
        return -1;
    }

    public static int revInorderItr(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair p = st.peek();

            if (p.state == 0) {
                // right child
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // left child
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
                return p.node.data;
            } else {
                // pop
                st.pop();
            }
        }
        return -1;
    }

    public static void printTargetSumPair3(Node node, int target) {
        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();

        ls.push(new Pair(node, 0));
        rs.push(new Pair(node, 0));

        int left = inorderItr(ls);
        int right = revInorderItr(rs);

        while (left < right) {
            int sum = left + right;
            if (sum > target) {
                right = revInorderItr(rs);
            } else if (sum < target) {
                left = inorderItr(ls);
            } else {
                System.out.println(left + " " + right);
                left = inorderItr(ls);
                right = revInorderItr(rs);
            }
        }
    }

    static int ceil = Integer.MAX_VALUE; // Qualified Minimum
    static int floor = Integer.MIN_VALUE; // Qualified Maximum

    public static void floorCeil(Node node, int val) {
        if (node == null) {
            return;
        }
        while (node != null) {
            if (val < node.data) {
                ceil = node.data;
                node = node.left;
            } else if (val > node.data) {
                floor = node.data;
                node = node.right;
            } else {
                ceil = floor = node.data;
                break;
            }
        }
    }

    public static Node findClosest(Node node, int value) {
        if (node == null) {
            return null;
        }
        int minDiff = Integer.MAX_VALUE;
        Node closestNode = null;
        while (node != null) {
            int currDiff = Math.abs(node.data - value);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                closestNode = node;
            }

            if (value < node.data) {
                node = node.left;
            } else if (value > node.data) {
                node = node.right;
            } else {
                break;
            }
        }
        return closestNode;
    }

    public static void fun() {
        int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Node root = construct(data, 0, data.length - 1);
        // display(root);
        // System.out.println("Size : " + size(root));
        // System.out.println("Sum : " + sum(root));
        // System.out.println("Max : " + max(root));
        // System.out.println("Min : " + min(root));
        // System.out.println(isBST(root));
        // printTargetSumPair1(root, root, 100);
        // printTargetSumPair2(root, 100);
        // printTargetSumPair3(root, 100);
        floorCeil(root, 60);
        System.out.println("Ceil " + ceil);
        System.out.println("Floor " + floor);
    }

    public static void main(String[] args) {
        fun();
    }
}
