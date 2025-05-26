import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int[] distFromS = dijkstra(n, s, graph);
        int[] distFromA = dijkstra(n, a, graph);
        int[] distFromB = dijkstra(n, b, graph);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int total = distFromS[i] + distFromA[i] + distFromB[i];
            if (total < answer) {
                answer = total;
            }
        }

        return answer;
    }

    private int[] dijkstra(int n, int start, List<int[]>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int nextCost = cost + edge[1];
                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }

        return dist;
    }
}