import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int blindSpot = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> cameras = new ArrayList<>();
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

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
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cameras.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        System.out.println(blindSpot);
    }

    static void dfs(int idx) {
        if (idx == cameras.size()) {
            blindSpot = Math.min(blindSpot, countBlindSpot());
            return;
        }

        int[] camera = cameras.get(idx);
        int type = map[camera[0]][camera[1]];
        int[][] directionSet = getCameraDirections(type);

        for (int[] directions : directionSet) {
            List<int[]> modified = new ArrayList<>();

            for (int d : directions) {
                modified.addAll(checkPlace(camera[0], camera[1], dir[d]));
            }

            dfs(idx + 1);

            // 백트래킹
            for (int[] pos : modified) {
                map[pos[0]][pos[1]] = 0;
            }
        }
    }

    static List<int[]> checkPlace(int x, int y, int[] d) {
        List<int[]> modified = new ArrayList<>();
        int nx = x + d[0];
        int ny = y + d[1];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (map[nx][ny] == 6) break; // 벽
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1; // 감시 표시
                modified.add(new int[]{nx, ny});
            }
            nx += d[0];
            ny += d[1];
        }
        return modified;
    }

    static int countBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    static int[][] getCameraDirections(int type) {
        switch (type) {
            case 1:
                return new int[][]{{0}, {1}, {2}, {3}};
            case 2:
                return new int[][]{{0, 2}, {1, 3}};
            case 3:
                return new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}};
            case 4:
                return new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
            case 5:
                return new int[][]{{0, 1, 2, 3}};
            default:
                return new int[0][];
        }
    }
}