import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 모든 두 수의 합 저장
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(list);

        // 큰 값과 하나의 값을 뺀 값이 두 수의 합에 존재 확인
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int diff = arr[i] - arr[j];
                if (Collections.binarySearch(list, diff) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}