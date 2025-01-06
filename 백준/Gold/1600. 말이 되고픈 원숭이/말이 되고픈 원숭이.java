import java.util.*;
import java.io.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] horseDx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] horseDy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, K, 0});
        visited[x][y][K] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ck = cur[2];
            int moves = cur[3];

            if (cx == H - 1 && cy == W - 1) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][ck] && map[nx][ny] == 0) {
                    q.add(new int[]{nx, ny, ck, moves + 1});
                    visited[nx][ny][ck] = true;
                }
            }

            if (ck > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cx + horseDx[i];
                    int ny = cy + horseDy[i];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][ck - 1] && map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny, ck - 1, moves + 1});
                        visited[nx][ny][ck - 1] = true;
                    }
                }
            }
        }
        return -1;
    }
}