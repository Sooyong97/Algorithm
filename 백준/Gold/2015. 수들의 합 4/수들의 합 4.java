import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Long> map = new HashMap<>();
        long sum = 0;
        long result = 0;

        map.put(0L, 1L);

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            result += map.getOrDefault(sum - K, 0L);
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        System.out.println(result);
    }
}