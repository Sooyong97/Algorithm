import java.io.*;
import java.util.*;

public class Main {

    private static void findPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrome ? "yes" : "no");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            findPalindrome(s);
        }
    }
}