import java.io.*;
import java.util.*;

public class Main {
    static int[][] wordcups = new int[6][3];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            answer = 0;

            for (int j = 0; j < 18; j++)
                wordcups[j / 3][j % 3] = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for(int j=0;j<6;j++) {
                if(wordcups[j][0] + wordcups[j][1] + wordcups[j][2] != 5) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                search(0, 1);
            sb.append(answer).append(" ");
        }
        System.out.print(sb);
    }

    private static void search(int idx, int nxt) {
        if (answer == 1)
            return;

        if (idx == 5) {
            answer = 1;
            return;
        }

        if (wordcups[idx][0] > 0 && wordcups[nxt][2] > 0) {
            wordcups[idx][0]--;
            wordcups[nxt][2]--;
            if (nxt == 5) {
                search(idx + 1, idx + 2);
            }else
                search(idx, nxt + 1);
            wordcups[idx][0]++;
            wordcups[nxt][2]++;
        }

        if (wordcups[idx][1] > 0 && wordcups[nxt][1] > 0) {
            wordcups[idx][1]--;
            wordcups[nxt][1]--;
            if (nxt == 5) {
                search(idx + 1, idx + 2);
            }else
                search(idx, nxt + 1);
            wordcups[idx][1]++;
            wordcups[nxt][1]++;
        }

        if (wordcups[idx][2] > 0 && wordcups[nxt][0] > 0) {
            wordcups[idx][2]--;
            wordcups[nxt][0]--;
            if (nxt == 5) {
                search(idx + 1, idx + 2);
            }else
                search(idx, nxt + 1);
            wordcups[idx][2]++;
            wordcups[nxt][0]++;
        }

    }
}