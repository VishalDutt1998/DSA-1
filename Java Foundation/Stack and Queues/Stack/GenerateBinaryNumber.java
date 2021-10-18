import java.io.*;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
public class GenerateBinaryNumber {

    // Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N) {
        ArrayList<String> res = new ArrayList<>();
        Queue<String> qu = new LinkedList<String>();
        qu.add("1");
        for (int i = 0; i < N; i++) {
            String str = qu.remove();
            res.add(str);
            qu.add(str + "0");
            qu.add(str + "1");
        }
        return res;
    }
}