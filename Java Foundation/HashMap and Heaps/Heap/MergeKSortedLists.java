package Heap;

import java.io.*;
import java.util.*;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair> {
        int val;
        int row;
        int col;

        public Pair(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            ans.add(rem.val);
            // rem.col++;
            // pq.add(new Pair(lists.get(rem.row).get(rem.col), rem.row, rem.col));

            int newRow = rem.row;
            int newCol = rem.col + 1;
            if (newCol < lists.get(newRow).size()) {
                int newVal = lists.get(newRow).get(newCol);
                pq.add(new Pair(newVal, newRow, newCol));
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}