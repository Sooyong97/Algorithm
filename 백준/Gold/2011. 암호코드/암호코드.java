import java.io.*;

public class Main {

    static final int mod = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        long[] dp = new long[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] != 0) {
                dp[i + 1] = dp[i] % mod;
            }

            if (canMake2digit(arr[i - 1], arr[i])) {
                dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod;
            }
        }

        System.out.println(dp[len] % mod);
    }

    private static boolean canMake2digit(int a, int b) {
        int num = a * 10 + b;
        return num >= 10 && num <= 26;
    }
}