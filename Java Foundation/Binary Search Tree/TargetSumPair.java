import java.io.*;
import java.util.*;

public class TargetSumPair {
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

    public static boolean find(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.data > key) {
            return find(node.left, key);
        } else if (node.data < key) {
            return find(node.right, key);
        } else {
            return true;
        }
    }

    // time : O(nh), space : O(h), h-> height
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

    // time : O(n), space : O(n), h-> height
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

    // time : O(n), space : O(h), h-> height
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

    public static void tripletSum(Node node, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderFiller(node, list);
        int left;
        int right;
        for (int i = 0; i < list.size() - 2; i++) {
            left = i + 1;
            right = list.size() - 1;
            while (left < right) {
                int sum = list.get(i) + list.get(left) + list.get(right);
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    System.out.println(list.get(i) + " " + list.get(left) + " " + list.get(right));
                    left++;
                    right--;
                }
            }
        }
    }

    static int count = 0;

    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;
        // search in left subtree
        Node left = kthSmallest(root.left, k);
        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;
        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;
        return kthSmallest(root.right, k);
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

    public static void main(String[] args) {
        // int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        // Node root = construct(data, 0, data.length - 1);
        Node root = construct(data);
        // display(root);
        // printTargetSumPair1(root, root, 100);
        // printTargetSumPair2(root, 100);
        printTargetSumPair3(root, 100);
    }
}
