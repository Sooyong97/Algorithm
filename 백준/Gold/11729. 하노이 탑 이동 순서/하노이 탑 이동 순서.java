import java.io.*;
import java.util.*;

public class Main {

        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        bw.write((int) Math.pow(2, N) - 1 + "\n");
        hanoi(N, 1, 2, 3);
        bw.flush();
        bw.close();
    }

    private static void hanoi(int N, int start, int mid, int end) throws IOException {
        if (N == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        hanoi(N - 1, start, end, mid);

        bw.write(start + " " + end + "\n");

        hanoi(N - 1, mid, start, end);

    }
}
