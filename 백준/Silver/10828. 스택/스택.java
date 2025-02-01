import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) q.addFirst(Integer.parseInt(s[1]));
            if (s[0].equals("pop")) sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            if (s[0].equals("size")) sb.append(q.size()).append("\n");
            if (s[0].equals("empty")) sb.append(q.isEmpty() ? 1 : 0).append("\n");
            if (s[0].equals("top")) sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
        }
        System.out.println(sb);
    }
}