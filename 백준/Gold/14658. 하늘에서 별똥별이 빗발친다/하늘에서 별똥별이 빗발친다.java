import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, L;
    static List<int[]> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        // 최소 별 제거 개수 계산
        int answer = Integer.MAX_VALUE;

        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                // (star1.x, star2.y)를 기준으로 L x L 정사각형 탐색
                int x1 = star1[0];
                int y1 = star2[1];
                int x2 = x1 + L;
                int y2 = y1 + L;

                int count = countStarsInRange(x1, y1, x2, y2);
                answer = Math.min(answer, K - count);
            }
        }

        System.out.println(answer);
    }

    // 주어진 범위 내 별의 개수를 계산
    private static int countStarsInRange(int x1, int y1, int x2, int y2) {
        int count = 0;
        for (int[] star : stars) {
            if (x1 <= star[0] && star[0] <= x2 && y1 <= star[1] && star[1] <= y2) {
                count++;
            }
        }
        return count;
    }
}