import java.util.*;
import java.io.*;

public class Main {

    static int[][] dist, firstTown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        firstTown = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = w;
            dist[v][u] = w;
            firstTown[u][v] = v;
            firstTown[v][u] = u;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 0 || dist[k][j] == 0) continue;
                    if (i == j) firstTown[i][j] = Integer.MAX_VALUE;
                    else if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        firstTown[i][j] = firstTown[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(firstTown[i][j] == Integer.MAX_VALUE ? "- " : firstTown[i][j] + " ");
            }
            System.out.println();
        }
    }
}
