import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 중복 허용 우선순위 큐 두 개 사용
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (cmd.equals("D")) {
                    if (map.isEmpty()) continue;

                    if (num == 1) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else {
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}