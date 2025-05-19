import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            count++;

            balancing();

            sb.append(findMiddleNumber()).append('\n');
        }

        System.out.print(sb);
    }

    static int findMiddleNumber() {
        return maxHeap.peek();
    }

    static void balancing() {
        int maxHeapSize = (count + 1) / 2;

        // 힙 크기 조정
        while (maxHeap.size() > maxHeapSize) {
            minHeap.add(maxHeap.poll());
        }

        while (maxHeap.size() < maxHeapSize) {
            maxHeap.add(minHeap.poll());
        }
    }
}