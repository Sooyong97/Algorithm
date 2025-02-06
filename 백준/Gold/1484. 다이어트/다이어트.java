import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        long start = 1;
        long end = 2;

        boolean check = false;
        while (end < 100_000) {
            long n = end * end - start * start;

            if (n == G) {
                System.out.println(end);
                check = true;
            }

            if (n > G) start++;
            if (n <= G) end++;
        }

        if (!check) System.out.println("-1");
    }
}