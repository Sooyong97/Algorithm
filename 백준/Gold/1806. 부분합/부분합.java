import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, len = N + 1;

        while (end < N) {
            while (end < N && sum < S) {
                sum += arr[end++];
            }

            while (sum >= S) {
                len = Math.min(len, end - start);
                sum -= arr[start++];
            }
        }

        System.out.println(len == N + 1 ? 0 : len);
    }
}