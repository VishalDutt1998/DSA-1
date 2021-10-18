import java.io.*;
import java.util.*;

public class SpreadofInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vtces];
        queue.addLast(src);
        visited[src] = true;
        int level = 1;
        int count = 0;
        while (queue.size() > 0 && level <= t) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.removeFirst();
                count++;
                for (Edge e : graph[rem]) {
                    if (visited[e.nbr] == false) {
                        queue.addLast(e.nbr);
                        visited[e.nbr] = true;
                    }
                }
            }
            level++;
        }
        System.out.println(count);
    }

}