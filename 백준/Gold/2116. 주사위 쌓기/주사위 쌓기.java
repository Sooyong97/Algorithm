import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dice;
    static int max = 0;

    static int[] opposite = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            solve(i);
        }

        System.out.println(max);
    }

    static void solve(int bottomIndex) {
        int sum = 0;
        int bottom = bottomIndex;
        int top = opposite[bottom];
        int bottomValue = dice[0][bottom];
        int topValue = dice[0][top];

        sum += getMaxSide(dice[0], bottom, top);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                if (dice[i][j] == topValue) {
                    bottom = j;
                    top = opposite[bottom];
                    bottomValue = dice[i][bottom];
                    topValue = dice[i][top];
                    sum += getMaxSide(dice[i], bottom, top);
                    break;
                }
            }
        }

        max = Math.max(max, sum);
    }

    static int getMaxSide(int[] d, int bottom, int top) {
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i == bottom || i == top) continue;
            max = Math.max(max, d[i]);
        }
        return max;
    }
}