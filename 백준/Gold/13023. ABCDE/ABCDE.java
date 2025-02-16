import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            dfs(i, visited, 1);
        }
        if (!check) System.out.println(0);
    }

    private static void dfs(int i, boolean[] visited, int count) {
        if (check) return;
        if (count == 5) {
            check = true;
            System.out.println(1);
            return;
        }
        for (int node : graph[i]) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node, visited, count + 1);
                visited[node] = false;
            }
        }
    }
}