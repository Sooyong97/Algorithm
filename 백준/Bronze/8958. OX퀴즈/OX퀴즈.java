import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s = br.readLine();
            int score = 0;
            int continueCount = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    score += continueCount;
                    continueCount++;
                }
                if (s.charAt(i) == 'X') continueCount = 1;
            }
            System.out.println(score);
        }
    }
}