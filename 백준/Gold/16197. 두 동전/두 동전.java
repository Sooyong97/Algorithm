import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] coins = new int[2][2];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    coins[idx][0] = i;
                    coins[idx][1] = j;
                    idx++;
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[][]> q = new LinkedList<>();
        q.add(new int[][]{{coins[0][0], coins[0][1]}, {coins[1][0], coins[1][1]}});
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            if (count > 10) {
                System.out.println("-1");
                return;
            }
            for (int num = 0; num < size; num++) {
                int[][] temp = q.poll();
                int x1 = temp[0][0], y1 = temp[0][1];
                int x2 = temp[1][0], y2 = temp[1][1];

                for (int i = 0; i < 4; i++) {
                    int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
                    int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

                    if (isWall(nx1, ny1)) {
                        nx1 = x1;
                        ny1 = y1;
                    }
                    if (isWall(nx2, ny2)) {
                        nx2 = x2;
                        ny2 = y2;
                    }

                    if (outOfBounds(nx1, ny1) ^ outOfBounds(nx2, ny2)) {
                        System.out.println(count);
                        return;
                    }
                    if (outOfBounds(nx1, ny1) && outOfBounds(nx2, ny2)) continue;

                    if (!visited[nx1][ny1][nx2][ny2]) {
                        visited[nx1][ny1][nx2][ny2] = true;
                        q.add(new int[][]{{nx1, ny1}, {nx2, ny2}});
                    }
                }
            }
            count++;
        }
        System.out.println("-1");
    }

    private static boolean isWall(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && map[x][y] == '#';
    }

    private static boolean outOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}