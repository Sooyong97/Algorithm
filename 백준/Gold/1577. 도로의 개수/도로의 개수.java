import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] hLoads, vLoads;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        hLoads = new boolean[N + 1][M + 1];
        vLoads = new boolean[N + 1][M + 1];
        dp = new long[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2) {
                hLoads[x1][Math.min(y1, y2)] = true;
            } else if (y1 == y2) {
                vLoads[Math.min(x1, x2)][y1] = true;
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 && j == 0) continue;

                if (i > 0 && !vLoads[i - 1][j]) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0 && !hLoads[i][j - 1]) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}