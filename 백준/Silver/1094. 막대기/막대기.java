import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 64){
            System.out.println(1);
            return;
        }

        int[] stick = {64, 32, 16, 8, 4, 2, 1};
        int leng = 0;
        int count = 0;
        for (int i = 0; i < stick.length; i++) {
            if (leng + stick[i] <= N) {
                leng += stick[i];
                count++;
                if (leng == N){
                    System.out.println(count);
                    return;
                }
            }
        }

    }
}
