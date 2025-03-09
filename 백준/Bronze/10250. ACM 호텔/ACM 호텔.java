import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int f = (num % H == 0) ? H : num % H;
            int r = (num % H == 0) ? num / H : num / H + 1;
            sb.append(f * 100 + r + "\n");
        }
        System.out.println(sb);
    }
}