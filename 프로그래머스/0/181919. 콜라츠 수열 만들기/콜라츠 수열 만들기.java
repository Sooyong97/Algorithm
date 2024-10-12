import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer_list = new ArrayList<>();
        answer_list.add(n);
        
        int i = 0;
        while (true){
            if (answer_list.get(i) == 1 ) break;
            
            if (answer_list.get(i) % 2 == 0){
                answer_list.add(answer_list.get(i)/2);
            }
            else{
                answer_list.add((answer_list.get(i) * 3) + 1);
            }
            i ++;
        }
        
        int[] answer = new int[answer_list.size()];
        for (int j = 0; j < answer_list.size(); j++){
            answer[j] = answer_list.get(j);
        }
        return answer;
    }
}