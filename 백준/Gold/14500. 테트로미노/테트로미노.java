import java.io.*;
import java.util.*;

public class Main {

    static int N, M, max;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tetromino();
    }

    private static void tetromino() {
        max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, visited, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, boolean[][] visited, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (visited[nx][ny]) continue;

            if (count == 2) {
                visited[nx][ny] = true;
                dfs(x, y, visited, count + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, visited, count + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
