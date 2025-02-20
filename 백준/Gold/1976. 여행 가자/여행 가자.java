import java.io.*;
import java.util.*;

public class Main {

    static int N, M, start;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            if (!check(a)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean check(int ed) {
        if (ed == start) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph[node]) {
                if (next == ed) {
                    start = ed;
                    return true;
                }
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}
