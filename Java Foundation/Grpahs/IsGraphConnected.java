import java.io.*;
import java.util.*;

public class IsGraphConnected {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    // static int count = 0;

    // public static void traversal(ArrayList<Edge>[] graph, int src, boolean[] visited) {
    //     visited[src] = true;
    //     count++;
    //     for (Edge e : graph[src]) {
    //         if (visited[e.nbr] == false) {
    //             traversal(graph, e.nbr, visited);
    //         }
    //     }
    // }

    public static void traversal(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                traversal(graph, e.nbr, visited, comp);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                traversal(graph, v, visited, comp);
                comps.add(comp);
            }
        }

        // ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        // boolean[] visited = new boolean[vtces];
        // traversal(graph, 0, visited);

        if (comps.size() == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // if (count == vtces) {
        //     System.out.println("true");
        // } else {
        //     System.out.println("false");
        // }
    }
}
