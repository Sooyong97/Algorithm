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
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        int[][] distToX = new int[n + 1][n + 1];
        int[][] distFromX = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(distToX[i], Integer.MAX_VALUE);
            Arrays.fill(distFromX[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            findMinTime(distToX[i], i);
            findMinTime(distFromX[i], x);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, distToX[i][x] + distFromX[i][i]);
        }

        System.out.println(max);
    }

    private static void findMinTime(int[] D, int st) {
        D[st] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{st, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];
            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int nextDist = edge[1];
                if (D[nextNode] > dist + nextDist) {
                    D[nextNode] = dist + nextDist;
                    pq.add(new int[]{nextNode, dist + nextDist});
                }
            }
        }
    }
}
