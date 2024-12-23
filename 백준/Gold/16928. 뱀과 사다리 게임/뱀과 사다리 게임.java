import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, Integer> ld = new HashMap<>();
    static Map<Integer, Integer> sn = new HashMap<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladder; i++) {
            st = new StringTokenizer(br.readLine());
            ld.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < snake; i++) {
            st = new StringTokenizer(br.readLine());
            sn.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int loc = current[0];
            int roll = current[1];

            if (loc == 100) {
                return roll;
            }

            for (int i = 1; i <= 6; i++) {
                int next_loc = loc + i;
                if (next_loc > 100) continue;

                if (ld.containsKey(next_loc)) {
                    next_loc = ld.get(next_loc);
                } else if (sn.containsKey(next_loc)) {
                    next_loc = sn.get(next_loc);
                }

                if (!visited[next_loc]) {
                    visited[next_loc] = true;
                    queue.add(new int[]{next_loc, roll + 1});
                }
            }
        }
        return -1;
    }
}