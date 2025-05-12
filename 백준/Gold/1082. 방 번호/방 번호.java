import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        
        String[] dp = new String[M + 1];
        
        for (int money = 0; money <= M; money++) {
            for (int digit = N - 1; digit >= 0; digit--) {
                if (prices[digit] <= money) {
                    String prev = dp[money - prices[digit]];
                    String current = (prev == null ? "" : prev) + digit;
                    
                    if (current.length() > 1 && current.charAt(0) == '0') continue;
                    
                    if (dp[money] == null || compareNumbers(current, dp[money]) > 0) {
                        dp[money] = current;
                    }
                }
            }
        }
        
        System.out.println(dp[M] == null ? "0" : dp[M]);
    }
    
    private static int compareNumbers(String a, String b) {
        if (a.length() != b.length()) {
            return Integer.compare(a.length(), b.length());
        }
        return a.compareTo(b);
    }
}