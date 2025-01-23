import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] alphabets = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            alphabets[i] = s;
        }

        solve(alphabets);
    }

    private static void solve(String[] alphabets) {
        int max = 0;
        int[] alphabetWeights = new int[26];
        for (String alphabet : alphabets) {
            int weight = (int) Math.pow(10, alphabet.length() - 1);
            for (int j = 0; j < alphabet.length(); j++) {
                alphabetWeights[alphabet.charAt(j) - 'A'] += weight;
                weight /= 10;
            }
        }

        Arrays.sort(alphabetWeights);

        int numb = 9;
        for (int i = alphabetWeights.length - 1; i >= 0; i--) {
            if (alphabetWeights[i] == 0) break;
            max += alphabetWeights[i] * numb;
            numb--;
        }

        System.out.println(max);
    }
}
