import java.util.*;

public class Main {

    static int[] dp;
    static int[] numb = {0, 1, 2, 3};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] numbers = new int[T];

        for (int i = 0; i < T; i++) {
            numbers[i] = sc.nextInt();
        }

        int max = Arrays.stream(numbers).max().orElseThrow();

        dp = new int[max + 1];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = numb[i]; j <= max; j++) {
                dp[j] += dp[j - numb[i]];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[numbers[i]]);
        }

    }
}
