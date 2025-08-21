class Solution {
    public int solution(int n) {
        int answer = 1;
        int count;

        for (int i = 2; i * i <= n; i++) {
            count = 0;
            while (n % i == 0) {
                n /= i;
                count++;
            }
            if (count > 0) answer *= (count + 1);
        }

        if (n > 1) answer *= 2;

        return answer;
    }
}
