import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static int R, C, maxCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[map[0][0] - 65] = true;
        dfs(0, 0, 1, visited);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[map[nx][ny] - 65]) {
                visited[map[nx][ny] - 65] = true;
                dfs(nx, ny, count + 1, visited);
                visited[map[nx][ny] - 65] = false;
            }
        }
    }
}