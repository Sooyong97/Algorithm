import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        System.out.print(dijkstra(1, N));
    }

    private static int dijkstra(int start, int end) {
        int[] D = new int[end + 1];
        boolean[] visited = new boolean[end + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int nextCost = edge[1];

                if (D[nextNode] > cost + nextCost) {
                    D[nextNode] = cost + nextCost;
                    pq.add(new int[]{nextNode, D[nextNode]});
                }
            }
        }

        return D[end];
    }
}