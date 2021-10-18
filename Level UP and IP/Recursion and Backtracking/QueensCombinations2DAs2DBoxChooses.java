import java.io.*;
import java.util.*;

public class QueensCombinations2DAs2DBoxChooses {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensPermutations(0,n,0,0,"");
    }

    public static void queensPermutations(int qpsf,int tq,int row,int col,String asf){
        if(row==tq){
            if(qpsf==tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        int nxtrow = row;
        int nxtcol = col;
        

        if(col==tq-1){
            nxtrow++;
            nxtcol =0;
            yesans = yesans + "q\n";
        }else{
            nxtcol++;
            yesans = yesans + "q";
        }

        queensPermutations(qpsf+1, tq, nxtrow, nxtcol, yesans);
        queensPermutations(qpsf, tq, nxtrow, nxtcol, noans);
    }
}
