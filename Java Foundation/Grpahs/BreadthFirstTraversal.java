import java.io.*;
import java.util.*;

public class BreadthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        int vtx;
        String psf;

        public Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
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

        boolean[] visited = new boolean[vtces];
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(src, src + ""));
        visited[src] = true;
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            visited[rem.vtx] = true;
            System.out.println(rem.vtx + "@" + rem.psf);
            for (Edge e : graph[rem.vtx]) {
                if (visited[e.nbr] == false) {
                    visited[e.nbr] = true;
                    queue.addLast(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }

        // visited[src] = true;
        // while (queue.size() > 0) {
        //     Pair rem = queue.removeFirst();
        //     if (visited[rem.vtx] == true) {
        //         continue;
        //     }

        //     visited[rem.vtx] = true;
        //     System.out.println(rem.vtx + "@" + rem.psf);
        //     for (Edge e : graph[rem.vtx]) {
        //         if (visited[e.nbr] == false) {
        //             // visited[e.nbr]=true;
        //             queue.addLast(new Pair(e.nbr, rem.psf + e.nbr));
        //         }
        //     }
        // }
    }
}

// Input
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2

// Output
// 2@2
// 1@21
// 3@23
// 0@210
// 4@234
// 5@2345
// 6@2346