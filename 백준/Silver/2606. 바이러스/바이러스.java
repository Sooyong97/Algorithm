import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> dfs_result = new ArrayList<>();

    public static void dfs(int start) {
        visited[start] = true;
        dfs_result.add(start);
        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer_num = sc.nextInt();
        int N = sc.nextInt();

        graph = new ArrayList[computer_num + 1];

        for (int i = 1; i <= computer_num; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        sc.close();

        visited = new boolean[computer_num + 1];
        dfs(1);

        System.out.println(dfs_result.size() - 1);

    }
}
