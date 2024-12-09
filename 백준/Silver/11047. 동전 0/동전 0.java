import java.util.*;

public class Main {

    static Integer[] coins;

    private static void make_money(int K) {
        int count = 0;

        while (K != 0) {
            for (Integer coin : coins) {
                if (K >= coin) {
                    K -= coin;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        coins = new Integer[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, (a, b) -> b - a);

        make_money(K);
    }
}
