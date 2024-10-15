import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> name_yearn = new HashMap<>();
        for (int i = 0; i < name.length; i++){
            name_yearn.put(name[i], yearning[i]);
        }
        for (int i = 0; i < answer.length; i++){
            int sum_yearn = 0;
            for (int j = 0; j < photo[i].length; j++){
                try{sum_yearn += name_yearn.get(photo[i][j]);}
                catch(NullPointerException e){}
            }
            answer[i] = sum_yearn;
        }
        return answer;
    }
}