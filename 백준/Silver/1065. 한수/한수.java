import java.util.*;

public class Main {

    public static int count;

    public static void find_seq(int i){
        String str = String.valueOf(i);

        if (str.length() == 1 || str.length() == 2) {
            count++;
        }else {
            for (int j = 0; j < str.length() - 2; j++) {
                if ((int)str.charAt(j+2) - (int)str.charAt(j+1) != (int)str.charAt(j+1) - (int)str.charAt(j)) {
                    return;
                }
            }
            count++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();

        count = 0;
        int i = Integer.parseInt(N);

        for (int j = 1; j <= i; j++) {
            find_seq(j);
        }

        System.out.println(count);

        sc.close();
    }
}
