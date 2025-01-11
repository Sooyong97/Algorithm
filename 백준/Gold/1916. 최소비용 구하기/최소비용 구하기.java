import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] graph;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        D = new int[N+1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(D, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solve(start, end);
    }

    private static void solve(int start, int end) {
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
                int nextDist = edge[1] + dist;
                if (D[nextNode] > nextDist) {
                    D[nextNode] = nextDist;
                    pq.add(new int[]{nextNode, nextDist});
                }
            }
        }

        System.out.println(D[end]);
    }
}
