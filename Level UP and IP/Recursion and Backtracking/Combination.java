import java.io.*;
import java.util.*;

public class Combination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        combinations(new int[nboxes], 1, ritems, -1);
        scn.close();
    }

    // ci --> current item
    // ti --> total items
    // lb --> lastbox

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        //Base Case
        if(ci>ti){
            for(int i=0;i<boxes.length;i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for (int i = lb+1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                combinations(boxes, ci + 1, ti, i);
                boxes[i] = 0;
            }
        }
    }
}
