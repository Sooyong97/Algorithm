import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static final int maxCount = 10;
    static int minCount = Integer.MAX_VALUE;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static int[] red;
    static int[] blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') red = new int[]{i, j};
                if (map[i][j] == 'B') blue = new int[]{i, j};
            }
        }

        solve();
    }

    static void solve() {
        dfs(red, blue, 1);
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        System.out.println(minCount);
    }

    static void dfs(int[] red, int[] blue, int count) {
        if (count > minCount) return;
        if (count > maxCount) return;

        for (int i = 0; i < 4; i++) {
            int[][] nextBalls = move(red, blue, i);
            if (nextBalls[1][0] == -1) continue;
            if (nextBalls[0][0] == -1) {
                minCount = Math.min(count, minCount);
                continue;
            }
            dfs(nextBalls[0], nextBalls[1], count + 1);
        }
    }

    static int[][] move(int[] red, int[] blue, int dir) {
        int[][] nextBalls = new int[2][2];
        int rx = red[0], ry = red[1];
        int bx = blue[0], by = blue[1];

        boolean redInHole = false, blueInHole = false;

        int[] movedRed = moveOne(rx, ry, dir);
        rx = movedRed[0];
        ry = movedRed[1];
        redInHole = movedRed[2] == 1;

        int[] movedBlue = moveOne(bx, by, dir);
        bx = movedBlue[0];
        by = movedBlue[1];
        blueInHole = movedBlue[2] == 1;

        // 공이 겹쳤을 때
        if (rx == bx && ry == by && !redInHole && !blueInHole) {
            // 누가 더 멀리 갔는지 비교해서, 나중에 온 공을 한 칸 뒤로
            int redDist = Math.abs(red[0] - rx) + Math.abs(red[1] - ry);
            int blueDist = Math.abs(blue[0] - bx) + Math.abs(blue[1] - by);
            if (redDist > blueDist) {
                rx -= direction[dir][0];
                ry -= direction[dir][1];
            } else {
                bx -= direction[dir][0];
                by -= direction[dir][1];
            }
        }

        if (redInHole) nextBalls[0] = new int[]{-1, -1};
        else nextBalls[0] = new int[]{rx, ry};
        if (blueInHole) nextBalls[1] = new int[]{-1, -1};
        else nextBalls[1] = new int[]{bx, by};

        return nextBalls;
    }

    // 공 하나 이동
    static int[] moveOne(int x, int y, int dir) {
        while (true) {
            int nx = x + direction[dir][0];
            int ny = y + direction[dir][1];
            if (map[nx][ny] == '#') break;
            if (map[nx][ny] == 'O') return new int[]{nx, ny, 1};
            x = nx;
            y = ny;
        }
        return new int[]{x, y, 0};
    }
}