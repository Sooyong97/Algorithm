import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String end = br.readLine();

        int[] st = new int[N];
        int[] ed = new int[N];

        for (int i = 0; i < N; i++) st[i] = start.charAt(i) - '0';
        for (int i = 0; i < N; i++) ed[i] = end.charAt(i) - '0';

        int[] stPushFirst = Arrays.copyOf(st, N);
        stPushFirst[0] = 1 - stPushFirst[0];
        stPushFirst[1] = 1 - stPushFirst[1];

        int count = count(st, ed);
        int count2 = count(stPushFirst, ed);
        if (count2 != -1) count2++;

        if(count == -1) {
            System.out.println(count2);
        } else if (count2 == -1) {
            System.out.println(count);
        } else {
            System.out.println(Math.min(count, count2));
        }


    }

    private static int count(int[] st, int[] end) {
        int count = 0;
        for (int i = 0; i < st.length - 1; i++) {
            if (st[i] != end[i]) {
                st[i] = 1 - st[i];
                st[i + 1] = 1 - st[i + 1];
                if (i < st.length - 2) st[i + 2] = 1 - st[i + 2];
                count++;
            }
        }
        if (st[st.length - 1] != end[st.length - 1]) return -1;
        return count;
    }
}
