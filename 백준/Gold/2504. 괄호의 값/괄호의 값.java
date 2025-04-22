import java.io.*;
import java.util.*;

public class Main {

    private static void solve(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        int sum = 0;
        int counts = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                counts *= 2;
            }
            if (c == '[') {
                stack.push(c);
                counts *= 3;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = true;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    sum += counts;
                }
                stack.pop();
                counts /= 2;
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = true;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    sum += counts;
                }
                stack.pop();
                counts /= 3;
            }
            if (c != '(' && c !='[' && c !=')' && c != ']') {
                flag = true;
                break;
            }
        }

        if (flag || !stack.isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.print(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solve(s);
    }
}