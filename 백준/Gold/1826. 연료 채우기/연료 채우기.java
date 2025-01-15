import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] station  = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            station[i][0] = a;
            station[i][1] = b;
        }
        st = new StringTokenizer(br.readLine());
        int targetTown = Integer.parseInt(st.nextToken());
        int startFuel = Integer.parseInt(st.nextToken());

        System.out.println(minStopStation(targetTown, startFuel, station));

    }

    private static int minStopStation(int targetTown, int startFuel, int[][] station) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int fuel = startFuel;
        int idx = 0;
        int count = 0;
        
        Arrays.sort(station, Comparator.comparingInt(a -> a[0]));

        while (fuel < targetTown) {
            while (idx < station.length && station[idx][0] <= fuel) {
                pq.add(station[idx][1]);
                idx++;
            }

            if (pq.isEmpty()) {
                return -1;
            }

            fuel += pq.poll();
            count++;
        }
        return count;
    }
}
