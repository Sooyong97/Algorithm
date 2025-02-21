import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int counts = info.length;
        int INF = 10000;

        int[][][] dp = new int[counts + 1][n][m];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) Arrays.fill(row, INF);
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < counts; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dp[i][a][b] == INF) continue;

                    if (a + aTrace < n) {
                        dp[i + 1][a + aTrace][b] = Math.min(dp[i + 1][a + aTrace][b], dp[i][a][b] + aTrace);
                    }

                    if (b + bTrace < m) {
                        dp[i + 1][a][b + bTrace] = Math.min(dp[i + 1][a][b + bTrace], dp[i][a][b]);
                    }
                }
            }
        }

        int result = INF;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                result = Math.min(result, dp[counts][a][b]);
            }
        }

        return (result >= INF) ? -1 : result;
    }
}