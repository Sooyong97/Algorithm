import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static int[] start = new int[2], end = new int[2];
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    static class Loc implements Comparable<Loc> {
        int x, y, d, mirror;

        Loc(int x, int y, int d, int mirror) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Loc o) {
            return this.mirror - o.mirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        boolean found = false;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#') {
                    if (!found) {
                        start[0] = i;
                        start[1] = j;
                        found = true;
                    } else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        int[][][] visited = new int[N][N][4];
        for (int[][] v1 : visited)
            for (int[] v2 : v1)
                Arrays.fill(v2, Integer.MAX_VALUE);

        PriorityQueue<Loc> pq = new PriorityQueue<>();

        for (int d = 0; d < 4; d++) {
            pq.offer(new Loc(start[0], start[1], d, 0));
            visited[start[0]][start[1]][d] = 0;
        }

        while (!pq.isEmpty()) {
            Loc cur = pq.poll();

            int x = cur.x, y = cur.y, d = cur.d, mirror = cur.mirror;

            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            while (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != '*') {
                if (visited[nx][ny][d] <= mirror) break;
                visited[nx][ny][d] = mirror;

                if (nx == end[0] && ny == end[1]) return mirror;

                if (map[nx][ny] == '!') {
                    for (int nd = 0; nd < 4; nd++) {
                        if (nd == d || (dir[nd][0] == -dir[d][0] && dir[nd][1] == -dir[d][1])) continue;
                        if (visited[nx][ny][nd] > mirror + 1) {
                            visited[nx][ny][nd] = mirror + 1;
                            pq.offer(new Loc(nx, ny, nd, mirror + 1));
                        }
                    }
                }

                nx += dir[d][0];
                ny += dir[d][1];
            }
        }

        return -1;
    }
}