import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String moved = s.substring(i) + s.substring(0, i);
            if (isAble(moved)) answer++;
        }
        
        return answer;
    }
    
    static boolean isAble(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char p = stack.pop();
                if (c == ')' && p != '(') return false;
                if (c == '}' && p != '{') return false;
                if (c == ']' && p != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}