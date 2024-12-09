import java.util.*;
import java.io.*;

public class Main {
    static class Alphabet implements Comparable<Alphabet> {
        int index;
        long weight;
        boolean zero;

        public Alphabet(int index) {
            this.index = index;
            this.weight = 0;
            this.zero = false;
        }

        public void not_Zero() {
            this.zero = true;
        }

        public void setWeight(long additional_weight) {
            this.weight += additional_weight;
        }

        @Override
        public int compareTo(Alphabet o) {
            return Long.compare(o.weight, this.weight); // 내림차순
        }

    }

    public static void main(String[] args) throws IOException {

        Alphabet[] alphabets = new Alphabet[10];
        for (int i = 0; i < 10; i++) {
            alphabets[i] = new Alphabet(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            strings[i] = s;

            long weight = 1;
            for (int j = s.length() - 1; j >= 0; j--, weight *= 10) {
                int index = s.charAt(j) - 'A';
                alphabets[index].setWeight(weight);
                if (j == 0) {
                    alphabets[index].not_Zero();
                }
            }
        }

        Arrays.sort(alphabets);
        int lastIndex = alphabets.length - 1;
        if (alphabets[lastIndex].zero) {
            for (int i = lastIndex - 1; i >= 0; i--) {
                if (!alphabets[i].zero) {
                    Alphabet temp = alphabets[i];
                    System.arraycopy(alphabets, i + 1, alphabets, i, lastIndex - i);
                    alphabets[lastIndex] = temp;
                    break;
                }
            }
        }

        int[] numbers = new int[10];
        int digit = 9;
        for (Alphabet alphabet : alphabets) {
            numbers[alphabet.index] = digit--;
        }

        long sum = 0;
        for (String s : strings) {
            long string_sum = 0;
            long weight = 1;
            for (int j = s.length() - 1; j >= 0; j--, weight *= 10) {
                int index = s.charAt(j) - 'A';
                string_sum += numbers[index] * weight;
            }
            sum += string_sum;
        }

        System.out.println(sum);

    }
}
