import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static boolean check_consistency(String[] str_array) {
        Arrays.sort(str_array);

        for (int i = 0; i < str_array.length - 1; i++) {
            if (str_array[i + 1].startsWith(str_array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            String[] nums = new String[n];

            for (int j = 0; j < n; j++){
                nums[j] = sc.next();
            }

            if (check_consistency(nums)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }
        sc.close();

    }
}