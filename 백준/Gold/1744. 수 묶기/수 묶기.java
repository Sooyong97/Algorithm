import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number <= 0) minus.add(number);
            else if (number == 1) result++;
            else plus.add(number);
        }

        while (!minus.isEmpty()) {
            int mi = minus.poll();
            if (!minus.isEmpty()) {
                int mi2 = minus.poll();
                result += mi * mi2;
            } else {
                result += mi;
            }
        }

        while (!plus.isEmpty()) {
            int pi = plus.poll();
            if (!plus.isEmpty()) {
                int pi2 = plus.poll();
                result += pi * pi2;
            } else {
                result += pi;
            }
        }

        System.out.println(result);
    }
}