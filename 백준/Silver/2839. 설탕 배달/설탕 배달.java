import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 3; i <= n; i++) {
            if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}