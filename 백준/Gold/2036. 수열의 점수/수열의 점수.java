import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());


        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a <= 0) {
                minus.add(a);
            } else {
                plus.add(a);
            }
        }

        long score = 0;

        while (!plus.isEmpty()) {
            int num1 = plus.poll();
            if (!plus.isEmpty()) {
                int num2 = plus.poll();
                if ( num2 == 1){
                    score += num1 + num2;
                } else {
                    score += (long) num1 * num2;
                }
            } else {
                score += num1;
            }
        }

        while (!minus.isEmpty()) {
            int num1 = minus.poll();
            if (!minus.isEmpty()) {
                int num2 = minus.poll();
                score += (long) num1 * num2;
            } else {
                score += num1;
            }
        }

        System.out.println(score);
    }
}
