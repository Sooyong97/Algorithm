import java.io.*;

public class Main {
    static final int div = 1_000_000_007;
    static long[] fact;  // 팩토리얼
    static long[] invFact;  // 역원

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //  factorial & 역원 계산
        precomputeFactorials(5000);

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(catalan(N));
        }
    }

    private static void precomputeFactorials(int maxN) {
        fact = new long[2 * maxN + 1];
        invFact = new long[2 * maxN + 1];

        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % div;
        }

        // 역원 계산 (페르마의 소정리)
        invFact[fact.length - 1] = modInverse(fact[fact.length - 1]);
        for (int i = fact.length - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % div;
        }
    }

    private static long catalan(int N) {
        if (N % 2 == 1) return 0;  // 홀수
        N /= 2;  // 카탈란 수 공식에서 n으로 변환
        return (((fact[2 * N] * invFact[N + 1]) % div) * invFact[N]) % div;
    }

    private static long modInverse(long x) {
        return pow(x, div - 2);
    }

    private static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % div;
            base = (base * base) % div;
            exp >>= 1;
        }
        return result;
    }
}