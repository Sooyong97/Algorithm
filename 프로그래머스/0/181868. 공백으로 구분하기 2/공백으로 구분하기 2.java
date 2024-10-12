import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] splitArray = my_string.split(" ");
        ArrayList<String> my_string_list = new ArrayList<>(Arrays.asList(splitArray));
        my_string_list.removeIf(str -> str.equals(""));
        String[] answer = my_string_list.toArray(new String[0]);

        return answer;
    }
}