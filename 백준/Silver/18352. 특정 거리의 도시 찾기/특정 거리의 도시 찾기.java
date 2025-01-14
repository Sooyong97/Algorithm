import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        dijkstra(K, X);
    }

    private static void dijkstra(int k, int start) {
        int[] D = new int[graph.length];
        Arrays.fill(D, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        D[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int edge : graph[cur]) {
                if (D[edge] == -1) {
                    D[edge] = D[cur] + 1;
                    q.add(edge);
                }
            }
        }

        boolean check = false;
        for (int i = 0; i < graph.length; i++) {
            if (D[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        if (!check) System.out.println("-1");
    }
}
