import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] solvent = new int[N];
        for (int i = 0; i < N; i++) {
            solvent[i] = sc.nextInt();
        }

        find(solvent);

    }

    private static void find(int[] solvent) {
        int left = 0;
        int right = solvent.length - 1;
        int min = Integer.MAX_VALUE;
        int[] solution = new int[2];
        while (left < right) {
            int sum = solvent[left] + solvent[right];
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                solution[0] = solvent[left];
                solution[1] = solvent[right];
            }
            if (sum > 0) right--;
            else left++;
        }
        System.out.println(solution[0] + " " + solution[1]);
    }
}
