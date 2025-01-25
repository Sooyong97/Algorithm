import java.util.*;
import java.io.*;

public class Main {

    static final int max = 10001;
    static int N, D;
    static List<int[]>[] shortcuts;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcuts = new ArrayList[max];
        for (int i = 0; i < max; i++) {
            shortcuts[i] = new ArrayList();
        }

        distance = new int[max];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shortcuts[start].add(new int[]{end, dist});
        }

        distance[0] = 0;
        dijkstra(0);
        System.out.println(distance[D]);
    }

    private static void dijkstra(int start) {
        if (start >= D) return;

        if (distance[start + 1] > distance[start] + 1) {
            distance[start + 1] = distance[start] + 1;
        }

        if (!shortcuts[start].isEmpty()) {
            for (int[] edge : shortcuts[start]) {
                int nextNode = edge[0];
                int nextdist = edge[1];
                if (distance[nextNode] > distance[start] + nextdist) {
                    distance[nextNode] = distance[start] + nextdist;
                }
            }
        }

        dijkstra(start + 1);
    }
}
