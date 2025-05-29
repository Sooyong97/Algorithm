import java.io.*;
import java.util.*;

public class Main {

    static class cocktail {
        int a, b, nominator, denominator;

        public cocktail(int a, int b, int nominator, int denominator) {
            this.a = a;
            this.b = b;
            this.nominator = nominator;
            this.denominator = denominator;
        }
    }

    static int N;
    static List<cocktail> cocktails;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] amounts;
    static int visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        amounts = new int[N];
        for (int i = 0; i < N; i++) {
            amounts[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int tmp1 = amounts[b] * p;
            int tmp2 = amounts[a] * q;
            int div = gcd(tmp1, tmp2);

            visit = 0;
            dfs(a, tmp1 / div);
            visit = 0;
            dfs(b, tmp2 / div);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(amounts[i] + " ");
        }
    }

    static void dfs(int node, int mul) {
        amounts[node] *= mul;
        visit |= (1 << node);

        for (int next : graph.get(node)) {
            if ((visit & (1 << next)) == 0) {
                visit |= (1 << next);
                dfs(next, mul);
            }
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}