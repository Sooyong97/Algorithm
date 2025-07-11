import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] line = new int[201];
        
        for (int[] arr : lines) {
            for (int i = arr[0] + 100; i < arr[1] + 100; i++) {
                line[i]++;
            }
        }
        
        for (int i : line) {
            if(i > 1) answer++;
        }
        
        
        return answer;
    }
}