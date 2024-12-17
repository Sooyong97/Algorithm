import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        while (T.length() > S.length()) {

            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            }

            else if (T.charAt(T.length() - 1) == 'B') {
                T = T.substring(0, T.length() - 1);
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }

        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
