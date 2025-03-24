import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        list.sort(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt((int[] a) -> a[1]));

        for (int[] xy : list) {
            System.out.println(xy[0] + " " + xy[1]);
        }
    }
}