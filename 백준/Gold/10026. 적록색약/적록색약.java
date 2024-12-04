import java.util.*;

public class Main {

    static char[][] grid;
    static char[][] grid_color;
    static boolean[][] visited;
    static boolean[][] visited_color;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        grid = new char[N][N];
        grid_color = new char[N][N];
        visited = new boolean[N][N];
        visited_color = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                if (line.charAt(j) == 'G') {
                    grid_color[i][j] = 'R';
                } else {
                    grid_color[i][j] = line.charAt(j);
                }
            }
        }

        int count = 0;
        int count_color = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, grid[i][j], grid, visited);
                    count++;
                }
                if (!visited_color[i][j]) {
                    bfs(i, j, grid_color[i][j], grid_color, visited_color);
                    count_color++;
                }
            }
        }

        System.out.println(count + " " + count_color);

    }

    private static void bfs(int x, int y, char c, char[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && grid[nx][ny] == c) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}