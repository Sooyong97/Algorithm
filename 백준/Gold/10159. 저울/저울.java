import java.util.*;

public class Main {

    public static int N, M;

    public static void compare(int[][] prod) {
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (prod[i][k] == 1 && prod[k][j] == 1) {
                        prod[i][j] = 1;
                    }

                    if (prod[i][k] == -1 && prod[k][j] == -1) {
                        prod[i][j] = -1;
                    }
                }
            }
        }
    }

    public static void print(int[][] prod) {
        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                if (prod[i][j] != 0) {
                    count++;
                }
            }
            System.out.println(N - count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] prod = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            prod[i][i] = 1;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            prod[a][b] = 1;
            prod[b][a] = -1;

        }

        compare(prod);

        print(prod);

    }
}
