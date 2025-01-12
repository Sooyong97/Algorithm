import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        int[] distFromX = dijkstra(x);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int[] distToX = dijkstra(i);
            maxTime = Math.max(maxTime, distToX[x] + distFromX[i]);
        }

        System.out.println(maxTime);
    }

    private static int[] dijkstra(int start) {
        int[] D = new int[n + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];
            if (dist > D[node]) continue;

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int nextDist = edge[1];
                if (D[nextNode] > dist + nextDist) {
                    D[nextNode] = dist + nextDist;
                    pq.add(new int[]{nextNode, dist + nextDist});
                }
            }
        }
        return D;
    }
}