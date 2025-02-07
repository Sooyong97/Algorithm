import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[N][M];
        solve(map, visited, 0);
        System.out.println(max);
    }

    private static void solve(int[][] map, boolean[][] visited, int count) {
        if (count == 3) {
            max = Math.max(max, virus(map));
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 || map[i][j] == 2 || visited[i][j]) continue;
                visited[i][j] = true;
                map[i][j] = 1;
                solve(map, visited, count + 1);
                visited[i][j] = false;
                map[i][j] = 0;
            }
        }
    }

    private static int virus(int[][] map) {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) count += bfs(i, j, map, visited);
            }
        }
        return count;
    }

    private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int count = 1;
        boolean checkVirus = false;

        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 1 || visited[nx][ny]) continue;
                if (map[nx][ny] == 2) {
                    checkVirus = true;
                    continue;
                }
                visited[nx][ny] = true;
                count++;
                q.add(new int[]{nx, ny});
            }
        }
        return checkVirus ? 0 : count;
    }
}