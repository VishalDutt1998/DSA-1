import java.io.*;
import java.util.*;

public class GTree {

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

    public static int size(Node root) {
        int sz = 0;
        for (Node child : root.children) {
            sz += size(child);
        }
        return sz + 1;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            max = Math.max(max, max(child));
        }
        return Math.max(max, node.data);
    }

    public static int min(Node node) {
        int min = Integer.MAX_VALUE;
        for (Node child : node.children) {
            min = Math.min(min, min(child));
        }
        return Math.min(min, node.data);
    }

    public static int height(Node node) {
        int ht = -1;
        for (Node child : node.children) {
            ht = Math.max(ht, height(child));
        }
        ht++;
        return ht;
    }

    public static void traversal(Node node) {
        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversal(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }

    public static void levelordertraversal(Node node) {
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

    // Mirror A Generic Tree
    public static void mirror(Node node) {
        // Reverse Children ArrayList in Preorder Area
        Collections.reverse(node.children);
        for (Node child : node.children) {
            mirror(child);
        }
    }

    public static void mirror2(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        // Reverse Children ArrayList in Postorder Area
        Collections.reverse(node.children);
    }

    public static void mirror3(Node node) {
        int si = 0;
        int ei = node.children.size() - 1;
        while (si < ei) {
            Node temp = node.children.get(si);
            node.children.set(si, node.children.get(ei));
            node.children.set(ei, temp);
            si++;
            ei--;
        }

        for (Node child : node.children) {
            mirror(child);
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

    // Linearize the generic tree
    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node slast = node.children.get(node.children.size() - 1);

            Node slasttail = getTail(slast);
            slasttail.children.add(last);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() > 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearize2(Node node) {
        for (Node child : node.children) {
            linearize2(child);
        }

        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node last = node.children.get(i + 1);
            Node slast = node.children.get(i);

            node.children.remove(i + 1);
            Node tail = getTail2(slast);
            tail.children.add(last);
        }
    }

    private static Node getTail2(Node node) {
        Node tail = node;
        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }
        return tail;
    }

    public static Node linearizeEfficient(Node node) {
        if (node.children.size() == 0)
            return node;
        Node lastNode = node.children.get(node.children.size() - 1);
        Node tail = linearizeEfficient(lastNode);
        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node rem = node.children.remove(i + 1);
            Node stail = linearizeEfficient(node.children.get(i));
            stail.children.add(rem);
        }
        return tail;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        boolean found = false;
        for (Node child : node.children) {
            found = find(child, data);
            if (found == true)
                return true;
            // found = found || find(child, data);
        }
        return found;
    }

    public static boolean isAvl = false;

    public static void find2(Node node, int data) {
        if (node.data == data) {
            isAvl = true;
            return;
        }
        for (Node child : node.children) {
            find(child, data);
            if (isAvl == true)
                return;
        }
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

    // Node to root Path using null
    public static ArrayList<Integer> nodeToRootPath2(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        for (Node child : node.children) {
            ArrayList<Integer> rres = nodeToRootPath2(child, data);
            if (rres != null) {
                rres.add(node.data);
                return rres;
            }
        }
        return null;
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> n2rp1 = nodeToRootPath(node, d1);
        ArrayList<Integer> n2rp2 = nodeToRootPath(node, d2);

        int i = n2rp1.size() - 1;
        int j = n2rp2.size() - 1;
        int res = -1;
        while (i >= 0 && j >= 0 && n2rp1.get(i) == n2rp2.get(j)) {
            res = n2rp1.get(i);
            i--;
            j--;
        }
        return res;
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> n2rp1 = nodeToRootPath(node, d1);
        ArrayList<Integer> n2rp2 = nodeToRootPath(node, d2);

        int i = n2rp1.size() - 1;
        int j = n2rp2.size() - 1;
        while (i >= 0 && j >= 0 && n2rp1.get(i) == n2rp2.get(j)) {
            i--;
            j--;
        }
        // distance (i+1)+(j+1)+1(add for common part) -1(node of edges to connet n
        // nodes);
        return i + j + 2;
    }

    public static boolean areSimilar(Node n1, Node n2) {
        // If No. of children are not equal means that tree is not similar in shape
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        // Assume tree is similar in shape
        boolean res = true;
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            res = areSimilar(c1, c2);
            if (res == false) {
                return false;
            }
        }
        return res;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        int j = n2.children.size() - 1;
        // for (int i = 0; i < n1.children.size(); i++) {
        for (int i = 0; i < n1.children.size(); i++, j--) {
            // int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            boolean res = areMirror(c1, c2);
            if (res == false) {
                return false;
            }
        }
        return true;
    }

    // If a tree is mirror to itself then the tree is symmetric
    // Travel and change strategy
    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }

    public static boolean IsSymmetric2(Node node) {
        boolean res = true;
        int j = node.children.size() - 1;
        for (int i = 0; i < node.children.size() / 2; i++) {
            Node child1 = node.children.get(i);
            Node child2 = node.children.get(j);
            j--;
            if (child1.children.size() != child2.children.size()) {
                return false;
            }
            boolean res1 = IsSymmetric2(child1);
            boolean res2 = IsSymmetric2(child2);
            res = res1 && res2;
        }
        return res;
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

    static Node predecessor;
    static Node successor;
    static int state = 0;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
            return;
        }
        // for (Node child : node.children) {
        // predecessorAndSuccessor(child, data);
        // }
        for (Node child : node.children) {
            if (state < 2)
                predecessorAndSuccessor(child, data);
            else
                return;
        }
    }

    public static void predecessorAndSuccessorOptimised(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
            return;
        }
        if (state < 2) {
            for (Node child : node.children) {
                predecessorAndSuccessorOptimised(child, data);
            }
        } else {
            return;
        }
    }

    static int ceil = Integer.MAX_VALUE; // Qualified Minimum
    static int floor = Integer.MIN_VALUE; // Qualified Maximum

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            // Ceil => Smallest among the largest
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            // Floor => Largest among the smallest
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    // static int floor;
    public static void floor(Node node, int data) {
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            floor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int data = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            // Reset the Floor value every time before call other wise the floor will never
            // be updated as the floor is the maximun among the all which is smaller than
            // value
            floor = Integer.MIN_VALUE;
            floor(node, data);
            data = floor;
        }
        return data;
    }

    // Node with maximum Subtree Sum
    static int nodeData = 0;
    static int omax = Integer.MIN_VALUE;

    public static int treeSum(Node node) {
        int sum = 0;
        for (Node child : node.children) {
            sum += treeSum(child);
        }
        sum += node.data;
        if (sum > omax) {
            nodeData = node.data;
            omax = sum;
        }
        return sum;
    }

    public static int treeSum2(Node node) {
        int sum = 0;
        for (Node child : node.children) {
            sum += treeSum2(child);
        }
        sum += node.data;
        System.out.println(node.data + " @ " + sum);
        return sum;
    }

    // Diameter of Generic tree
    public static int diameter(Node node) {
        int mh = -1; // max height
        int smh = -1; // Second max height

        for (Node child : node.children) {
            int ht = height(child);
            if (ht >= mh) {
                smh = mh;
                mh = ht;
            } else if (ht > smh) {
                smh = ht;
            }
        }

        int dfc = 0; // diameter from child
        for (Node child : node.children) {
            dfc = Math.max(diameter(child), dfc);
        }
        return Math.max(dfc, mh + smh + 2);
    }

    public static int diameter = 0;

    public static int heigthForDiameter(Node node) {
        int maxHt = -1;
        int smaxHt = -1;

        for (Node child : node.children) {
            int ht = heigthForDiameter(child);
            if (ht >= maxHt) {
                smaxHt = maxHt;
                maxHt = ht;
            } else if (ht > smaxHt) {
                smaxHt = ht;
            }
        }
        diameter = Math.max(diameter, maxHt + smaxHt + 2);

        return maxHt + 1;
    }

    public static class PairState {
        Node node;
        int state;

        public PairState(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<PairState> st = new Stack<>();
        st.push(new PairState(node, 0));

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while (!st.empty()) {
            PairState p = st.peek();
            if (p.state == 0) {
                pre.add(p.node.data);
                p.state++;
            } else if (p.state <= p.node.children.size()) {
                Node child = p.node.children.get(p.state - 1);
                p.state++;
                st.push(new PairState(child, 0));
            } else {
                post.add(p.node.data);
                st.pop();
            }
        }

        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void fun() {
        // Integer[] data = { 10, 20, -50, null, -60, null, null, 30, -70, null, 80,
        // -110, null, 120, null, null, 90, null,
        // null, -40, 100, null, null, null };

        // Integer[] data = { 10, 20, null, 30, 50, null, 60, null, null, 40, null, null
        // };

        Integer[] data = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };

        // Integer[] data = { 10, 20, null, null };

        // Integer[] data = { 10, 20, -50, null, -60, null, null, 30, -70, null, 80,
        // -110, null, 120, null, null, 90, null,
        // null, -40, 100, null, null, null };

        Node root = construct(data);
        display(root);
        System.out.println("Size :" + size(root));
        System.out.println("Max : " + max(root));
        System.out.println("Min : " + min(root));
        System.out.println("Height : " + height(root));
        traversal(root);
        levelordertraversal(root);
        levelOrderLineWise(root);
        levelOrderLineWise2(root);
        levelOrderLineWise3(root);
        levelOrderLineWise4(root);
        levelOrderLinewiseZigZag(root);
        levelOrderLinewiseZigZag2(root);
        levelOrderLinewiseZigZag3(root);
        mirror(root);
        display(root);
        removeLeaves2(root);
        System.out.println();
        System.out.println();
        removeLeaves6(root);
        linearize2(root);
        linearizeEfficient(root);
        display(root);
        System.out.println(find(root, 110));
        find2(root, 110);
        System.out.println(isAvl);
        ArrayList<Integer> ans = nodeToRootPath(root, 110);
        System.out.println(ans);

        boolean res = areMirror(root, root);
        System.out.println(res);
        multiSolver(root, 0);
        predecessorAndSuccessor(root, 70);
        System.out.println(predecessor.data + " " + successor.data);

        treeSum2(root);
        System.out.println(nodeData + "@" + omax);

        IterativePreandPostOrder(root);
    }

    public static void main(String[] args) {
        fun();
    }
}
