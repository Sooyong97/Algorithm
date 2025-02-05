import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    public static void solve(int x, int y) {
        if (x == 9) {
            solve(0, y + 1);
            return;
        }

        if (y == 9) {
            show();
            System.exit(0);
        }

        if (map[x][y] != 0) {
            solve(x + 1, y);
            return;
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(x, y, num)) {
                map[x][y] = num;
                solve(x + 1, y);
                map[x][y] = 0;
            }
        }
    }

    public static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num || map[i][y] == num) return false;
        }

        int row = (x / 3) * 3;
        int col = (y / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}