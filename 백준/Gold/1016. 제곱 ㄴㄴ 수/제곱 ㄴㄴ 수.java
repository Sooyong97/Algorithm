import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int boundary = (int) (max - min + 1);
        int sqrt = ((int) Math.sqrt(max));

        boolean[] check = new boolean[boundary];


        for(long i = 2; i <= sqrt; i++) {
            long squared = i * i;
            long start = min % squared == 0 ? min / squared : (min / squared) + 1;
            for(long j = start; j * squared <= max; j ++) {
                if (check[(int) ( (j * squared) - min)]) continue;
                check[(int) ( (j * squared) - min)] = true;
                boundary--;
            }
        }
        System.out.println(boundary);
    }
}