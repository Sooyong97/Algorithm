import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] houses = new int[N][3];

        int[][] price = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                houses[i][j] = sc.nextInt();
            }
        }

        price[0][0] = houses[0][0];
        price[0][1] = houses[0][1];
        price[0][2] = houses[0][2];

        for (int i = 1; i < N; i++) {
            price[i][0] = Math.min(price[i - 1][1], price[i - 1][2]) + houses[i][0];
            price[i][1] = Math.min(price[i - 1][0], price[i - 1][2]) + houses[i][1];
            price[i][2] = Math.min(price[i - 1][0], price[i - 1][1]) + houses[i][2];
        }

        System.out.println(Arrays.stream(price[N-1]).min().getAsInt());

    }
}
