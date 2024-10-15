class Solution {
    public boolean is_prime_num(int num){
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i ++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i <= n; i++){
            if (is_prime_num(i)) answer += 1;
        }
        return answer;
    }
}