import java.util.*;
import java.io.*;

public class Main {

    private static boolean completed = false;

    private static void solve(int row, int col, int[][] map) {
        if (completed) return;

        if (map[row][col] != 0) {
            if (row == 8 && col == 8) {
                completed = true;
                printMap(map);
                return;
            }

            if (col == 8) solve(row + 1, 0, map);
            else solve(row, col + 1, map);
        } else {
            for (int num = 1; num <= 9; num++) {
                map[row][col] = num;
                if (isValid(row, col, map)) {
                    if (row == 8 && col == 8) {
                        completed = true;
                        printMap(map);
                        return;
                    }

                    if (col == 8) solve(row + 1, 0, map);
                    else solve(row, col + 1, map);
                }
                map[row][col] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col, int[][] map) {
        return checkRow(row, map) && checkCol(col, map) && checkBox(row, col, map);
    }

    private static boolean checkRow(int row, int[][] map) {
        boolean[] visited = new boolean[10];
        for (int col = 0; col < 9; col++) {
            int val = map[row][col];
            if (val == 0) continue;
            if (visited[val]) return false;
            visited[val] = true;
        }
        return true;
    }

    private static boolean checkCol(int col, int[][] map) {
        boolean[] visited = new boolean[10];
        for (int row = 0; row < 9; row++) {
            int val = map[row][col];
            if (val == 0) continue;
            if (visited[val]) return false;
            visited[val] = true;
        }
        return true;
    }

    private static boolean checkBox(int row, int col, int[][] map) {
        boolean[] visited = new boolean[10];
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                int val = map[i][j];
                if (val == 0) continue;
                if (visited[val]) return false;
                visited[val] = true;
            }
        }
        return true;
    }

    private static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sb.append(map[row][col]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];

        for (int row = 0; row < 9; row++) {
            String s = br.readLine();
            for (int col = 0; col < 9; col++) {
                map[row][col] = s.charAt(col) - '0';
            }
        }

        solve(0, 0, map);
    }
}