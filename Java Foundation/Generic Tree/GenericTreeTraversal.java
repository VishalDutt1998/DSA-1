public class GenericTreeTraversal {
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

    public static void main(String[] args) {

    }
}
