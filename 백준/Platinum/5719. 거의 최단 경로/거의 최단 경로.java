import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int n, m;
    static int[] D;
    static boolean[][] exRoute;
    static List<Node>[] list;
    static List<Integer>[] removeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = null;
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list = new ArrayList[n];
            removeList = new ArrayList[n];
            D = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
                removeList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[u].add(new Node(v, cost));
            }

            exRoute = new boolean[n][n];
            dijkstra(s);
            removeMinRouteVertex(s, d);
            dijkstra(s);
            int secondMinimum = D[d] == Integer.MAX_VALUE ? -1 : D[d];
            System.out.println(secondMinimum);
        }

    }

    static void removeMinRouteVertex(int s, int d) {
        if (s == d) return;
        for (int nxt : removeList[d]) {
            if (!exRoute[nxt][d]) {
                exRoute[nxt][d] = true;
                removeMinRouteVertex(s, nxt);
            }
        }
    }

    static void dijkstra(int s) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(D, Integer.MAX_VALUE);
        D[s] = 0;
        q.add(new Node(s, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.to;
            if (node.w > D[cur]) continue;
            for (Node nxt : list[cur]) {
                if (exRoute[cur][nxt.to]) continue;
                if (D[nxt.to] > D[cur] + nxt.w) {
                    D[nxt.to] = D[cur] + nxt.w;
                    removeList[nxt.to] = new ArrayList<>();
                    removeList[nxt.to].add(cur);
                    q.add(new Node(nxt.to, D[nxt.to]));
                } else if (D[nxt.to] == D[cur] + nxt.w) {
                    removeList[nxt.to].add(cur);
                }
            }
        }
    }
}