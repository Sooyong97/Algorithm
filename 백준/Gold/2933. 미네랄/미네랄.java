import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean isLeft = true;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            throwBar(isLeft, height);
            isLeft = !isLeft;
        }

        printMap();
    }

    static void throwBar(boolean isLeft, int height) {
        int h = r - height;
        int start = isLeft ? 0 : c - 1;
        int end = isLeft ? c : -1;
        int step = isLeft ? 1 : -1;

        boolean broken = false;
        for (int j = start; j != end; j += step) {
            if (map[h][j] == 'x') {
                map[h][j] = '.';
                broken = true;
                break;
            }
        }

        if (broken) cleanCluster();
    }

    static void cleanCluster() {
        boolean[][] visited = new boolean[r][c];

        // 바닥에 붙은 클러스터
        for (int j = 0; j < c; j++) {
            if (map[r - 1][j] == 'x') bfs(r - 1, j, visited);
        }

        dropMinerals(visited);
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void dropMinerals(boolean[][] visited) {
        List<int[]> cluster = new ArrayList<>();
        boolean[][] clusterVisited = new boolean[r][c];
        boolean found = false;

        for (int i = r - 1; i >= 0 && !found; i--) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    findCluster(i, j, clusterVisited, cluster);
                    found = true;
                    break;
                }
            }
        }

        if (!found) return; // 떨어질 덩어리가 없으면 종료

        // 기존 위치 지움
        for (int[] pos : cluster) {
            map[pos[0]][pos[1]] = '.';
        }

        // 얼마나 떨어질 수 있는지 계산
        int minDrop = Integer.MAX_VALUE;
        for (int[] pos : cluster) {
            int x = pos[0], y = pos[1];
            int drop = 0;
            while (true) {
                int nx = x + drop + 1;
                if (nx >= r || (map[nx][y] == 'x' && !clusterVisited[nx][y])) break;
                drop++;
            }
            minDrop = Math.min(minDrop, drop);
        }

        // 아래에서 위로 정렬해서 떨어뜨리기
        cluster.sort((a, b) -> b[0] - a[0]);
        for (int[] pos : cluster) {
            int nx = pos[0] + minDrop;
            int ny = pos[1];
            map[nx][ny] = 'x';
        }
    }

    static void findCluster(int x, int y, boolean[][] visited, List<int[]> cluster) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        cluster.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (!visited[nx][ny] && map[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cluster.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}