class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        for (int h = n; h >= 1; h--) {
            int count = 0;
            for (int c : citations) {
                if (c >= h) count++;
            }
            
            if (count >= h) {
                return h;
            }
        }
        return answer;
    }
}