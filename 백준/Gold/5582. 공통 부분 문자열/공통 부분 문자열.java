import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        int max = 0;
        
        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        System.out.println(max);
    }
}