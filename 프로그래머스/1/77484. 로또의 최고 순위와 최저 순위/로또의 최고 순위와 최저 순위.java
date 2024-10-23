class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int num_zero = 0;
        int num_fit = 0;
        for (int nums : win_nums){
            for (int i : lottos){
                if (i == nums){
                    num_fit += 1;
                }
            }
        }
        for (int nums : lottos){
            if (nums == 0){
                num_zero += 1;
            }
        }
        
        answer[0] = ((7 - (num_fit + num_zero)) >= 6) ? 6 : (7 - (num_fit + num_zero));
        answer[1] = (7 - num_fit) >= 6 ? 6 : (7 - num_fit); 
        
        return answer;
    }
}