import java.io.*;
import java.util.*;

public class Main {

    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ans = new int[10];
        int start = 1;
        int end = N;
        int place = 1;

        while (start <= end) {
            while (end % 10 != 9 && start <= end) {
                calc(end, place);
                end--;
            }

            if (start > end) {
                break;
            }

            while (start % 10 != 0 && start <= end) {
                calc(start, place);
                start++;
            }

            start /= 10;
            end /= 10;

            int count = end - start + 1;
            for (int i = 0; i < 10; i++) {
                ans[i] += count * place;
            }

            place *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void calc(int n, int place) {
        while (n > 0) {
            ans[n % 10] += place;
            n /= 10;
        }
    }
}