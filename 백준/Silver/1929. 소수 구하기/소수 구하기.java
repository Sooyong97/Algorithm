import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        find_prime(M, N);

    }

    static void find_prime(int M, int N) {
        for (int i = M; i <= N; i++) {
            if (check_prime(i)){
                System.out.println(i);
            }
        }
    }

    static boolean check_prime(int num){
        if (num < 2) return false;

        int num_sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= num_sqrt; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
