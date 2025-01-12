import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] Croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String c : Croatia) {
            if (s.contains(c)) s = s.replace(c, "#");
        }
        System.out.println(s.length());
    }
}
