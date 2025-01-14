import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h + 2][w + 2];
            List<int[]> prisoners = new ArrayList<>();

            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = s.charAt(j - 1);
                    if (map[i][j] == '$') {
                        prisoners.add(new int[]{i, j});
                    }
                }
            }

            int[][] fromStart = bfs(map, 0, 0);
            int[][] fromP1 = bfs(map, prisoners.get(0)[0], prisoners.get(0)[1]);
            int[][] fromP2 = bfs(map, prisoners.get(1)[0], prisoners.get(1)[1]);

            int minDoors = Integer.MAX_VALUE;

            for (int i = 0; i <= h + 1; i++) {
                for (int j = 0; j <= w + 1; j++) {
                    if (map[i][j] == '*') continue;
                    int total = fromStart[i][j] + fromP1[i][j] + fromP2[i][j];
                    if (map[i][j] == '#') total -= 2;
                    minDoors = Math.min(minDoors, total);
                }
            }

            System.out.println(minDoors);
        }
    }

    private static int[][] bfs(char[][] map, int x, int y) {
        int h = map.length;
        int w = map[0].length;
        int[][] doors = new int[h][w];
        for (int[] row : doors) Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{x, y});
        doors[x][y] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] != '*') {
                    int newDoors = doors[cx][cy] + (map[nx][ny] == '#' ? 1 : 0);
                    if (newDoors < doors[nx][ny]) {
                        doors[nx][ny] = newDoors;
                        if (map[nx][ny] == '#') {
                            dq.addLast(new int[]{nx, ny});
                        } else {
                            dq.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return doors;
    }
}