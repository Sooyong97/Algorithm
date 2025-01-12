import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (check(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean check(String s) {
        boolean[] alphabets = new boolean[26];
        char prev = s.charAt(0);
        alphabets[prev - 'a'] = true;

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != prev) {
                if (alphabets[current - 'a']) {
                    return false;
                }
                alphabets[current - 'a'] = true;
            }
            prev = current;
        }

        return true;
    }
}