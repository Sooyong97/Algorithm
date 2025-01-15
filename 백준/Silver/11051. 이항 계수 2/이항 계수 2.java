import java.util.*;
import java.io.*;

public class Main {

    static final int div = 10007;

    private static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        solve(N, K);
    }

    private static void solve(int N, int K) {
        int[][] pascalTriangle = new int[N + 1][N + 1];
        pascalTriangle[0][0] = 1;
        pascalTriangle[1][0] = 1;
        pascalTriangle[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) pascalTriangle[i][j] = 1;
                else pascalTriangle[i][j] = (pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]) % div;
            }
        }
        System.out.println(pascalTriangle[N][K]);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
