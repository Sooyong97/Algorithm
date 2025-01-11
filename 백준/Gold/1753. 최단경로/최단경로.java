import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] graph;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        D = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(D, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
        }

        solve(K);
    }

    private static void solve(int start) {
        D[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];

            if (D[node] < dist) continue;

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newDist = dist + weight;

                if (newDist < D[nextNode]) {
                    D[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        for (int i = 1; i < D.length; i++) {
            if (D[i] != Integer.MAX_VALUE) System.out.println(D[i]);
            else System.out.println("INF");
        }
    }
}