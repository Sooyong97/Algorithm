import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static final int MAX = 100_001;

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[MAX];
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == M) {
                if (time[cur] - 1 < minTime) {
                    minTime = time[cur] - 1;
                    count = 1;
                } else if (time[cur] - 1 == minTime) {
                    count++;
                }
                continue;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int next : nexts) {
                if (next >= 0 && next < MAX) {
                    if (time[next] == 0 || time[next] >= time[cur] + 1) {
                        time[next] = time[cur] + 1;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve();
    }
}