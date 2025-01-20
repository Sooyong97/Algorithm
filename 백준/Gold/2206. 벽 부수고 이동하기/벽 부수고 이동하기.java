import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new int[]{0, 0, 0, 1});

        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int dist = cur[3];

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny)) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][count]) {
                        visited[nx][ny][count] = true;
                        q.add(new int[]{nx, ny, count, dist + 1});
                    }
                    if (map[nx][ny] == 1 && count == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, 1, dist + 1});
                    }
                }
            }
        }
        System.out.println("-1");
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}