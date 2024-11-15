import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] lessons = new int[N][2];

        for (int i = 0; i < N; i++) {
            lessons[i][0] = sc.nextInt();
            lessons[i][1] = sc.nextInt();
        }

        Arrays.sort(lessons, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxRooms = 0;

        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= lessons[i][0]) {
                pq.poll();
            }
            pq.add(lessons[i][1]);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        System.out.println(maxRooms);
    }
}