import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(s[j]) == 1) {
                    graph[i + 1].add(j + 1);
                }
            }
        }

        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                checkGraph(i, j);
            }
            System.out.println();
        }
    }

    private static void checkGraph(int i, int j) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;

            for (int k : graph[cur]) {
                if (k == j) {
                    System.out.print(1 + " ");
                    return;
                }
                if (!visited[k]) {
                    q.add(k);
                }
            }
        }
        System.out.print(0 + " ");
    }
}
