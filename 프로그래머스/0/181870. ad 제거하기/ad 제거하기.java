import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> str_list = new ArrayList<>();
        for (String x : strArr){
            if (x.contains("ad")){
                continue;
            }
            else{
                str_list.add(x);
            }
        }
        String[] answer = str_list.toArray(new String[0]);
        return answer;
    }
}