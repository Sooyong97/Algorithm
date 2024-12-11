import java.util.*;

class Solution {
    
    private static long find_time(int[] diffs, int[] times, int level, long limit) {
        long tot_time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                tot_time += times[i];
            } else {
                tot_time += (times[i] * (diffs[i] - level + 1)) + (times[i - 1] * (diffs[i] - level));
            }
            if (tot_time > limit) {
                return limit + 1;
            }
        }
        return tot_time;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1;
        int maxLevel = Arrays.stream(diffs).max().orElse(1);
        int level = maxLevel;

        while (minLevel <= maxLevel) {
            int midLevel = (minLevel + maxLevel) / 2;
            long timeAtMid = find_time(diffs, times, midLevel, limit);

            if (timeAtMid <= limit) {
                level = midLevel;
                maxLevel = midLevel - 1;
            } else {
                minLevel = midLevel + 1;
            }
        }

        return level;
    }
}