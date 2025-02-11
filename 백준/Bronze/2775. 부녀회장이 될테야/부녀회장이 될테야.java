import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            solve(K, N);
        }
    }

    public static void solve(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[K][N]);
    }
}
