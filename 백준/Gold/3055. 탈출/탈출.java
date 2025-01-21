import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') q.add(new int[]{i, j, 0});
                if (map[i][j] == '*') water.add(new int[]{i, j});
            }
        }

        solve();
    }

    private static void solve() {
        boolean[][] visited = new boolean[R][C];
        int[] start = q.peek();
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            // water flow
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                int[] cur = water.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                    map[nx][ny] = '*';
                    water.add(new int[]{nx, ny});
                }
            }

            // move
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], count = cur[2];
                if (map[x][y] == 'D') {
                    System.out.println(count);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == 'X' || map[nx][ny] == '*' || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        System.out.println("KAKTUS");
    }
}