import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<int[]>[] graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }

            virus(graph, n, c);
        }
    }

    private static void virus(List<int[]>[] graph, int computerNum, int start) {
        int[] D = new int[computerNum + 1];
        boolean[] visited = new boolean[computerNum + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            if (visited[curNode]) continue;
            visited[curNode] = true;

            for (int[] next : graph[curNode]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (D[nextNode] > curCost + nextCost) {
                    D[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, D[nextNode]});
                }
            }
        }

        int count = 0;
        int time = 0;
        for (int i = 1; i <= computerNum; i++) {
            if (D[i] != Integer.MAX_VALUE) {
                count++;
                time = Math.max(time, D[i]);
            }
        }

        System.out.println(count + " " + time);

    }
}
