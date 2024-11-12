import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[][] M;
    public static int nums;

    public static void numb(int L){
        int currentPos = 0;
        nums = 0;

        for (int[] range : M) {
            int start = range[0];
            int end = range[1];

            if (currentPos < start) {
                currentPos = start;
            }

            while (currentPos <= end) {
                nums++;
                currentPos += L;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        M = new int[N][2];
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            M[i][0] = a;
            M[i][1] = b - 1;
        }

        Arrays.sort(M, (a, b) -> Integer.compare(a[0], b[0]));

        nums = 0;
        numb(L);
        System.out.println(nums);
    }
}
