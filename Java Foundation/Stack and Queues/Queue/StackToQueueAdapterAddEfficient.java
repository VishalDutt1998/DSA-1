import java.io.*;
import java.util.*;

public class StackToQueueAdapterAddEfficient {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if (mainS.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            // 1. Move n-1 elements form main Stack and add them to helper stack
            while (mainS.size() > 1) {
                helperS.push(mainS.pop());
            }
            // 2. Get the last element form the stack and remove it
            int val = mainS.pop();
            // 3. Remove all the elements from the helper stack to main Stack to preserve
            // the order
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
            // 4. Return the value
            return val;
        }

        int peek() {
            if (mainS.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            // 1. Move n-1 elements form main Stack and add them to helper stack
            while (mainS.size() > 1) {
                helperS.push(mainS.pop());
            }
            // 2. Get the last element form the stack.
            int val = mainS.pop();
            helperS.push(val);
            // 3. Remove all the elements from the helper stack to main Stack to preserve
            // the order
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
            // 4. Return the value
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}