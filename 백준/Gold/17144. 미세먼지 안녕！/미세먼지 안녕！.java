import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[][] air = new int[2][2];
        int airP = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    air[airP][0] = i;
                    air[airP][1] = j;
                    airP++;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread(map);
            clear(map, air);
        }

        printAir(map);
    }

    private static void spread(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && map[nx][ny] != -1) {
                            temp[nx][ny] += amount;
                            spreadCount++;
                        }
                    }

                    temp[i][j] += map[i][j] - (amount * spreadCount);
                } else if (map[i][j] == -1) {
                    temp[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(temp[i], 0, map[i], 0, cols);
        }
    }

    private static void clear(int[][] map, int[][] air) {
        clearTop(map, air[0]);
        clearBottom(map, air[1]);
    }

    private static void clearTop(int[][] map, int[] air) {
        int row = air[0];
        int col = map[0].length;

        for (int i = row - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }

        for (int j = 0; j < col - 1; j++) {
            map[0][j] = map[0][j + 1];
        }

        for (int i = 0; i < row; i++) {
            map[i][col - 1] = map[i + 1][col - 1];
        }

        for (int j = col - 1; j > 1; j--) {
            map[row][j] = map[row][j - 1];
        }

        map[row][1] = 0;
    }

    private static void clearBottom(int[][] map, int[] air) {
        int row = air[0];
        int col = map[0].length;

        for (int i = row + 1; i < map.length - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int j = 0; j < col - 1; j++) {
            map[map.length - 1][j] = map[map.length - 1][j + 1];
        }

        for (int i = map.length - 1; i > row; i--) {
            map[i][col - 1] = map[i - 1][col - 1];
        }

        for (int j = col - 1; j > 1; j--) {
            map[row][j] = map[row][j - 1];
        }

        map[row][1] = 0;
    }

    private static void printAir(int[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    count += map[i][j];
                }
            }
        }
        System.out.println(count);
    }
}
