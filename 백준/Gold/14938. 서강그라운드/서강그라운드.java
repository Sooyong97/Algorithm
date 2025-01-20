import java.util.*;
import java.io.*;

public class Main {

    static int n, m, r;
    static List<int[]>[] graph;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, collectItems(i));
        }

        System.out.println(max);
    }

    private static int collectItems(int start) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

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

                if (dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int totalItems = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                totalItems += items[i];
            }
        }

        return totalItems;
    }
}