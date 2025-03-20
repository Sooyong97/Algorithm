import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < N; right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            count += (right - left + 1);
        }

        System.out.println(count);
    }
}