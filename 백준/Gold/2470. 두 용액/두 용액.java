import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int num1 = 0, num2 = 0;

        int left = 0, right = N - 1;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                num1 = (int) arr[left];
                num2 = (int) arr[right];
            }

            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                right--;
            } else left++;
        }

        System.out.println(num1 + " " + num2);
    }
}
