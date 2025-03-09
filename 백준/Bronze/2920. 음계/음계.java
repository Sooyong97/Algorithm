import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbs = new int[8];
        for (int i = 0; i < 8; i++) {
            numbs[i] = Integer.parseInt(st.nextToken());
        }
        int dif = numbs[1] - numbs[0];
        for (int i = 1; i < 8; i++) {
            if (numbs[i] - numbs[i - 1] != dif) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println((dif > 0) ? "ascending" : "descending");
    }
}