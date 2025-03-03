import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        int[] weights = new int[N+1];
        int[] values = new int[N+1];
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken()); // 무게
            values[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i <= N; i++) { // i번째 물건까지 고려
            for (int j = 0; j <= K; j++) { // 현재 배낭의 허용 무게
                if (weights[i] > j) { // 넣을 수 없는 경우
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}