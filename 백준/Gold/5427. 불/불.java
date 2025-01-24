import java.util.*;
import java.io.*;

public class Main {

    static int w, h;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            q.clear();
            fire.clear();

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') q.add(new int[]{i, j, 0});
                    if (map[i][j] == '*') fire.add(new int[]{i, j});
                }
            }

            solve();
        }
    }

    private static void solve() {
        boolean[][] visited = new boolean[h][w];

        while (!q.isEmpty()) {
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] cur = fire.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (map[nx][ny] == '0' || map[nx][ny] == '#' || map[nx][ny] == '*') continue;
                    map[nx][ny] = '*';
                    fire.add(new int[]{nx, ny});
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], count = cur[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        System.out.println(count + 1);
                        return;
                    }

                    if (map[nx][ny] == '#' || map[nx][ny] == '*' || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
