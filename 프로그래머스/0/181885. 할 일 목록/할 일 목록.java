import java.util.ArrayList;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> remain_list = new ArrayList<>();
        for (int i = 0; i < todo_list.length; i++){
            if(finished[i] == false) remain_list.add(todo_list[i]);
        }
        String[] answer = new String[remain_list.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = remain_list.get(i);
        }
        return answer;
    }
}