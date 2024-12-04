import java.util.*;

public class Main {

    static long A, B;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        result = Integer.MAX_VALUE;

        dfs(A, B, 1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else{
            System.out.println(result);
        }
    }

    static void dfs(long start, long end, int count) {
        if (start > end) return;
        if (start == end) {
            result = Math.min(result, count);
        }
        dfs(start * 2, end, count + 1);
        dfs((start * 10) + 1, end, count + 1);
    }
}
