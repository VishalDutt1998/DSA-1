
import java.io.*;
import java.util.*;
public class QueensPermutations2DAs2DBoxChooses {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[] queens =  new boolean[n];

        queensPermutations(0,n,0,0,"",queens);
    }
    public static void queensPermutations(int qpsf,int tq,int row,int col,String asf,boolean[] queens){
        if(qpsf==tq){
            System.out.println(asf);
        }

        int nxtrow = row;
        int nxtcol = col;

        String yesans = asf;
        String noans = asf;

        if(col==tq-1){
            
        }else{
            nxtcol++;
        }

        for(int i=0;i<queens.length;i++){
            if(queens[i]==false){
                queens[i]=true;
                queensPermutations(qpsf+1,tq,nxtrow,nxtcol,asf,queens);
                queens[i] = false;
            }
        }
    }
}
