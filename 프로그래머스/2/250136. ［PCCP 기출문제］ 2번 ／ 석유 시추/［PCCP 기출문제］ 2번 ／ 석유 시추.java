import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;

        visited = new boolean[rows][cols];
        count = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        int max_val = Arrays.stream(count).max().orElseThrow();
        
        return max_val;
    }

    private static void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> yCoords = new HashSet<>();
        int size = 0;

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            size++;
            yCoords.add(cy);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length &&
                    land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        for (int yCoord : yCoords) {
            count[yCoord] += size;
        }
    }
}