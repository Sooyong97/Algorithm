import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palindrome = sc.nextLine();
        String reversed = new StringBuilder(palindrome).reverse().toString();

        if(palindrome.equals(reversed)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}
