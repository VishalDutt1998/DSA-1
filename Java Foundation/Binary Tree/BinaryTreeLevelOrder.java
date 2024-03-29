import java.util.*;

public class BinaryTreeLevelOrder {
    // TreeNode class for a node of a Binary Search Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // It takes as input the root of the given tree. It should return the
    // level order traversal as an arraylist of arraylist.
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rem = queue.removeFirst();
                temp.add(rem.val);

                if (rem.left != null) {
                    queue.addLast(rem.left);
                }
                if (rem.right != null) {
                    queue.addLast(rem.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // length of array representing the tree
        int len = sc.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = levelOrder(arr);

        ArrayList<ArrayList<Integer>> res = levelOrderTraversal(root);

        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.val;
        str += " <= " + node.val + " => ";
        str += node.right == null ? "." : node.right.val;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    // creation of tree from array by level order, -1 says there is no node
    public static TreeNode levelOrder(int[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);

                if (i > 0) {
                    int pi = (i - 1) / 2;

                    if (i == 2 * pi + 1) {
                        nodes[pi].left = nodes[i];
                    } else {
                        nodes[pi].right = nodes[i];
                    }
                }
            }
        }
        TreeNode root = nodes[0];
        return root;
    }
}

// [3,9,20,-1,-1,15,7]