import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] mapBroken;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        mapBroken = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
                mapBroken[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(mapBroken[N - 1][M - 1]);
    }

    private static void bfs() {
        Deque<int[]> dq = new LinkedList<>();
        mapBroken[0][0] = 0;
        dq.add(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && mapBroken[nx][ny] > mapBroken[x][y]) {
                        mapBroken[nx][ny] = mapBroken[x][y];
                        dq.addFirst(new int[]{nx, ny});
                    }
                    if (map[nx][ny] == 1 && mapBroken[nx][ny] > mapBroken[x][y] + 1) {
                        mapBroken[nx][ny] = mapBroken[x][y] + 1;
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}