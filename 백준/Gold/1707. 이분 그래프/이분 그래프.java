import java.util.*;
import java.io.*;

public class Main {
    static int[] visited;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            System.out.println(checkBipartite(graph, V) ? "YES" : "NO");
        }
    }

    private static boolean checkBipartite(List<Integer>[] graph, int V) {
        visited = new int[V + 1];
        isBipartite = true;

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, 1);
            }
            if (!isBipartite) return false;
        }
        return true;
    }

    private static void dfs(List<Integer>[] graph, int node, int color) {
        visited[node] = color;

        for (int next : graph[node]) {
            if (visited[next] == 0) {
                dfs(graph, next, -color);
            } else if (visited[next] == visited[node]) {
                isBipartite = false;
                return;
            }
        }
    }
}