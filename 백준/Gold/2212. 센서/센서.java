import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] sensor = new int[N];

        for (int i = 0; i < N; i++) {
            sensor[i] = sc.nextInt();
        }

        Arrays.sort(sensor);

        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N - 1; i++)
            q.offer(sensor[i + 1] - sensor[i]);

        int distance = 0;

        for (int i = 0; i < N - K; i++)
            distance += q.poll();

        System.out.println(distance);

    }
}
