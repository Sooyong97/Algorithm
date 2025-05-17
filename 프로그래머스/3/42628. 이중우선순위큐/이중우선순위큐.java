import java.util.*;

class Solution {
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String str = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (str.equals("I")) insertQ(value);
            if (str.equals("D")) deleteQ(value);
        }
        
        int maxVal = maxQ.isEmpty() ? 0 : maxQ.poll();
        int minVal = minQ.isEmpty() ? 0 : minQ.poll();
        
        return new int[]{maxVal, minVal};
    }
    
    static void insertQ(int val) {
        maxQ.add(val);
        minQ.add(val);
    }
    
    static void deleteQ(int val) {
        if (val == 1 && !maxQ.isEmpty()) {
            int maxVal = maxQ.poll();
            minQ.remove(maxVal);
        }
        if (val == -1 && !minQ.isEmpty()) {
            int minVal = minQ.poll();
            maxQ.remove(minVal);
        }
    }
}