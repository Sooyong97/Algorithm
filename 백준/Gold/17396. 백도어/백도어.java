import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] graph;
    static int[] visions;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        visions = new int[N];
        for (int i = 0; i < N; i++) {
            visions[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        dijkstra();

    }

    private static void dijkstra() {
        long[] time = new long[N];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long node = cur[0];
            long t = cur[1];

            if (t > time[(int) node]) continue;

            for (int[] edge : graph[(int) node]) {
                int nextNode = edge[0];
                int nextTime = edge[1];
                if (nextNode != N - 1 && visions[nextNode] == 1) continue;
                if (time[nextNode] > t + nextTime) {
                    time[nextNode] = t + nextTime;
                    pq.add(new long[]{nextNode, time[nextNode]});
                }
            }
        }

        long finalTime = time[N - 1] == Long.MAX_VALUE ? -1 : time[N - 1];
        System.out.println(finalTime);
    }
}
