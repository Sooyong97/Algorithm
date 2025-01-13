import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] count;
    static int[] dx = {-1, 1, 0, 0};;
    static int[] dy = {0, 0, -1, 1};;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                count[i][j] = -1;
            }
        }
        
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) return 1;
        if (count[x][y] != -1) return count[x][y];

        count[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >=0 && nx < N && ny >= 0 && ny < M && map[nx][ny] < map[x][y]) {
                count[x][y] += dfs(nx, ny);
            }
        }
        return count[x][y];
    }
}
