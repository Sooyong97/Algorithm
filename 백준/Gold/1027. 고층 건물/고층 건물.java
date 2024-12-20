import java.util.*;
import java.io.*;

public class Main {
    static int max;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            find_buildings(i);
        }
        System.out.println(max);
    }

    private static void find_buildings(int idx) {
        int left = checkLeft(idx);
        int right = checkRight(idx);
        int sum = left + right;
        max = Math.max(max, sum);
    }

    private static int checkLeft(int idx) {
        if (idx == 0) return 0;
        double slope = Double.POSITIVE_INFINITY;
        int count = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if ((double)(buildings[idx] - buildings[i]) / (idx - i) < slope) {
                slope = (double)(buildings[idx] - buildings[i]) / (idx - i);
                count++;
            }
        }
        return count;
    }
    private static int checkRight(int idx) {
        if (idx == buildings.length - 1) return 0;
        double slope = Double.NEGATIVE_INFINITY;
        int count = 0;
        for (int i = idx + 1; i < buildings.length; i++) {
            if ((double) (buildings[i] - buildings[idx]) / (i - idx) > slope) {
                slope = (double) (buildings[i] - buildings[idx]) / (i - idx);
                count++;
            }
        }
        return count;
    }
}
