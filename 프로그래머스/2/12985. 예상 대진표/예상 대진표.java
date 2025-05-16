import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        while (true) {
            if (Math.abs(a - b) == 1 && Math.max(a, b) % 2 == 0) break;
            a = (int) Math.round((double) a / 2d);
            b = (int) Math.round((double) b / 2d);
            round++;
        }

        return round;
    }
}