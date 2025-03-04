import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDist, farthestNode;

    private static void dfs(int node, int dist) {
        if (visited[node]) return;
        visited[node] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (Node next : tree[node]) {
            if (!visited[next.v]) {
                dfs(next.v, dist + next.w);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(1, 0);

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }
}