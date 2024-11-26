import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int root;
    static boolean[] visited;
    static int answer;
    static int delete;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        root = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == -1){
                root = i;
            } else{
                graph[i].add(num);
                graph[num].add(i);
            }
        }

        delete = sc.nextInt();

        if (delete == root){
            System.out.println(0);
            return;
        }

        answer = 0;
        dfs(root);
        System.out.println(answer);
    }

    static void dfs(int root){
        visited[root] = true;
        int nodes = 0;

        for (int node : graph[root]) {
            if (!visited[node] && node != delete) {
                nodes++;
                dfs(node);
            }
        }
        if (nodes == 0){
            answer++;
        }
    }
}
