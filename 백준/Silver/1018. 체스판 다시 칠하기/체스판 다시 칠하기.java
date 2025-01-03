import java.util.*;
import java.io.*;

public class Main {
    static int N, M, minCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }

        minCount = Integer.MAX_VALUE;
        checkChess(s);
        System.out.println(minCount);
    }

    private static void checkChess(String[] s) {
        // 가능한 모든 8x8 서브그리드 탐색
        for (int startRow = 0; startRow <= N - 8; startRow++) {
            for (int startCol = 0; startCol <= M - 8; startCol++) {
                int bf = blackFirst(s, startRow, startCol);
                int wf = whiteFirst(s, startRow, startCol);
                minCount = Math.min(minCount, Math.min(bf, wf));
            }
        }
    }

    private static int blackFirst(String[] s, int startRow, int startCol) {
        int count = 0;
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                char expected = ((i + j) % 2 == 0) ? 'W' : 'B';
                if (s[i].charAt(j) == expected) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int whiteFirst(String[] s, int startRow, int startCol) {
        int count = 0;
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                char expected = ((i + j) % 2 == 0) ? 'B' : 'W';
                if (s[i].charAt(j) == expected) {
                    count++;
                }
            }
        }
        return count;
    }
}