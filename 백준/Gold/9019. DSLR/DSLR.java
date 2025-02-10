import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    public static String bfs(int start, int end) {
        boolean[] visited = new boolean[MAX];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, ""));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.value == end) {
                return cur.command;
            }

            int d = (cur.value * 2) % MAX;
            if (!visited[d]) {
                visited[d] = true;
                queue.add(new Node(d, cur.command + "D"));
            }

            int s = (cur.value == 0) ? 9999 : cur.value - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new Node(s, cur.command + "S"));
            }

            int l = (cur.value % 1000) * 10 + (cur.value / 1000);
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new Node(l, cur.command + "L"));
            }

            int r = (cur.value % 10) * 1000 + (cur.value / 10);
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new Node(r, cur.command + "R"));
            }
        }
        return "";
    }

    static class Node {
        int value;
        String command;

        Node(int value, String command) {
            this.value = value;
            this.command = command;
        }
    }
}