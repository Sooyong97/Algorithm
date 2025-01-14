import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            if (pq.isEmpty()) {
                System.out.println(sum);
                break;
            }
            int next = pq.poll();
            pq.add(next + first);
            sum += next + first;
        }
    }
}
