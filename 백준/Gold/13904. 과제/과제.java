import java.io.*;
import java.util.*;

public class Main {

    static class Task implements Comparable<Task> {
        int d, w;

        public Task(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Task o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Task> tasks = new ArrayList<>();

        int deadLine = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tasks.add(new Task(d, w));
            deadLine = Math.max(deadLine, d);
        }

        Collections.sort(tasks, (a, b) -> b.d - a.d);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int score = 0;
        int index = 0;

        for (int day = deadLine; day >= 1; day--) {
            while (index < N && tasks.get(index).d >= day) {
                pq.add(tasks.get(index).w);
                index++;
            }

            if (!pq.isEmpty()) {
                score += pq.poll();
            }
        }

        System.out.println(score);
    }
}