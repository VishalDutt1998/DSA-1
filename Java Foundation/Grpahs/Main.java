import java.io.*;
import java.util.*;

public class Main {
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

        // write your code here
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == -1) {
                boolean ans = isBipartite(graph, i, visited);
                if (ans == false) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static boolean isBipartite(ArrayList<Edge> graph[], int src, int[] visited) {
        int level = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        while (queue.size() > 0) {
            int rem = queue.removeFirst();
            if (visited[rem] != -1) {
                if (level != visited[rem]) {
                    return false;
                }
            } else {
                visited[rem] = level;
            }
            for (Edge e : graph[rem]) {
                if (visited[e.nbr] == -1) {
                    queue.addLast(rem);
                }
            }
            level++;
        }

        return true;
    }
}