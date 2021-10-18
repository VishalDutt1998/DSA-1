public class NodeWithMaximumSubtreeSum {

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
}
