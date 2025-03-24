import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        V -= A;
        if (V <= 0) {
            System.out.println(1);
            return;
        }

        if (V % (A - B) == 0) {
            System.out.println((V / (A - B)) + 1);
        }
        else System.out.println((V / (A - B)) + 2);
    }
}