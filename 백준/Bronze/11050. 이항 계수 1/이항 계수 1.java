import java.io.*;
import java.util.*;

public class Main {

    private static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K < 0 || K > N) {
            System.out.println("0");
            return;
        }

        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }
}