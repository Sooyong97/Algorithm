import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, mirrors, direction;

        public Node(int x, int y, int mirrors, int direction) {
            this.x = x;
            this.y = y;
            this.mirrors = mirrors;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        List<int[]> cList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'C') {
                    cList.add(new int[]{i, j});
                }
            }
        }

        bfs(cList.get(0), cList.get(1));
    }

    private static void bfs(int[] start, int[] end) {
        int[][] D = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            pq.add(new Node(start[0], start[1], 0, i));
        }
        D[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, y = cur.y, mirrors = cur.mirrors, direction = cur.direction;

            if (D[x][y] < mirrors) continue;

            int nx = x, ny = y;
            while (true) {
                nx += dx[direction];
                ny += dy[direction];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] == '*') break;

                if (D[nx][ny] > mirrors) {
                    D[nx][ny] = mirrors;
                    pq.add(new Node(nx, ny, mirrors, direction));
                }
            }

            for (int i = 0; i < 4; i++) {
                if (i == direction) continue;

                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || ty < 0 || tx >= M || ty >= N || map[tx][ty] == '*') continue;

                if (D[tx][ty] > mirrors + 1) {
                    D[tx][ty] = mirrors + 1;
                    pq.add(new Node(tx, ty, mirrors + 1, i));
                }
            }
        }

        System.out.println(D[end[0]][end[1]]);
    }
}