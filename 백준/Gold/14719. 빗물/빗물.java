import java.util.*;
import java.io.*;

public class Main {

    private static int H, W, count;
    private static boolean[][] map;

    private static void fillwater(int height) {
        int idx = 0;
        while (idx < W) {
            if (map[height][idx]) {
                int start = idx + 1;
                int tempCount = 0;

                while (start < W && !map[height][start]) {
                    start++;
                    tempCount++;
                }

                if (start < W && map[height][start]) {
                    count += tempCount;
                }

                idx = start - 1;
            }
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new boolean[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = 0; j < height; j++) {
                map[j][i] = true;
            }
        }

        count = 0;
        for (int i = 0; i < H; i++) {
            fillwater(i);
        }

        System.out.println(count);
    }
}