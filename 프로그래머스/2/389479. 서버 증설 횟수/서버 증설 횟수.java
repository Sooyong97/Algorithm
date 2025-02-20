import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        int servers = 0;    
    
        for (int i = 0; i < 24; i++) {
            if (players[i] - (servers * m) >= m) {
                int adds = (players[i] - servers * m) / m;
                servers += adds;
                answer += adds;
                que.add(new int[] {i + k - 1, adds});
            }
            
            if(!que.isEmpty()) {
                int[] cur = que.peek();
                int rmTime = cur[0];
                int rmServer = cur[1];
                if (rmTime == i) {
                    que.poll();
                    servers -= rmServer;
                }
            }
            
        }
        
        return answer;
    }
}