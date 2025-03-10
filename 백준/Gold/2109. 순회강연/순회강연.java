import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - day;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();

        int deadLine = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(pay, day));
            deadLine = Math.max(deadLine, day);
        }

        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int totalPay = 0;
        int index = 0;

        for (int i = deadLine; i >= 1; i--) {
            while (index < n && lectures.get(index).day >= i) {
                pq.add(lectures.get(index).pay);
                index++;
            }

            if (!pq.isEmpty()) {
                totalPay += pq.poll();
            }
        }

        System.out.println(totalPay);
    }
}