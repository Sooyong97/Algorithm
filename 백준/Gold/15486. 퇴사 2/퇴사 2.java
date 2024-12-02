import java.util.*;

public class Main {

    static int[][] schedule;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        schedule = new int[n + 2][2];
        for (int i = 1; i <= n; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        int dp[] = new int[n + 2];
        dp[0] = 0;

        int max = -1;
        for (int i = 0; i <= n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int next = i + schedule[i][0];
            if (next < n + 2) {
                dp[next] = Math.max(dp[next], max + schedule[i][1]);
            }
        }

        System.out.println(dp[n+1]);
    }
}
