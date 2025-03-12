import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b});
        }

        int[] start = pq.poll();
        int min = start[0], max = start[1];
        int len = max - min;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1];
            if (min <= x && y <= max) continue;
            if (x < max) len += y - max;
            if (x >= max) len += y - x;
            min = x;
            max = y;
        }

        System.out.println(len);
    }
}