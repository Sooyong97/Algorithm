import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int v;
        int w;
        int cost;

        public Node(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    static ArrayList<Node> graph;

    static private void BellmanFord(int n, int m, int start) {
        long[] D = new long[n + 1];
        Arrays.fill(D, Long.MAX_VALUE);
        D[start] = 0;

        // 최단거리
        for (int i = 0; i < n - 1; i++) {
            for (Node edge : graph) {
                if (D[edge.v] != Long.MAX_VALUE && D[edge.w] > D[edge.v] + edge.cost) {
                    D[edge.w] = D[edge.v] + edge.cost;
                }
            }
        }

        //음수 사이클 확인 (N번째 사이클)
        for (Node edge : graph) {
            if (D[edge.v] != Long.MAX_VALUE && D[edge.w] > D[edge.v] + edge.cost) {
                System.out.println("-1");
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(D[i] != Long.MAX_VALUE ? D[i] : "-1");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(v, w, cost));
        }

        BellmanFord(N, M, 1);
    }
}