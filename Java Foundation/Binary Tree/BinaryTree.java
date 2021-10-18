import java.io.*;
import java.util.*;

public class BinaryTree {
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

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        int idx = 0;
        while (st.size() > 0) {
            Pair p = st.peek();

            if (p.state == 0) {
                // left child processing
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // right child processing
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else {
                // pop out the node pair from the stack
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        if (root == null)
            return;

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
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls + rs + node.data;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        return Math.max(node.data, Math.max(lmax, rmax));
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public static void levelOrder(Node node) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while (que.size() > 0) {
            int sz = que.size();
            while (sz-- > 0) {
                // 1. Get + Remove
                Node rem = que.remove();
                // 2. Print Data
                System.out.print(rem.data + " ");
                // 3. Add Children to Queue
                if (rem.left != null) {
                    que.add(rem.left);
                }
                if (rem.right != null) {
                    que.add(rem.right);
                }
            }
            System.out.println();
        }
    }

    // PreArea -> Area Before All Calls
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InArea -> Area Between the calls i.e. left and right calls
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // PostArea -> Area After all calls
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    static ArrayList<Integer> pre;
    static ArrayList<Integer> in;
    static ArrayList<Integer> post;

    public static void traversal(Node node) {
        if (node == null) {
            return;
        }
        pre.add(node.data);
        traversal(node.left);
        in.add(node.data);
        traversal(node.right);
        post.add(node.data);
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        st.push(new Pair(node, 0));

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                pre.add(p.node.data);
                p.state++;
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
            } else if (p.state == 1) {
                in.add(p.node.data);
                p.state++;
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
            } else { // state == 2
                post.add(p.node.data);
                st.pop();
            }
        }

        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (int val : in) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static boolean find(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            return true;
        }

        // Left result
        boolean lres = find(node.left, data);
        if (lres == true)
            return true;

        // Right result
        boolean rres = find(node.right, data);
        if (rres == true)
            return true;

        return false;
    }

    public static boolean find2(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        boolean res = false;
        res = find2(node.left, data);
        // if left gives true then it will not call to right call
        res = res || find2(node.right, data);
        return res;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            // ArrayList<Integer> bres = new ArrayList<>();
            // return bres;
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        ArrayList<Integer> lres = nodeToRootPath(node.left, data);
        if (lres.size() > 0) {
            lres.add(node.data);
            return lres;
        }

        ArrayList<Integer> rres = nodeToRootPath(node.right, data);
        if (rres.size() > 0) {
            rres.add(node.data);
            return rres;
        }

        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static void printKLevelsDown2(Node node, int k) {
        // write your code here
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
            return;
        }
        printKLevelsDown2(node.left, --k);
        printKLevelsDown2(node.right, k);
        // --k is allowed in recursion but k-- is not allowed
        // if we have done --k on one level the we dont have to --k on the other level
    }

    public static ArrayList<Node> nodeToRoot(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Node> bres = new ArrayList<>();
            bres.add(node);
            return bres;
        }

        ArrayList<Node> lres = nodeToRoot(node.left, data);
        if (lres.size() > 0) {
            lres.add(node);
            return lres;
        }

        ArrayList<Node> rres = nodeToRoot(node.right, data);
        if (rres.size() > 0) {
            rres.add(node);
            return rres;
        }

