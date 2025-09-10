import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        String str_rmAlpha = my_string.replaceAll("[a-zA-Z]", "");
        
        int[] answer = new int[str_rmAlpha.length()];
        int idx = 0;
        for (char c : str_rmAlpha.toCharArray()) {
            answer[idx++] = c - '0';
        }
        Arrays.sort(answer);
        
        return answer;
    }
}