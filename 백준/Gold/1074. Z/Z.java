import java.io.*;
import java.util.*;

public class Main {

    static int N, r, c;
    static int num = 0;

    private static void findNum(int x, int y, int size) {
        if (size == 1) return;

        int half = size / 2;
        int area = half * half;

        if (r < x + half && c < y + half) {
            // 1사분면 (좌상)
            findNum(x, y, half);
        } else if (r < x + half && c >= y + half) {
            // 2사분면 (우상)
            num += area;
            findNum(x, y + half, half);
        } else if (r >= x + half && c < y + half) {
            // 3사분면 (좌하)
            num += area * 2;
            findNum(x + half, y, half);
        } else {
            // 4사분면 (우하)
            num += area * 3;
            findNum(x + half, y + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        findNum(0, 0, size);
        System.out.println(num);
    }
}