import java.io.*;
import java.util.*;

public class Main {

    static final int loc = 200_000;
    static int[] methods = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[loc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], ctime = cur[1];

            if (cx == k) {
                System.out.println(ctime);
                return;
            }

            for (int i : methods) {
                int nx = 0;
                int ntime = ctime + 1;
                if (i == 1 || i == -1) nx = cx + i;
                if (i == 2) nx = cx * 2;
                if (nx < 0 || nx >= loc || visited[nx]) continue;
                visited[nx] = true;
                q.add(new int[]{nx, ntime});
            }
        }

    }
}