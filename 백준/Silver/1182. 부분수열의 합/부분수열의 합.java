import java.util.*;
import java.io.*;

public class Main {

    static int[] nums;
    static int N, S, count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        nums = new int[N];
        visited = new boolean[N];
        count = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void dfs(int i, int sum) {
        if (i == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(i + 1, sum + nums[i]);
        dfs(i + 1, sum);
    }
}
