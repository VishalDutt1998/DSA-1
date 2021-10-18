import java.io.*;
import java.util.*;

public class QueueToStackAdapterPopEfficient {

    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            // 1. Remove all elements from main Queue and add all the elements in
            // helper Queue
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }
            // 2. Add new Element in main Queue
            mainQ.add(val);
            // 3. Refill main Queue from helper Queue
            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        // void push(int val) {
        //     // 1. Add new Element in main Queue
        //     helperQ.add(val);
        //     // 2. Refill helper Queue from main Queue
        //     while (mainQ.size() > 0) {
        //         helperQ.add(mainQ.remove());
        //     }
        //     // 3. change the reference of the Queue
        //     mainQ = helperQ;
        //     helperQ = new ArrayDeque<>();
        // }

        int pop() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return mainQ.remove();
        }

        int top() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return mainQ.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}