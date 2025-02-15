import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(x, y, direction));
    }

    public static int solve(int x, int y, int d) {
        int count = 0;
        while (true) {
            if (map[x][y] == 0) { 
                map[x][y] = 2;
                count++;
            }

            if (checkAround(x, y)) {
                int nx = x - dx[d];
                int ny = y - dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) break;
                x = nx;
                y = ny;
            } else {
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static boolean checkAround(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) return false;
        }
        return true;
    }
}