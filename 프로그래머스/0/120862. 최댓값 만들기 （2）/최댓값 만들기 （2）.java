import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        
        int maxP = numbers[n - 1] * numbers[n - 2];
        
        int maxM = numbers[0] * numbers[1];
        
        return Math.max(maxP, maxM);
    }
}
