import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] graph;
    static Deque<Integer> log = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int cost = dijkstra(start, end);
        System.out.println(cost);
        System.out.println(log.size());
        while (!log.isEmpty()) {
            System.out.print(log.pollLast() + " ");
        }
    }

    private static int dijkstra(int start, int end) {
        int N = graph.length;
        int[] dist = new int[N];
        int[] prev = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
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
                    prev[nextNode] = node;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        for (int at = end; at != -1; at = prev[at]) {
            log.add(at);
        }

        return dist[end];
    }
}