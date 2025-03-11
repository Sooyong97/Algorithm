import java.util.*;
import java.io.*;

public class Main {

    static int N, times;
    static int[] start, size;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void solve() {
        times = 0;
        while (true) {
            Queue<int[]> fish = findFish(start[0], start[1]);

            // 먹을 수 있는 먹이가 없다.
            if (fish.isEmpty()) {
                System.out.println(times);
                return;
            }

            // 먹을 수 있는 먹이가 있다.
            // 2-1 한마리 있다.
            if (fish.size() == 1) {
                oneFish(fish);
            }
            if (fish.size() > 1) {
                fishes(fish);
            }
        }
    }

    // 1. 먹을 수 있는 먹이 탐색.
    private static Queue<int[]> findFish(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Queue<int[]> fishes = new LinkedList<>();
        int dist = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[N][N];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], cdist = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if (map[nx][ny] > size[0]) continue;
                if (visited[nx][ny]) continue;

                q.add(new int[]{nx, ny, cdist + 1});
                visited[nx][ny] = true;
                if (map[nx][ny] != 0 && map[nx][ny] < size[0]) {
                    if (cdist + 1 < dist) {
                        dist = cdist + 1;
                        fishes.clear();
                        fishes.add(new int[]{nx, ny, dist});
                    }
                    else if (cdist + 1 == dist) fishes.add(new int[]{nx, ny, cdist + 1});
                }
            }
        }
        return fishes;
    }

    // 2. 먹을 수 있는 먹이가 있다.
    //  2-1 한마리다. 그곳으로 바로 간다.
    private static void oneFish(Queue<int[]> fish) {
        int[] cur = fish.poll();
        start[0] = cur[0];
        start[1] = cur[1];
        times += cur[2];
        growUp();
        map[start[0]][start[1]] = 0;
    }
    //  2.2 여러마리다. 가장 위 물고기. 거기서 또 여러마리. 가장 왼쪽.
    private static void fishes(Queue<int[]> fish) {
        int[] eat = new int[]{20, 20};
        int dist = fish.peek()[2];

        while (!fish.isEmpty()) {
            int[] cur = fish.poll();
            int x = cur[0], y = cur[1];
            if (x < eat[0]) {
                eat[0] = x;
                eat[1] = y;
            }
            else if (x == eat[0] && y < eat[1]) {
                eat[1] = y;
            }
        }

        start[0] = eat[0];
        start[1] = eat[1];
        times += dist;
        growUp();
        map[start[0]][start[1]] = 0;
    }

    // 상어 성장
    private static void growUp() {
        size[1]++;
        if (size[1] == size[0]) {
            size[0]++;
            size[1] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
        size = new int[]{2, 0};

        solve();
    }
}