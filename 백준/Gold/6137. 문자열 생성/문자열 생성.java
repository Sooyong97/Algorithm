import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] S = new char[N];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine().charAt(0);
        }

        int left = 0, right = N - 1;
        StringBuilder T = new StringBuilder();

        while (left <= right) {
            boolean chooseLeft = false;
            int l = left, r = right;

            while (l <= r) {
                if (S[l] < S[r]) {
                    chooseLeft = true;
                    break;
                } else if (S[l] > S[r]) {
                    break;
                }
                l++;
                r--;
            }

            if (chooseLeft) {
                T.append(S[left++]);
            } else {
                T.append(S[right--]);
            }
        }

        for (int i = 0; i < T.length(); i++) {
            System.out.print(T.charAt(i));
            if ((i + 1) % 80 == 0) {
                System.out.println();
            }
        }
    }
}