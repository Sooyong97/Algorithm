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

        cheese();
    }

    public static void cheese() {
        int days = 0;
        while (true) {
            boolean[][] visitedEmpty = new boolean[N][M];
            boolean[][] visitedMelted = new boolean[N][M];
            boolean allMelted = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 && !visitedEmpty[i][j]) {
                        findEmpty(i, j, visitedEmpty);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visitedMelted[i][j]) {
                        meltCheese(i, j, visitedMelted);
                        allMelted = false;
                    }
                }
            }

            if (allMelted) {
                System.out.println(days);
                break;
            } else {
                days++;
            }
        }
    }


    public static void findEmpty(int x, int y, boolean[][] visitedEmpty) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(new int[]{x, y});
        q2.add(new int[]{x, y});
        visitedEmpty[x][y] = true;
        int status = 2;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx == 0 || nx == N - 1 || ny == 0 || ny == M - 1) {
                    status = 0;
                }
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1 && !visitedEmpty[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    q2.add(new int[]{nx, ny});
                    visitedEmpty[nx][ny] = true;
                }
            }
        }
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            map[cur[0]][cur[1]] = status;
        }
    }

    public static void meltCheese(int x, int y, boolean[][] visitedMelted) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(new int[]{x, y});
        visitedMelted[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < N && ny >=0 && ny < M && map[nx][ny] == 0) count++;
                if (nx >= 0 && nx < N && ny >=0 && ny < M && map[nx][ny] == 1 && !visitedMelted[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visitedMelted[nx][ny] = true;
                }
            }
            if (count >= 2) q2.add(cur);
        }
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            map[cur[0]][cur[1]] = 0;
        }
    }
}
