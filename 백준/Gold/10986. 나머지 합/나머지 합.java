import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new long[M];

        st = new StringTokenizer(br.readLine());
        long answer = 0;
        long prefixSum = 0;

        for (int i = 0; i < N; i++) {
            prefixSum += Long.parseLong(st.nextToken());
            int mod = (int) (prefixSum % M);
            if (mod == 0) answer++;
            answer += count[mod];
            count[mod]++;
        }

        System.out.println(answer);
    }
}