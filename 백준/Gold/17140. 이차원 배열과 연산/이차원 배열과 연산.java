import java.util.*;
import java.io.*;

public class Main {

    static final int maxVal = 101;
    static int r, c, k;
    static int rLen, cLen;
    static int[][] map = new int[maxVal][maxVal];

    private static void entrySetListSort(List<Map.Entry<Integer, Integer>> list) {
        list.sort(
                Comparator
                        .comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
                        .thenComparingInt(Map.Entry::getKey));
    }

    private static void matrixSort(boolean isRow) {
        int maxLen = 0;

        for (int i = 1; i <= (isRow ? rLen : cLen); i++) {
            Map<Integer, Integer> counts = new HashMap<>();

            for (int j = 1; j <= (isRow ? cLen : rLen); j++) {
                int val = isRow ? map[i][j] : map[j][i];
                if (val == 0) continue;
                counts.put(val, counts.getOrDefault(val, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(counts.entrySet());
            entrySetListSort(list);

            int idx = 1;
            for (Map.Entry<Integer, Integer> e : list) {
                if (idx >= maxVal) break;
                if (isRow) map[i][idx++] = e.getKey();
                else map[idx++][i] = e.getKey();

                if (idx >= maxVal) break;
                if (isRow) map[i][idx++] = e.getValue();
                else map[idx++][i] = e.getValue();
            }

            for (int j = idx; j < maxVal; j++) {
                if (isRow) map[i][j] = 0;
                else map[j][i] = 0;
            }

            maxLen = Math.max(maxLen, idx - 1);
        }

        if (isRow) cLen = maxLen;
        else rLen = maxLen;
    }

    private static void solve() {
        int sec = -1;
        rLen = 3; cLen = 3;

        boolean exist = false;

        while (sec++ < maxVal) {
            if (map[r][c] == k) {
                exist = true;
                break;
            }

            if (rLen >= cLen) matrixSort(true);
            else matrixSort(false);
        }

        if (exist) {
            System.out.println(sec);
            return;
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }
}
