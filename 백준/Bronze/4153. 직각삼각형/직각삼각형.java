import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String s = br.readLine();
            if (s.equals("0 0 0")) break;
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] slides = new int[]{a, b, c};
            Arrays.sort(slides);
            if (slides[0] * slides[0] + slides[1] * slides[1] == slides[2] * slides[2]) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}