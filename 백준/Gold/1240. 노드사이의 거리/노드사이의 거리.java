import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<int[]>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void findDist(int x, int y) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        visited[x] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == y) {
                sb.append(cur[1]).append('\n');
                return;
            }
            for (int[] edge : graph[cur[0]]) {
                int nx = edge[0], ndist = edge[1];
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new int[]{nx, cur[1] + ndist});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            findDist(start, end);
        }

        System.out.println(sb);
    }
}