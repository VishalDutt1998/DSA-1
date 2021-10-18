import java.io.*;
import java.util.*;

public class QueueToStackAdapterPushEfficient {

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
            mainQ.add(val);
        }

        int pop() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            // 1. Remove n-1 elements from main queue and add it in helper queue
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            // 2. Get value of nth element from main queue
            int val = mainQ.peek();
            // 3. Remove the nth element fromt the main queue
            mainQ.remove();
            // 4. Cahnge the referece of the queue
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
            // 5. Return value
            return val;
        }

        int top() {
            if (mainQ.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            // 1. Remove n-1 elements from main queue and add it in helper queue
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            // 2. Get value of nth element from main queue
            int val = mainQ.peek();
            // 3. Remove the nth element from the main queue and add it to helperQ
            helperQ.add(mainQ.remove());
            // 4. Cahnge the referece of the queue
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            // mainQ = helperQ;
            // helperQ = new ArrayDeque<>();

            // return value
            return val;
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