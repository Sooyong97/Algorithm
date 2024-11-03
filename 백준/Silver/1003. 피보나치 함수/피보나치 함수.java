import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];

        zeroCount[0] = 1;
        oneCount[0] = 0;
        zeroCount[1] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(zeroCount[N] + " " + oneCount[N]);
        }
    }
}