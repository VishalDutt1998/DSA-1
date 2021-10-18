
// Boxes chooses the items
import java.io.*;
import java.util.*;

public class Combination1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        combinations(1, nboxes, 0, ritems, "");
    }

    // cb --> current box
    // tb --> total box
    // ssf --> selection so far
    // asf--> ans so far
    // ts --> total selection
    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
        // Base Case
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        combinations(cb + 1, tb, ssf, ts, asf + "-");
    }
}
