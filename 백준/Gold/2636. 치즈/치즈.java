import java.io.*;
import java.util.*;

public class Main {

    static int n, m, days, counts;
    static boolean noCheese;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    private static void solve() {
        noCheese = false;
        days = 0;
        counts = 0;
        while(!noCheese) {
            findHole();
            meltCheese();
        }
        System.out.println(days);
        System.out.println(counts);
    }

    private static void findHole(){
        int numCheese = 0;
        boolean checkCheese = false;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                if (map[nx][ny] == 2) map[nx][ny] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) map[i][j] = 2;
                if (map[i][j] == 1) {
                    numCheese++;
                    checkCheese = true;
                }
            }
        }
        if (!checkCheese) noCheese = true;
        else counts = numCheese;
    }

    private static void meltCheese() {
        if (noCheese) return;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && check(i, j)) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = 0;
        }

        days++;
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (map[nx][ny] == 0) return true;
        }
        return false;
    }
}