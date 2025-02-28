import java.io.*;
import java.util.*;

public class Main {
    static int total;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        total = A + B + C;

        visited = new boolean[total + 1][total + 1];
        System.out.println(bfs(A, B, C) ? 1 : 0);
    }

    static boolean bfs(int A, int B, int C) {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[]{A, B, C};
        Arrays.sort(start);
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == cur[1] && cur[1] == cur[2]) {
                return true;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if(cur[i] == cur[j]) continue;

                    int[] next = new int[3];
                    for (int k = 0; k < 3; k++) {
                        next[k] = cur[k];
                    }

                    if(cur[i] < cur[j]) {
                        next[i] = cur[i] + cur[i];
                        next[j] = cur[j] - cur[i];
                    } else {
                        next[j] = cur[j] + cur[j];
                        next[i] = cur[i] - cur[j];
                    }

                    Arrays.sort(next);
                    if(!visited[next[0]][next[1]]){
                        visited[next[0]][next[1]] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return false;
    }
}