import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cheese());
    }

    public static int cheese() {
        int days = 0;

        while (true) {
            boolean[][] visited = new boolean[N][M];
            Queue<int[]> airQueue = new LinkedList<>();
            airQueue.add(new int[]{0, 0});
            visited[0][0] = true;

            while (!airQueue.isEmpty()) {
                int[] cur = airQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        airQueue.add(new int[]{nx, ny});
                    }
                }
            }

            boolean melted = false;
            List<int[]> toMelt = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int airCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny]) {
                                airCount++;
                            }
                        }
                        if (airCount >= 2) {
                            toMelt.add(new int[]{i, j});
                            melted = true;
                        }
                    }
                }
            }

            for (int[] cheese : toMelt) {
                map[cheese[0]][cheese[1]] = 0;
            }

            if (!melted) {
                return days;
            }

            days++;
        }
    }
}