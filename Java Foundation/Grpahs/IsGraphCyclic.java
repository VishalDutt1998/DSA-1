import java.io.*;
import java.util.*;

public class IsGraphCyclic {
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

        LinkedList<Integer> queue = new LinkedList<>();
        int[] parr = new int[vtces];
        Arrays.fill(parr, -1);

        for (int v = 0; v < vtces; v++) {
            if (parr[v] == -1) {
                queue.addLast(v);
                parr[v] = -2;
                while (queue.size() > 0) {
                    int rem = queue.removeFirst();
                    for (Edge e : graph[rem]) {
                        if (parr[e.nbr] == -1) {
                            queue.addLast(e.nbr);
                            parr[e.nbr] = rem;
                        } else {
                            if (e.nbr != parr[rem]) {
                                System.out.println(true);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(false);
    }
}