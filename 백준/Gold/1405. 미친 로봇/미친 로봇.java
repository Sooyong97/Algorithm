import java.io.*;
import java.util.*;
 
public class Main {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int N;
    static double[] percents;
    static double ans = 0;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        percents = new double[4];
        for (int i = 0; i < 4; i++) {
            percents[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }
 
        boolean[][] visited = new boolean[30][30];
        visited[15][15] = true;
        dfs(15, 15, visited, 0, 1);
 
        System.out.println(ans);
    }
 
    public static void dfs(int x, int y, boolean[][] visited, int cnt, double result) {
        if (cnt == N) {
            ans += result;
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx <= 0 || ny <= 0 || nx >= 30 || ny >= 30) {
                continue;
            }
 
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, visited, cnt + 1, result * percents[i]);
                visited[nx][ny] = false;
            }
        }
    }
 
}