import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int island = 2;
    static int[][] map;
    static int minBridge = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Map<Integer, List<int[]>> islandEdges = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    private static void solve() {
        // 섬 나누기 및 테두리 저장
        lot();

        // 섬들 간 최단 거리 찾기
        findShortestDistance();

        // 결과 출력
        System.out.println(minBridge);
    }

    private static void lot() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = island;

        List<int[]> edgeList = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            boolean isEdge = false;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = island;
                    } else if (map[nx][ny] == 0) {
                        isEdge = true;
                    }
                }
            }

            if (isEdge) {
                edgeList.add(new int[]{cx, cy});
            }
        }

        islandEdges.put(island, edgeList);
        island++;
    }

    private static void findShortestDistance() {
        for (int key : islandEdges.keySet()) {
            bfsDistance(key, islandEdges.get(key));
        }
    }

    private static void bfsDistance(int fromIsland, List<int[]> edgeList) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();

        for (int[] edge : edgeList) {
            q.add(new int[]{edge[0], edge[1], 0});
            visited[edge[0]][edge[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny, dist + 1});
                    } else if (map[nx][ny] != fromIsland) {
                        minBridge = Math.min(minBridge, dist);
                        return;
                    }
                }
            }
        }
    }
}
