import java.io.*;
import java.util.*;

class Main {
    static class Point implements Comparable<Point> {
        int x, y, t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            return this.t - o.t;
        }

    }

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < M; j++) {
                if (in.charAt(j) == '/') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        solve();
    }

    public static boolean isTurned(int x, int y, int d) {
        if (d == 0) return map[x - 1][y] == 0;
        else if (d == 1) return map[x][y] == 1;
        else if (d == 2) return map[x][y - 1] == 0;
        else return map[x - 1][y - 1] == 1;
    }

    public static void solve() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        dp[0][0] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.t;

            if (x == N && y == M) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
                int nextT = isTurned(x, y, d) ? t + 1 : t;

                if (dp[nx][ny] <= nextT) continue;
                dp[nx][ny] = nextT;
                pq.add(new Point(nx, ny, nextT));
            }
        }

        if (dp[N][M] == Integer.MAX_VALUE) {
            System.out.println("NO SOLUTION");
        } else {
            System.out.println(dp[N][M]);
        }
    }
}