import java.io.*;
import java.util.*;

public class Permutation2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nboxes = scn.nextInt();
        int ritems = scn.nextInt();
        permutations(1,nboxes,new int[ritems],0,ritems,"");
    }
    public static void permutations(int cb,int tb,int[] items,int ssf,int ts, String asf){
        // Base Case
        if(cb==tb+1){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }

        for(int i=0;i<items.length;i++){
            if(items[i]==0){
                items[i]=1;
                permutations(cb+1,tb,items,ssf+1,ts,asf+(i+1));
                items[i]=0;
            }
        }
        
        permutations(cb+1,tb,items,ssf,ts,asf+"0");
    }
}
