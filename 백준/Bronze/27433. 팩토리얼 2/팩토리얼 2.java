import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = factorial(n);
        System.out.println(result);
    }

    static long factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return factorial(n - 1) * n;
    }
}
