import java.io.*;
import java.util.*;

public class DemoQueue {
    public static void demo() {
        // Queue is interface in java ArrayDeque implements queue in java
        // Queue<Integer> que = new Queue<>();

        Queue<Integer> que = new ArrayDeque<>();
        // ArrayDeque<Integer> que = new ArrayDeque<>();

        que.add(10);
        que.add(20);
        que.add(30);

        System.out.println(que);
        que.add(40);
        que.add(50);
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que);
        System.out.println(que.peek());
        System.out.println(que.size());

    }

    public static void main(String[] args) {
        demo();
    }
}