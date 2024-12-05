import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;

    private static void bfs(int x, int y, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && grid[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] grid = new int[M][N];
            boolean[][] visited = new boolean[M][N];

            for (int j = 0; j < C; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[x][y] = 1;
            }

            int count = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (grid[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k, grid, visited);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}