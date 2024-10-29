import java.util.Scanner;

public class Main {

    public static long modExp(long a, long b, long c) {
        long result = 1;
        a = a % c; // a를 c로 미리 나눈 나머지

        while (b > 0) {
            // b가 홀수이면 result에 a를 곱함
            if ((b & 1) == 1) {
                result = (result * a) % c;
            }
            // b를 2로 나누고 a를 제곱한 뒤 c로 나눈 나머지를 다시 a에 저장
            b >>= 1;
            a = (a * a) % c;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(modExp(A, B, C));
    }
}
