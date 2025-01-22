import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static List<int[]>[] graph;
    static int[][] log;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        log = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }

        findMinDistance();

    }

    private static void findMinDistance() {
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            System.out.println();
        }
    }

    private static void dijkstra(int start) {
        int[] D = new int[n + 1];
        int[] prev = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
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
                    prev[nextNode] = node;
                    pq.add(new int[]{nextNode, D[nextNode]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == start) continue;
            int at = i;
            while (prev[at] != start) {
                at = prev[at];
            }
            log[start][i] = at;
        }

        for (int i = 1; i <= n; i++) {
            if (i == start) System.out.print("- ");
            else System.out.print(log[start][i] + " ");
        }
    }

}