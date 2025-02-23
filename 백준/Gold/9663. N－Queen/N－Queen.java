import java.io.*;

public class Main {
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve(N);
    }

    private static void solve(int n) {
        count = 0;
        int[] queens = new int[N];
        nQueens(queens, 0);
        System.out.println(count);
    }

    private static void nQueens(int[] queens, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            if (checkQueens(queens, depth)) {
                nQueens(queens, depth + 1);
            }
        }
    }

    private static boolean checkQueens(int[] queens, int depth) {
        for (int i = 0; i < depth; i++) {
            if (queens[i] == queens[depth]) return false;
            if (Math.abs(queens[i] - queens[depth]) == Math.abs(i - depth)) return false;
        }
        return true;
    }
}