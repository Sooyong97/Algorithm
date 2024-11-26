import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> stack_left = new Stack<String>();
        Stack<String> stack_right = new Stack<String>();

        String[] arr = str.split("");
        for (String s : arr) {
            stack_left.push(s);
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch(c) {
                case 'L':
                    if(!stack_left.isEmpty())
                        stack_right.push(stack_left.pop());

                    break;
                case 'D':
                    if(!stack_right.isEmpty())
                        stack_left.push(stack_right.pop());

                    break;
                case 'B':
                    if(!stack_left.isEmpty()) {
                        stack_left.pop();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    stack_left.push(String.valueOf(t));
                    break;
                default:
                    break;
            }

        }

        while(!stack_left.isEmpty()){
            stack_right.push(stack_left.pop());
        }
        while(!stack_right.isEmpty()){
            bw.write(stack_right.pop());
        }

        bw.flush();
        bw.close();
    }
}