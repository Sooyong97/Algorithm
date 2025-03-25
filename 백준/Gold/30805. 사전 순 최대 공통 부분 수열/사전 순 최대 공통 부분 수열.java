import java.util.*;
import java.io.*;

public class Main {

    private static List<Integer> findLastSubSequence(int[] arr1, int[] arr2) {
        List<Integer> last = new ArrayList<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int start1 = 0, start2 = 0;

        while (start1 < length1 && start2 < length2) {
            int max = Integer.MIN_VALUE;
            int maxIdx1 = -1;
            int maxIdx2 = -1;

            for (int i = start1; i < length1; i++) {
                for (int j = start2; j < length2; j++) {
                    if (arr1[i] == arr2[j] && arr1[i] > max) {
                        max = arr1[i];
                        maxIdx1 = i;
                        maxIdx2 = j;
                    }
                }
            }

            if (maxIdx1 == -1 || maxIdx2 == -1) break;

            last.add(max);
            start1 = maxIdx1 + 1;
            start2 = maxIdx2 + 1;
        }

        return last;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arrB = new int[M];
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> last = findLastSubSequence(arrA, arrB);

        System.out.println(last.size());
        if (!last.isEmpty()) {
            for (int num : last) {
                System.out.print(num + " ");
            }
        }
    }
}