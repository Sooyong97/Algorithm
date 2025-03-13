import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String P = br.readLine();
        String S = br.readLine();

        int count = 0;
        while (!S.equals("")) {
            for (int i = S.length(); i > 0; i--) {
                String partOfS = S.substring(0, i);
                if (P.contains(partOfS)) {
                    S = S.replaceFirst(partOfS, "");
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}