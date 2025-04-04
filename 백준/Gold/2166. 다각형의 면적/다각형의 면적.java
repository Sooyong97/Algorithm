import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double calArea(List<Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            sum += (p1.x * p2.y) - (p2.x * p1.y);
        }
        return Math.abs(sum) / 2.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }

        double area = calArea(points);
        String formattedArea = String.format("%.1f", area);
        System.out.println(formattedArea);
    }
}