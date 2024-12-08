import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] people = new int[N];
        int[] line = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int left = people[i];

            for (int j = 0; j < N; j++) {
                if (line[j] == 0) {
                    if (left == 0) {
                        line[j] = i + 1;
                        break;
                    }
                    left--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}