import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main{
    static int n, m;
    static int[] arr;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int left = parseInt(st.nextToken());
        int right = parseInt(st.nextToken());
        
        m = parseInt(br.readLine());
       
        dp = new int[m][n + 1][n + 1];
        arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++)
                Arrays.fill(dp[i][j], -1);
        }
        
        System.out.println(dfs(0, left, right));
    }
    
    static int dfs(int idx, int left, int right) {
        if (idx == m) return 0;
        
        if (dp[idx][left][right] == -1) {
            dp[idx][left][right] = Math.min(
                Math.abs(left - arr[idx]) + dfs(idx + 1, arr[idx], right),
                Math.abs(right - arr[idx]) + dfs(idx + 1, left, arr[idx])
            );
        }
        return dp[idx][left][right];
    }
}