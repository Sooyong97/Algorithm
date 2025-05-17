import java.util.*;

class Solution {
    public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            String str = q.poll();
            if (str.length() >= 5) continue;
            for (String vow : vowels) {
                q.add(str + vow);
                list.add(str + vow);
            }
        }
        
        list.sort(null);
        
        return list.indexOf(word) + 1;
    }
}