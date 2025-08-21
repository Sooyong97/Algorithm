class Solution {
    public int solution(int n) {
        int answer = 0;
        int w = 1_000_000;
        while (w > 0) {
            answer += n / w;
            n %= w;
            w /= 10;
        }
        
        return answer;
    }
}