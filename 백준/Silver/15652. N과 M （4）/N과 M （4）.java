import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];
        dfs(arr, 1);
        System.out.println(sb);
    }

    static void dfs(int[] arr, int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[depth - 1] > i) continue;
            arr[depth] = i;
            dfs(arr, depth + 1);
        }
    }
}
