import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> grade = new HashMap<>();
        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);

        Double scale = 0.0;
        Double grades = 0.0;

        for (int i = 0; i < 20; i++) {
            String s = br.readLine();
            String[] score = s.split(" ");

            if (score[2].equals("P")) continue;
            grades += Double.parseDouble(score[1]) * grade.get(score[2]);
            scale += Double.parseDouble(score[1]);
        }

        System.out.printf("%.6f\n", grades / scale);
    }
}