import java.util.*;

public class Main {

    static class Bottle {
        int vol, now;

        public Bottle(int vol, int now) {
            this.vol = vol;
            this.now = now;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bottle[] bottles = new Bottle[3];
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            if (i != 2) {
                bottles[i] = new Bottle(a, 0);
            } else {
                bottles[i] = new Bottle(a, a);
            }
        }

        boolean[][][] visited = new boolean[bottles[0].vol + 1][bottles[1].vol + 1][bottles[2].vol + 1];
        TreeSet<Integer> result = new TreeSet<>();

        Queue<Bottle[]> queue = new LinkedList<>();
        queue.add(bottles.clone());
        visited[bottles[0].now][bottles[1].now][bottles[2].now] = true;

        while (!queue.isEmpty()) {
            Bottle[] current = queue.poll();

            if (current[0].now == 0) {
                result.add(current[2].now);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;

                    Bottle[] next = new Bottle[3];
                    for (int k = 0; k < 3; k++) {
                        next[k] = new Bottle(current[k].vol, current[k].now);
                    }

                    int transfer = Math.min(next[i].now, next[j].vol - next[j].now);
                    next[i].now -= transfer;
                    next[j].now += transfer;

                    if (!visited[next[0].now][next[1].now][next[2].now]) {
                        visited[next[0].now][next[1].now][next[2].now] = true;
                        queue.add(next);
                    }
                }
            }
        }

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}