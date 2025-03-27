import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int sum = 0;
        int rounded = Math.round((float) K * (float) 0.15);

        for (int i = rounded; i < K - rounded; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round((float) sum / (K - (2 * rounded))));

    }
}
