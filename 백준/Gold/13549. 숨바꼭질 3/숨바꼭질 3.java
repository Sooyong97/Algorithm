import java.util.*;
import java.io.*;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        solve(N, K);
    }

    private static void solve(int N, int K) {
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];
            visited[node] = true;

            if (node == K) min = Math.min(min, dist);

            if (node * 2 <= MAX && !visited[node * 2]) q.add(new int[]{node * 2, dist});

            if (node + 1 <= MAX && !visited[node + 1]) q.add(new int[]{node + 1, dist + 1});

            if (node - 1 >= 0 && !visited[node - 1]) q.add(new int[]{node - 1, dist + 1});
        }
        System.out.println(min);
    }
}