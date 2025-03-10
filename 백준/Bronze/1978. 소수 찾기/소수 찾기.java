import java.io.*;
import java.util.*;

public class Main {

    static boolean[] notPrime;

    private static void sieve(int n) {
        notPrime = new boolean[n + 1];

        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        sieve(max);

        int primeCount = 0;
        for (int num : arr) {
            if (!notPrime[num]) primeCount++;
        }

        System.out.println(primeCount);
    }
}