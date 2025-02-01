import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            checkVPS(s);
        }
    }

    private static void checkVPS(String s) {
        Queue<Character> q = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') q.add('(');
            else if (c == ')') {
                if (q.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                q.poll();
            }
        }

        if (q.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}