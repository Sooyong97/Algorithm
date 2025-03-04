import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static void dfs (int start, boolean[] visited, int dist) {
        if (visited[start]) return;
        visited[start] = true;
        for (Node node : tree[start]) {
            int nextNode = node.v;
            int weight = node.w;
            if (visited[nextNode]) continue;
            dfs(nextNode, visited, dist + weight);
        }
        maxDist = Math.max(maxDist, dist);
    }

    static List<Node>[] tree;
    static int maxDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        maxDist = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            dfs(i, visited, 0);
        }

        System.out.println(maxDist);
    }
}