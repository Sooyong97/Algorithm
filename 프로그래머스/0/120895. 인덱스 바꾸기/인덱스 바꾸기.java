import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder(my_string);
        
        char c1 = sb.charAt(num1);
        char c2 = sb.charAt(num2);
        
        sb.setCharAt(num1, c2);
        sb.setCharAt(num2, c1);
        
        return sb.toString();
    }
}