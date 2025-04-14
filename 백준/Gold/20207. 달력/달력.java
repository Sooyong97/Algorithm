import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[367];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                count[j]++;
            }
        }

        int sum = 0;
        int h = 0, w = 0;
        for (int i = 1; i < 367; i++) {
            if (count[i] == 0) {
                sum += h * w;
                h = 0; w = 0;
            }
            else {
                w++;
                h = Math.max(h, count[i]);
            }
        }

        System.out.println(sum);
    }
}
