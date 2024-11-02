import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        BigInteger num1 = new BigInteger(n.split(" ")[0]);
        BigInteger num2 = new BigInteger(n.split(" ")[1]);

        System.out.println(num1.divide(num2));
        System.out.println(num1.remainder(num2));
    }
}
