import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] graph;
    static boolean[] visited;
    static int maxEdge = -1;
    static int max = 0;

    static class Node {
        int edge;
        int cost;

        public Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int edge = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) continue;
                graph[edge].add(new Node(e, Integer.parseInt(st.nextToken())));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(maxEdge, 0);

        System.out.println(max);

    }

    static void dfs(int node, int cost) {
        if (cost > max) {
            max = cost;
            maxEdge = node;
        }

        visited[node] = true;
        for (Node n : graph[node]) {
            if (!visited[n.edge]) {
                dfs(n.edge, n.cost + cost);
                visited[n.edge] = true;
            }
        }
    }
}