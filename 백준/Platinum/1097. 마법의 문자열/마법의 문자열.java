import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static String[] words;

    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    private static void solution() {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        List<String> T = new ArrayList<>();
        initT(wordList, T, new StringBuilder());

        answer = 0;
        for (String Ti : T) {
            if (isMagicWord(Ti)) {
                answer++;
            }
        }
    }

    private static void initT(List<String> wordList, List<String> T, StringBuilder sb) {
        if (wordList.size() == 0) {
            T.add(sb.toString());
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.remove(i);
            int sbLength = sb.length();
            initT(wordList, T, sb.append(word));
            sb.delete(sbLength, sbLength + word.length() + 1);
            wordList.add(i, word);
        }
    }

    private static boolean isMagicWord(String word) {
        int equalCount = 0;
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(i) + word.substring(0, i);
            if (word.equals(newWord)) {
                equalCount++;
            }
        }
        return equalCount == K;
    }

    private static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            words = new String[N];
            for (int i = 0; i < words.length; i++) {
                words[i] = br.readLine();
            }
            K = Integer.parseInt(br.readLine());
        }
    }

    private static void output() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(answer + "\n");
            bw.flush();
        }
    }
}