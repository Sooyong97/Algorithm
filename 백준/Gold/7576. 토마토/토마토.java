import java.io.*;
import java.util.*;

public class Main {

    static int N, M, days;
    static int[][] tomatos;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int x, y, day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            days = tomato.day;
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && tomatos[nx][ny] == 0) {
                    tomatos[nx][ny] = 1;
                    q.add(new Tomato(nx, ny, tomato.day + 1));
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomatos[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomatos = new int[M][N];
        days = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
                if (tomatos[i][j] == 1) q.add(new Tomato(i, j, 0));
            }
        }

        bfs();

        if (check()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }

    }
}
