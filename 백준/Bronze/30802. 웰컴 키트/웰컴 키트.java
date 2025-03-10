import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] participants = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            participants[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int totalT = 0;
        for (int i = 0; i < 6; i++) {
            if (participants[i] == 0) continue;
            totalT += (participants[i] % T == 0) ? participants[i] / T : participants[i] / T + 1;
        }
        System.out.println(totalT);
        System.out.println(N / P + " " + N % P);
    }
}