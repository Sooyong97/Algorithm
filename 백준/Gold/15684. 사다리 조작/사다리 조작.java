import java.util.Scanner;

public class Main {
    public static boolean[][] ladder;
    public static int n, h;
    public static int answer = Integer.MAX_VALUE;

    public static int move(int start) {
        int y = start;

        for (int x = 1; x <= h; x++) {
            if (y < n && ladder[x][y]) {
                y++;
            } else if (y > 1 && ladder[x][y - 1]) {
                y--;
            }
        }
        return y;
    }

    public static boolean check() {
        for (int i = 1; i <= n; i++) {
            if (move(i) != i) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int count, int x, int y) {
        if (count >= answer) return;

        if (check()) {
            answer = Math.min(answer, count);
            return;
        }

        if (count == 3) return;

        for (int i = x; i <= h; i++, y = 1) {
            for (int j = y; j < n; j++) {
                if (!ladder[i][j] && !ladder[i][j + 1]) {
                    ladder[i][j] = true;
                    dfs(count + 1, i, j + 2);
                    ladder[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        h = sc.nextInt();

        ladder = new boolean[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ladder[x][y] = true;
        }

        dfs(0, 1, 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
