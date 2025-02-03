import java.util.*;
import java.io.*;

public class Main {

    static final String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] alphabets = new char[C];
        boolean[] visited = new boolean[C];

        String s = br.readLine().replace(" ", "");
        for (int i = 0; i < C; i++) {
            alphabets[i] = s.charAt(i);
        }

        Arrays.sort(alphabets);
        combination(alphabets, visited, 0, C, L);
    }

    private static void combination(char[] alphabets, boolean[] visited, int start, int C, int L) {
        if (L == 0) {
            combiPrint(alphabets, visited, C);
        }
        for (int i = start; i < C; i++) {
            visited[i] = true;
            combination(alphabets, visited, i + 1, C, L - 1);
            visited[i] = false;
        }
    }

    private static void combiPrint(char[] alphabets, boolean[] visited, int C) {
        StringBuilder sb = new StringBuilder();
        int countVowel = 0;
        int countConsonant = 0;
        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                sb.append(alphabets[i]);
                if (vowels.indexOf(alphabets[i]) != -1) countVowel++;
                else countConsonant++;
            }
        }
        if (countVowel > 0 && countConsonant > 1) {
            System.out.println(sb);
        }
    }
}