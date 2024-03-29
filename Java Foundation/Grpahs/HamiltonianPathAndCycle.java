import java.io.*;
import java.util.*;

public class HamiltonianPathAndCycle {
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

        int src = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        allPath(graph, src, visited, 0, src + "", src);

    }

    public static void allPath(ArrayList<Edge>[] graph, int src, boolean[] visited, int viscount, String psf,
            int actsrc) {
        if (viscount == graph.length - 1) {
            System.out.print(psf);
            boolean flag = false;
            for (Edge e : graph[src]) {
                if (e.nbr == actsrc) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }
        visited[src] = true;
        viscount++;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                allPath(graph, e.nbr, visited, viscount, psf + e.nbr, actsrc);
            }
        }
        visited[src] = false;
        viscount--;
    }

}