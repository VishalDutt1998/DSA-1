import java.io.*;
import java.util.*;

public class GraphConstuction {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {
            int src = scn.nextInt();
            int dest = scn.nextInt();
            int wt = scn.nextInt();
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(src, dest, wt));
        }
        int source = scn.nextInt();
        int destination = scn.nextInt();
        boolean[] visited = new boolean[vtces];
        boolean ans = hasPath(graph, source, destination, visited);
        System.out.println(ans);
        scn.close();
    }

    // hasPath fucntion
    public static boolean hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        ArrayList<Edge> nbr = graph[source];
        for (Edge tempnbr : nbr) {
            if (visited[tempnbr.dest] == false) {
                boolean flag = hasPath(graph, tempnbr.dest, destination, visited);
                if (flag == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
