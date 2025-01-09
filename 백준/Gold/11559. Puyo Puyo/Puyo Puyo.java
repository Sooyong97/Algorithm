import java.util.*;
import java.io.*;

public class Main {

    static char[][] map = new char[12][6];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        while (true) {
            if (!solve()) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }

    private static boolean solve() {
        boolean anyDeleted = false;
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                char c = map[i][j];
                if (c != '.') {
                    if (bfs(i, j, c)) {
                        anyDeleted = true;
                    }
                }
            }
        }
        if (anyDeleted) {
            down();
        }
        return anyDeleted;
    }

    private static boolean bfs(int i, int j, char c) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int num = 1;
        q.add(new int[]{i, j});
        q2.add(new int[]{i, j});
        boolean[][] visited = new boolean[12][6];
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && map[nx][ny] == c) {
                    q.add(new int[]{nx, ny});
                    q2.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    num++;
                }
            }
        }

        if (num >= 4) {
            while (!q2.isEmpty()) {
                int[] cur = q2.poll();
                map[cur[0]][cur[1]] = '.';
            }
            return true;
        }

        return false;
    }

    private static void down() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i > 0; i--) {
                if (map[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}