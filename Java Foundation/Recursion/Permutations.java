import java.io.*;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        permutations(new boolean[4], 2, 0, "");
        // combinations(new boolean[4], 2, 0, "",-1);
    }

    static int counter = 0;

    public static void permutations(boolean[] boxes, int tq, int qpsf, String asf) {
        // Queen Placed so far qpsf
        if (qpsf == tq) {
            counter++;
            System.out.println(counter + ". " + asf);
            return;
        }

        for (int b = 0; b < boxes.length; b++) {
            if (boxes[b] == false) {
                boxes[b] = true;
                permutations(boxes, tq, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b);
                boxes[b] = false;
            }
        }
    }

    public static void combinations(boolean[] boxes, int tq, int qpsf, String asf, int lqpb) {

        if (qpsf == tq) {
            counter++;
            System.out.println(counter + ". " + asf);
            return;
        }

        for (int b = lqpb + 1; b < boxes.length; b++) {
            if (boxes[b] == false) {
                boxes[b] = true;
                combinations(boxes, tq, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b, b);
                boxes[b] = false;
            }
        }
    }
}