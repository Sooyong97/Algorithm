import java.util.Scanner;

public class Main {

    private static void sum_of_squares(int N) {
    int[] dp = new int[N + 1];
    for (int i = 1; i <= N; i++) {
        dp[i] = i; // 최악의 경우 1^2만 사용
        for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    System.out.println(dp[N]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sum_of_squares(N);

    }
}
