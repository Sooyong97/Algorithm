import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;  // 부모 노드 저장
    static int[] size;    // 각 집합의 크기 저장
    static Map<String, Integer> nameToId;  // 이름을 정수 ID로 매핑

    // 부모 노드 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);  // 경로 압축
    }

    // 두 집합 합치기
    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            size[x] += size[y];
        }

        return size[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n*2];
            size = new int[n*2];
            nameToId = new HashMap<>();

            for (int i = 0; i < n*2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int idx = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                // 이름을 ID로 변환
                if (!nameToId.containsKey(f1)) {
                    nameToId.put(f1, idx++);
                }
                if (!nameToId.containsKey(f2)) {
                    nameToId.put(f2, idx++);
                }

                int id1 = nameToId.get(f1);
                int id2 = nameToId.get(f2);

                // 친구 관계 연결 및 집합 크기 출력
                System.out.println(union(id1, id2));
            }
        }
    }
}