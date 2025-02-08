import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                int num = s[j].charAt(0) - 0;
                if (num == 87) map[i][j] = -1;
                else map[i][j] = 1;
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[N][M];
                    int res = bfs(j, i);
                    if (res > max) {
                        max = res;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        int maxMove = -1;
        visited[y][x] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            int move = pos[2];

            if (move > maxMove) {
                maxMove = move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) continue;

                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }

        return maxMove;

    }
}