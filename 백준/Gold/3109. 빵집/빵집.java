import java.util.*;
import java.io.*;

public class Main {

    static int R, C, count;
    static char[][] map;
    static boolean[][] visited;
    static boolean isCompleted;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

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
            }
        }

        solve();
    }

    private static void solve() {
        count = 0;
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            isCompleted = false;
            dfs(i, 0);
        }

        System.out.println(count);
    }

    private static void dfs(int r, int c) {
        if (isCompleted) return;

        visited[r][c] = true;

        if (c == C - 1) {
            isCompleted = true;
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (map[nr][nc] == 'x') continue;
            if (visited[nr][nc]) continue;

            dfs(nr, nc);
        }

    }
}