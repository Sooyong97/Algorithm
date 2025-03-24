import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }

        int num = 0, index = 0;
        for (int i = 0; i < 3; i++) {
            try {
                num = Integer.parseInt(arr[i]);
                index = i;
            }
            catch (NumberFormatException e) {
            }
        }

        num += 3 - index;
        if (num % 15 == 0) System.out.println("FizzBuzz");
        else if (num % 3 == 0) System.out.println("Fizz");
        else if (num % 5 == 0) System.out.println("Buzz");
        else System.out.println(num);
    }
}