import java.util.*;
import java.io.*;

public class Main {
    static int N, M, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        count = 0;
        find_N(broken);
        System.out.println(count);
    }

    private static void find_N(boolean[] broken) {
        if (N == 100) return;
        if (M == 10) {
            count = Math.abs(N - 100);
            return;
        }
        count = Math.abs(N - 100);
        String number = String.valueOf(N);
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean isBroken = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                int min = Math.abs(i - N) + num.length();
                count = Math.min(count, min);
            }
        }
    }
}
