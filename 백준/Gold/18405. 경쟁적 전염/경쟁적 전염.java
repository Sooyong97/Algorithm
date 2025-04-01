import java.io.*;
import java.util.*;

public class Main {

    static int N, K, S;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    private static void solve(int x, int y, PriorityQueue<int[]> pq) {
        while(S-- > 0) {
            int pqSize = pq.size();
            PriorityQueue<int[]> nextPq = new PriorityQueue<>(pq.comparator());

            for (int i = 0; i < pqSize; i++) {
                int[] cur = pq.poll();
                int virus = cur[0];
                int cx = cur[1], cy = cur[2];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (map[nx][ny] != 0) continue;
                    map[nx][ny] = virus;
                    nextPq.add(new int[]{virus, nx, ny});
                }
            }
            pq = nextPq;
        }
        System.out.println(map[x - 1][y - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new int[]{map[i][j], i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        solve(x, y, pq);

    }
}