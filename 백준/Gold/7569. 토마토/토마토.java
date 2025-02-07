import java.util.*;
import java.io.*;

public class Main {

    static int N, M, H, size, wall;
    static int[][][] map;
    static Queue<int[]> tomatos = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][M][N];
        wall = 0;
        size = N * M * H;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == -1) wall++;
                    if (map[i][j][k] == 1) tomatos.add(new int[]{i, j, k});
                }
            }
        }

        if (size - wall - tomatos.size() == 0) {
            System.out.println(0);
        }
        else solve();

    }

    private static void solve() {
        boolean[][][] visited = new boolean[H][M][N];
        int days = 0;
        int riped = 0;

        while (!tomatos.isEmpty()) {
            int time = tomatos.size();
            for (int t = 0; t < time; t++) {
                int[] tomato = tomatos.poll();
                int z = tomato[0], y = tomato[1], x = tomato[2];

                if (visited[z][y][x]) continue;
                visited[z][y][x] = true;

                riped++;

                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                    if (map[nz][ny][nx] != 0 || visited[nz][ny][nx]) continue;
                    map[nz][ny][nx] = 1;
                    tomatos.add(new int[]{nz, ny, nx});
                }
            }
            days++;
        }
        if (size - wall - riped > 0) System.out.println(-1);
        else System.out.println(days - 1);
    }
}