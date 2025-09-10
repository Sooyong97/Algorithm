import java.util.stream.*;

class Solution {
    public String solution(String my_string, int n) {
        return IntStream.range(0, my_string.length()).filter(i -> (i + 1) % n == 0).mapToObj(i -> String.valueOf(my_string.charAt(i))).collect(Collectors.joining());
    }
}
