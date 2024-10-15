import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        for(int i = 0; i < answers.length; i++){
            if (answers[i] == student1[i%5]) score[0] += 1;
            if (answers[i] == student2[i%8]) score[1] += 1;
            if (answers[i] == student3[i%10]) score[2] += 1;
        }
        
        int max_score = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> max_list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++){
            if (score[i] == max_score) max_list.add(i+1);
        }
        
        int[] answer = new int[max_list.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = max_list.get(i);
        }
        
        return answer;
    }
}