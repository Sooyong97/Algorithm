import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        List<Character> alphaSet = new ArrayList<>();
        for (char c : alpha){
            alphaSet.add(c);
        }
        
        for (int i = 0; i < skip.length(); i++) {
            alphaSet.remove(Character.valueOf(skip.charAt(i)));
        }
        
        for (int i = 0; i < s.length(); i++) {
            int index_s = alphaSet.indexOf(s.charAt(i)); 
            index_s = (index_s + index) % alphaSet.size();
            answer.append(alphaSet.get(index_s));
        }
        
        return answer.toString();
    }
}