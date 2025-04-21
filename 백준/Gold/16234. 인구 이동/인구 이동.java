import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void solve() {
        int days = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean isMoved = false;

            List<List<int[]>> unions = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j, visited);
                        if (union.size() > 1) {
                            unions.add(union);
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break;

            for (List<int[]> union : unions) {
                int sum = 0;
                for (int[] pos : union) {
                    sum += map[pos[0]][pos[1]];
                }
                int avg = sum / union.size();
                for (int[] pos : union) {
                    map[pos[0]][pos[1]] = avg;
                }
            }

            days++;
        }

        System.out.println(days);
    }

    private static List<int[]> bfs(int x, int y, boolean[][] visited) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    q.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return union;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }
}