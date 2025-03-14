import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long count;
    static int[] arr;

    private static void solve() {
        for (int i = 0; i < N - 2; i++) {
            if (arr[i] > 0) break;

            int left = i + 1, right = N - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        long rMinusL = (long) right - (long) left;
                        count += (rMinusL * (rMinusL + 1)) / 2;
                        break;
                    } else {
                        long leftCount = 1, rightCount = 1;

                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            left++;
                            leftCount++;
                        }
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            right--;
                            rightCount++;
                        }

                        count += leftCount * rightCount;
                        left++;
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve();
    }
}