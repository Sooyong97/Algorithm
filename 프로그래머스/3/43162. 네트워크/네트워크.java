import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            int[] com = computers[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (com[j] == 1) graph[i].add(j);
            }
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                visited[cur] = true;
                for (int connected : graph[cur]) {
                    if (visited[connected]) continue;
                    q.add(connected);
                }
            }
        }
        
        return answer;
    }
}