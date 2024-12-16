class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int count = 0;
        
        int st = h1 * 3600 + m1 * 60 + s1;
        int ed = h2 * 3600 + m2 * 60 + s2;
        
        for (int i = st; i < ed; i++) {
            double[] now = getDegree(i);
            double[] next = getDegree(i+1);
            
            boolean hMatch = check(now, next, 0);
            boolean mMatch = check(now, next, 1);
            
            if (hMatch && mMatch) {
                if (Double.compare(next[0], next[1]) == 0) count++;
                else count += 2;
            } else if (hMatch || mMatch) count++;
        }
        
        if (st == 0 || st == 43200) count++;
        
        return count;
    }
    
    private static double[] getDegree(int timeSec) {
        int[] time = secToHour(timeSec);
        double[] degree = new double[3];
        degree[0] = (time[0] % 12) * 30d + time[1] * 0.5d + time[2] * (1 / 120d);
        degree[1] = time[1] * 6d + time[2] * 0.1d;
        degree[2] = time[2] * 6d;
        return degree;
    }
    
    private static int[] secToHour(int timeSec) {
        int[] time = new int[3];
        time[0] = timeSec / 3600;
        time[1] = (timeSec % 3600) / 60;
        time[2] = (timeSec % 3600) % 60;
        return time;
    }
    
    private static boolean check(double[] now, double[] next, int hm) {
        if (Double.compare(now[hm], now[2]) > 0 && Double.compare(next[hm], next[2]) <= 0) return true;
        if (Double.compare(now[2], 354d) == 0 && Double.compare(now[hm], 354d) > 0) return true;
        return false;
    }
}