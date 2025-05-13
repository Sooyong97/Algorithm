import java.util.*;

class Solution {
    
    static final int maxVal = 10_000_001;
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] arr = new int[maxVal];
        
        for (int i : tangerine) {
            arr[i]++;
        }
        
        Arrays.sort(arr);
        
        int size = 0;
        int idx = maxVal - 1;
        
        while(size < k) {
            size += arr[idx];
            answer++;
            idx--;
        }
        
        return answer;
    }
}