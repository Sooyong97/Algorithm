import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));

        for (String s : list) {
            System.out.println(s);
        }
    }
}