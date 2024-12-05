import java.util.*;

public class Main {

    static class Conv {
        int x;
        int y;

        public Conv(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static void bfs(Conv[] conv, boolean[] visited) {
        Queue<Conv> q = new LinkedList<>();
        q.add(conv[0]);
        visited[0] = true;

        while (!q.isEmpty()) {
            Conv cur = q.poll();

            if (cur.x == conv[conv.length - 1].x && cur.y == conv[conv.length - 1].y) {
                System.out.println("happy");
                return;
            }

            for (int i = 0; i < conv.length; i++) {
                if (!visited[i] && canMove(cur, conv[i])) {
                    visited[i] = true;
                    q.add(conv[i]);
                }
            }
        }
        System.out.println("sad");
    }

    private static boolean canMove(Conv start, Conv end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y) <= 1000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int conv_num = sc.nextInt();
            Conv[] conv = new Conv[conv_num + 2];
            for (int j = 0; j < conv_num + 2; j++) {
                conv[j] = new Conv(sc.nextInt(), sc.nextInt());
            }

            boolean[] visited = new boolean[conv_num + 2];

            bfs(conv, visited);
        }
    }
}
