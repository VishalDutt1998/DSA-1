import java.io.*;
import java.util.*;

public class AllPath {

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

    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {
        // Base Case
        if (src == dest) {
            System.out.println(path);
            return;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.dest] == false) {
                allPath(graph, e.dest, dest, visited, path + e.dest);
            }
        }
        visited[src] = false;
    }

    // public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {

    //     if (src == dest) {
    //         path += dest;
    //         // because the in base case the destination will not added to the path
    //         System.out.println(path);
    //         return;
    //     }
    //     visited[src] = true;
    //     path += src;
    //     for (Edge e : graph[src]) {
    //         if (visited[e.dest] == false) {
    //             allPaths(graph, e.dest, dest, visited, path);
    //         }
    //     }
    //     visited[src] = false;
    // }

    // public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {
    //     visited[src] = true;
    //     if (src == dest) {
    //         System.out.println(path);
    //         visited[src] = false;
    //         return;
    //     }
    //     visited[src] = true;
    //     for (Edge e : graph[src]) {
    //         if (visited[e.dest] == false) {
    //             allPaths(graph, e.dest, dest, visited, path + e.dest);
    //         }
    //     }
    //     visited[src] = false;
    // }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
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
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vertices];
        allPath(graph, src, dest, visited, src + "");
    }
}

// Input
// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2 5 10
// 0
// 6

// op
// 0123456
// 012346
// 012546
// 01256
// 032546
// 03256
// 03456
// 0346
