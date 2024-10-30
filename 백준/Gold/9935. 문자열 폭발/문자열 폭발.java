import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String remove_s = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            result.append(c);

            if (result.length() >= remove_s.length() &&
                result.substring(result.length() - remove_s.length()).equals(remove_s)) {
                result.setLength(result.length() - remove_s.length());
            }
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(result.toString());
        }

        sc.close();
    }
}
