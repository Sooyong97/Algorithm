import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < n) {
            if (arr[end] - arr[start] < m) {
                end++;
                continue;
            }

            if (arr[end] - arr[start] == m) {
                minDiff = m;
                break;
            }

            minDiff = Math.min(minDiff, arr[end] - arr[start]);
            start++;
        }

        System.out.println(minDiff);

    }
}