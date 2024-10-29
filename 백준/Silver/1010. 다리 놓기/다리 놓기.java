import java.util.Scanner;

public class Main {

    public static double factorial(double n){
        if (n == 1 || n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long N = sc.nextInt();
            long M = sc.nextInt();

            double result = (double) factorial(M) / (factorial(N) * factorial(M - N));
            System.out.println(String.format("%.0f", result));
        }
    }
}
