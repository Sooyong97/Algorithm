import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        int counts = 0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (set.contains(s)) counts++;
        }
        System.out.println(counts);
    }
}