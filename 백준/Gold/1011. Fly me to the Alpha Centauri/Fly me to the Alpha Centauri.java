import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            int dist = y - x;
            int maxSpeed = (int) Math.sqrt(dist);

            if (maxSpeed * maxSpeed == dist) {
                System.out.println(2 * maxSpeed - 1);
            } else if (dist <= maxSpeed * maxSpeed + maxSpeed) {
                System.out.println(2 * maxSpeed);
            } else {
                System.out.println(2 * maxSpeed + 1);
            }
        }
    }
}