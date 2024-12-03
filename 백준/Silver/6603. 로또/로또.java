import java.util.*;

public class Main {

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        Arrays.sort(arr);
        if (r == 0) {
            printcombi(arr, visited, n);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void printcombi(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean[] visited = new boolean[n];
            combination(arr, visited, 0, arr.length, 6);
            System.out.println();
        }
    }
}
