import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        long l = right - left + 1;
        int[] answer = new int[(int) l];
        
        int idx = 0;
        for (long i = left; i <= right; i++, idx++) {
            long x = i % (long) n;
            long y = i / (long) n;
            answer[idx] = Math.max((int) x, (int) y) + 1;
        }
        
        return answer;
    }
}