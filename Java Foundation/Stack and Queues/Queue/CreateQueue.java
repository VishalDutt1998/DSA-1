import java.io.*;
import java.util.*;

class queue {
    private int[] data;
    private int front = 0;
    private int size = 0;

    public queue(int capacity) {
        this.data = new int[capacity];
    }

    public void add(int val) {
        if (this.size == data.length) {
            System.out.println("Queue overerflow");
            return;
        }
        int idx = (this.front + this.size) % data.length;
        data[idx] = val;
        this.size++;
    }


    public int remove() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        int val = data[this.front];
        this.front = (this.front + 1) % data.length;
        this.size--;
        return val;
    }

    public int peek() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return data[this.front];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        String str = "";
        str += "[";
        for (int i = 0; i < this.size - 1; i++) {
            int idx = (i + front) % data.length;
            str += data[idx] + ", ";
        }
        if (this.size > 0)
            str += data[(size - 1 + front) % data.length] + "]";
        else
            str += "]";
        return str;
    }
}

public class CreateQueue {

    public static void demo() {
        queue que = new queue(5);
        System.out.println(que);

        que.add(10);
        que.add(20);

        System.out.println(que);
        que.add(30);
        que.add(40);
        System.out.println(que);
        que.add(50);
        que.add(60);
        System.out.println(que.remove());
        System.out.println(que);
        que.add(60);
        System.out.println(que.peek());
        System.out.println(que.size());
        System.out.println(que);

    }

    public static void main(String[] args) throws IOException {
        demo();
    }
}