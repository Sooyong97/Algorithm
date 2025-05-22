import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isValid(s, i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(String s, int offset) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt((i + offset) % n);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char p = stack.pop();
                if ((c == ')' && p != '(') ||
                    (c == '}' && p != '{') ||
                    (c == ']' && p != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}