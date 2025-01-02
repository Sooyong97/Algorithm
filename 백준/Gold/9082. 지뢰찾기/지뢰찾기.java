import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String numbs = br.readLine();
            String bombs = br.readLine();

            find_bombs(N, numbs);
        }
    }

    private static void find_bombs(int N, String numbs){
        int[] bombNum = new int[N];
        String[] bn = numbs.split("");
        for (int i = 0; i < numbs.length(); i++) {
            bombNum[i] = Integer.parseInt(bn[i]);
        }

        int count = 0;
        if (bombNum[0] != 0 && bombNum[1] != 0) {
            bombNum[0]--;
            bombNum[1]--;
            count++;
        }
        for (int i = 1; i < N - 1; i++){
            if (bombNum[i - 1] != 0 && bombNum[i] != 0 && bombNum[i + 1] != 0) {
                bombNum[i - 1]--;
                bombNum[i]--;
                bombNum[i + 1]--;
                count++;
            }
        }
        if (bombNum[N - 2] != 0 && bombNum[N - 1] != 0) {
            bombNum[N - 2]--;
            bombNum[N - 1]--;
            count++;
        }

        System.out.println(count);
    }
}
