import java.util.Scanner;

public class Main {

    public static int[] parent;
    public static int[] rank;

    // 루트 노드를 찾고, 경로 압축을 통해 트리의 높이를 줄임
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 두 집합을 합침 (랭크 기반 유니온)
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // 랭크가 높은 쪽이 부모가 되도록 설정
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 부모와 랭크 배열 초기화
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i; // 자기 자신을 부모로 초기화
            rank[i] = 0;   // 초기 랭크는 0
        }

        for (int i = 0; i < m; i++) {
            int action = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (action == 0) {
                union(a, b);
            } else if (action == 1) {
                // 같은 집합에 속하는지 확인
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        sc.close();
    }
}
