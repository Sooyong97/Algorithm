import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new int[]{weight, value});
        }

        Collections.sort(jewels, (a, b) -> Integer.compare(a[0], b[0]));


        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> possibleJewels = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int jewelIndex = 0;

        for (int bagSize : bags) {
            while (jewelIndex < jewels.size() && jewels.get(jewelIndex)[0] <= bagSize) {
                possibleJewels.offer(jewels.get(jewelIndex)[1]);
                jewelIndex++;
            }

            if (!possibleJewels.isEmpty()) {
                sum += possibleJewels.poll();
            }
        }

        System.out.println(sum);
    }
}