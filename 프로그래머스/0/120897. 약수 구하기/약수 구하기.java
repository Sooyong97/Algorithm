import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> divisors = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        return divisors.stream().mapToInt(i -> i).toArray();
    }
}
