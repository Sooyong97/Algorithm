import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int result = checkPalindrome(s, 0, s.length() - 1, false);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int checkPalindrome(String str, int left, int right, boolean skipped) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                if (skipped) {
                    return 2;
                }

                if (checkPalindrome(str, left + 1, right, true) == 0 ||
                        checkPalindrome(str, left, right - 1, true) == 0) {
                    return 1;
                }

                return 2;
            }
            left++;
            right--;
        }
        return 0;
    }
}