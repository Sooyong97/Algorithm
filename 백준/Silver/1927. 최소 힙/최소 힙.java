import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) printQueue();
            else addQueue(x);
        }
    }

    private static void printQueue() {
        if (pq.isEmpty()) System.out.println("0");
        else System.out.println(pq.poll());
    }

    private static void addQueue(int x) {
        pq.add(x);
    }
}