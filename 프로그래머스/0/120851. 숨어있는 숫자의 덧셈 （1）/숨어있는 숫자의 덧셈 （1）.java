import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] slist = my_string.split("");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(slist));
        
        for(String s: list){
                try{
                    int num = Integer.parseInt(s);
                    answer += num;
                }           
                catch (NumberFormatException e){
                    continue;
                }
            }
        
        return answer;
    }
}