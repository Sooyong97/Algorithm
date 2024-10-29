import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Integer> dfsResult = new ArrayList<>();
    static ArrayList<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 정점의 개수
        int m = sc.nextInt();  // 간선의 개수
        int start = sc.nextInt();  // 탐색을 시작할 정점의 번호

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 작은 번호의 정점을 우선 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[n + 1];
        dfs(start);

        // BFS 수행
        visited = new boolean[n + 1];
        bfs(start);

        // 결과 출력
        for (int node : dfsResult) {
            System.out.print(node + " ");
        }
        System.out.println();
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }
    }

    // DFS 함수 (재귀)
    public static void dfs(int node) {
        visited[node] = true;
        dfsResult.add(node);
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // BFS 함수
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.add(node);

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}