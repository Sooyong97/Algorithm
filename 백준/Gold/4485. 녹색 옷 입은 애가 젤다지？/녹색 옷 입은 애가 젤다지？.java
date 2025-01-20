import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int dijkstra(int[][] map) {
        int N = map.length;
        int[][] D = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE);
        }
        D[0][0] = map[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, map[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (D[nx][ny] > cost + map[nx][ny]) {
                    D[nx][ny] = cost + map[nx][ny];
                    pq.add(new int[]{nx, ny, D[nx][ny]});
                }
            }
        }

        return D[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("Problem " + tc + ": " + dijkstra(map));
            tc++;
        }
    }
}