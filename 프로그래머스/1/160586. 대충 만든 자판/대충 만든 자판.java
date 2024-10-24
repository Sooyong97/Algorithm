import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> keys = new HashMap<>();
        
        for (String s : keymap){
            for (int i = 0; i < s.length(); i++){
                if(!keys.containsKey(s.charAt(i))){
                    keys.put(s.charAt(i), i + 1);
                }
                else{
                    if(i + 1 < keys.get(s.charAt(i))){
                        keys.put(s.charAt(i), i + 1);
                    }
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++){
            int sum_keys = 0;
            boolean isValid = true;
            
            for (int j = 0; j < targets[i].length(); j++){
                char c = targets[i].charAt(j);
                
                if (!keys.containsKey(c)) {
                    isValid = false;
                    break;
                }
                
                sum_keys += keys.get(c);
            }
            
            answer[i] = isValid ? sum_keys : -1;
        }
        
        return answer;
    }
}