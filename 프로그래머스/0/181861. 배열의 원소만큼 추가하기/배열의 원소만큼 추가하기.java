import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer_list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i]; j++){
                answer_list.add(arr[i]);
            }
        }
        
        int[] answer = new int[answer_list.size()];
        for (int i = 0; i < answer.length; i ++){
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}