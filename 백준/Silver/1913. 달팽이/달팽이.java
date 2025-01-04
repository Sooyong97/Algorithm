import java.util.Scanner;

public class Main {
    static int targetX, targetY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();

        solve(N, target);
    }

    private static void solve(int N, int target) {
        int[][] snail = new int[N][N];
        int number = N * N;
        int x = 0, y = 0;
        int xTerm = 0;
        int yTerm = N;
        while (number > 0) {
            x = xTerm;
            for (int i = y; i < yTerm; i++) {
                snail[i][x] = number--;
                if (snail[i][x] == target) {
                    targetX = i + 1;
                    targetY = x + 1;
                }
            }

            y = yTerm - 1;
            for (int i = x + 1; i < yTerm; i++) {
                snail[y][i] = number--;
                if (snail[y][i] == target) {
                    targetX = y + 1;
                    targetY = i + 1;
                }
            }

            x = yTerm - 1;
            for (int i = y - 1; i >= xTerm; i--) {
                snail[i][x] = number--;
                if (snail[i][x] == target) {
                    targetX = i + 1;
                    targetY = x + 1;
                }
            }

            y = xTerm;
            for (int i = x - 1; i > xTerm; i--) {
                snail[y][i] = number--;
                if (snail[y][i] == target) {
                    targetX = y + 1;
                    targetY = i + 1;
                }
            }
            xTerm++;
            yTerm--;
            y = xTerm;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(targetX + " " + targetY);
    }
}
