import java.io.*;
import java.util.*;

public class Main {
    static final int max = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] times = new int[max];
        int[] prev = new int[max];

        Arrays.fill(times, Integer.MAX_VALUE);
        times[start] = 0;
        prev[start] = -1;

        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) break;

            int[] nexts = {cur + 1, cur - 1, cur * 2};
            for (int next : nexts) {
                if (next >= 0 && next < max && times[next] > times[cur] + 1) {
                    times[next] = times[cur] + 1;
                    prev[next] = cur;
                    q.add(next);
                }
            }
        }
        System.out.println(times[end]);

        List<Integer> path = new ArrayList<>();
        for (int i = end; i != -1; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        for (int p : path) {
            System.out.print(p + " ");
        }
    }
}