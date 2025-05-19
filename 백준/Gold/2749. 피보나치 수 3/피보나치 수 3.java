import java.io.*;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[] res = fib(n);
        System.out.println(res[0]);  // F(n) mod
    }

    // returns {F(n) mod, F(n+1) mod}
    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};
        long[] half = fib(n >> 1);
        long a = half[0];  // F(k)
        long b = half[1];  // F(k+1)

        // F(2k) = F(k) * [2*F(k+1) − F(k)]
        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        // F(2k+1) = F(k)^2 + F(k+1)^2
        long d = ( (a * a) % MOD + (b * b) % MOD ) % MOD;

        if ((n & 1) == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, (c + d) % MOD};
        }
    }
}