import java.io.*;
import java.util.*;

public class Main {

    static final int mod = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }

        System.out.println(dp[N]);
    }
}