        return new ArrayList<>();
    }

    public static void printKDown(Node node, Node blockage, int k) {
        if (node == null || node == blockage || k < 0)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKDown(node.left, blockage, k - 1);
        printKDown(node.right, blockage, k - 1);
    }

    public static void printKNodesFar(Node root, int data, int k) {
        ArrayList<Node> n2rp = nodeToRoot(root, data);
        Node blockage = null;
        for (int i = 0; i < n2rp.size() && k >= 0; i++) {
            Node node = n2rp.get(i);
            printKDown(node, blockage, k);
            k--;
            blockage = node;
        }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        // Leaf Node
        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static void pathToLeafFromRoot2(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            pathToLeafFromRoot2(node.left, path + node.data + " ", sum + node.data, lo, hi);
            pathToLeafFromRoot2(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRoot2(node.left, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRoot2(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else {
            // Leaf Node
            sum += node.data;
            path += node.data;
            if (lo <= sum && sum <= hi) {
                // print path
                System.out.println(path);
            }
        }
    }

    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }
        Node lcn = createLeftCloneTree(node.left); // left child node
        Node rcn = createLeftCloneTree(node.right); // right child node
        Node nn = new Node(node.data, lcn, null);
        node.left = nn;
        node.right = rcn;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null)
            return null;
        Node lcn = transBackFromLeftClonedTree(node.left.left);
        Node rcn = transBackFromLeftClonedTree(node.right);
        node.left = lcn;
        node.right = rcn;
        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null)
            return;

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        }

        if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static void printSingleChildNodes2(Node node, Node parent) {
        if (node.left == null && node.right == null) {
            return;
        } else if (node.left != null && node.right != null) {
            printSingleChildNodes2(node.left, parent);
            printSingleChildNodes2(node.right, parent);
        } else if (node.left != null) {
            System.out.println(node.left.data);
            printSingleChildNodes2(node.left, parent);
        } else {
            System.out.println(node.right.data);
            printSingleChildNodes2(node.right, parent);
        }
    }

    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public static Node removeLeaves2(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null && node.right != null) {
            node.left = removeLeaves2(node.left);
            node.right = removeLeaves2(node.right);
        } else if (node.left != null) {
            node.left = removeLeaves2(node.left);
        } else if (node.right != null) {
            node.right = removeLeaves2(node.right);
        } else { // Leaf Node
            node = null;
        }
        return node;
    }

    static int tilt = 0;

    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }
        int lsum = tilt(node.left);
        int rsum = tilt(node.right);
        tilt += Math.abs(lsum - rsum);
        return lsum + rsum + node.data;
    }

    static int diameter = 0;

    public static int heightForDiameter(Node root) {
        if (root == null) {
            return -1; // on the Basis of Edge
        }

        int lh = heightForDiameter(root.left);
        int rh = heightForDiameter(root.right);
        diameter = Math.max(diameter, lh + rh + 2);
        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        diameter = 0;
        heightForDiameter(root);
        return diameter;
    }

    static class DiaPair {
        int dia;
        int ht;

        public DiaPair() {
            this.dia = 0;
            this.ht = -1;
        }

        public DiaPair(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            return new DiaPair();
        }

        DiaPair lres = diameter2(node.left);
        DiaPair rres = diameter2(node.right);

        DiaPair mres = new DiaPair();

        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.dia = Math.max(lres.ht + rres.ht + 2, Math.max(lres.dia, rres.dia));
        return mres;
    }

    public static int diameterOfBinaryTree2(Node root) {
        DiaPair res = diameter2(root);
        return res.dia;
    }

    public static class BPair {
        int ht;
        boolean isBalance;

        public BPair() {
            this.ht = -1;
            this.isBalance = true;
        }
    }

    // Time Complexity O(n^2)
    public static boolean isBalanced1(Node node) {
        if (node == null) {
            return true;
        }

        boolean lb = isBalanced1(node.left); // Left Balanced
        boolean rb = isBalanced1(node.right); // Right Balanced
        int factor = height(node.left) - height(node.right); // Balancing Bactor
        if (lb && rb && factor >= -1 && factor <= 1) {
            return true;
        }
        return false;
    }

    public static BPair isBalanced(Node node) {
        if (node == null) {
            return new BPair();
        }

        BPair lres = isBalanced(node.left);
        BPair rres = isBalanced(node.right);

        boolean factor = Math.abs(lres.ht - rres.ht) <= 1;

        BPair mres = new BPair();
        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.isBalance = factor && lres.isBalance && rres.isBalance;

        return mres;
    }

    

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null,
                null, 87, null, null };
        Node root = construct(arr);
        // display(root);
        // System.out.println("Size : " + size(root));
        // System.out.println("Sum : " + sum(root));
        // System.out.println("Max : " + max(root));
        // System.out.println("Height : " + height(root));
        // levelOrder(root);

        // System.out.print("Pre Order : ");
        // preOrder(root);
        // System.out.print("\nIn Order : ");
        // inOrder(root);
        // System.out.print("\nPost Order : ");
        // postOrder(root);

        // pre = new ArrayList<>();
        // in = new ArrayList<>();
        // post = new ArrayList<>();
        // traversal(root);

        // System.out.println(pre);
        // System.out.println(in);
        // System.out.println(post);

        // System.out.print("\nPre Order : ");
        // for (int val : pre)
        // System.out.print(val + " ");

        // System.out.print("\nIn Order : ");
        // for (int val : in)
        // System.out.print(val + " ");

        // System.out.print("\nPost Order : ");
        // for (int val : post)
        // System.out.print(val + " ");

        // iterativePrePostInTraversal(root);
        // System.out.println(find(root, 30));
        // System.out.println(find2(root, 30));
        // ArrayList<Integer> ans = nodeToRootPath(root, 30);
        // System.out.println(ans);

        // printKLevelsDown2(root, 2);
        // printKNodesFar(root, 37, 2);

        // pathToLeafFromRoot2(root, "", 0, 150, 250);
        tilt(root);
        System.out.println(tilt);
    }

    public static void main(String[] args) {
        fun();
    }
}
