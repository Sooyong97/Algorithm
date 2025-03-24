import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new String[]{st.nextToken(), st.nextToken()});
        }

        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for (String[] people : list) {
            System.out.println(people[0] + " " + people[1]);
        }
    }
}