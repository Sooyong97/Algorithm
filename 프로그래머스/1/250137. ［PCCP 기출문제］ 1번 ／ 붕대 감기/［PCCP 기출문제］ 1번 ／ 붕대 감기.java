import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int prev = 0;
        int max_health = health;
        for (int[] attack : attacks) {
            int now = attack[0];
            int count = now - prev - 1;
            health += count * bandage[1] + ((int) (count / bandage[0]) * bandage[2]);
            if (health > max_health) health = max_health;
            health -= attack[1];
            prev = now;
            if (health <= 0) return -1;
        }
        
        return health;
    }
}