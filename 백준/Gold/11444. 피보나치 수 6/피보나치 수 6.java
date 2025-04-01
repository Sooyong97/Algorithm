import java.io.*;

public class Main {

    final static long mod = 1_000_000_007;
    public static long[][] origin = {{1, 1}, {1, 0}};

    private static long[][] pow(long[][] A, long exp) {
        if (exp == 0 || exp == 1) {
            return A;
        }

        long[][] ret = pow(A, exp / 2);

        ret = multiply(ret, ret);

        if (exp % 2 == 1L) ret = multiply(ret, origin);

        return ret;
    }

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] ret = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ret[j][k] += A[j][i] * B[i][k];
                    ret[j][k] %= mod;
                }
            }
        }

        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(pow(A, N - 1)[0][0]);
    }
}
