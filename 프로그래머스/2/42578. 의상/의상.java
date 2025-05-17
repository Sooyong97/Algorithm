import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> cloth = new HashMap<>();
        for (String[] str : clothes) {
            List<String> list = cloth.getOrDefault(str[1], new ArrayList<>());
            list.add(str[0]);
            cloth.put(str[1], list);
        }
        
        if (cloth.keySet().size() == 1) {
            return cloth.values().iterator().next().size();
        }
        
        for (List<String> str : cloth.values()) {
            answer *= str.size() + 1;
        }
        
        return answer - 1;
    }
}