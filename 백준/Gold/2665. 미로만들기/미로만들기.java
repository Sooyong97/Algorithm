import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] openDoor;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        openDoor = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
                openDoor[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(openDoor[N - 1][N - 1]);
    }

    private static void bfs() {
        int N = map.length;
        Deque<int[]> dq = new LinkedList<>();
        openDoor[0][0] = 0;
        dq.add(new int[]{0, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && openDoor[nx][ny] > openDoor[x][y]) {
                        openDoor[nx][ny] = openDoor[x][y];
                        dq.addFirst(new int[]{nx, ny});
                    }
                    if (map[nx][ny] == 0 && openDoor[nx][ny] > openDoor[x][y] + 1) {
                        openDoor[nx][ny] = openDoor[x][y] + 1;
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
