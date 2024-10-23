class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        while (true){
            char s_first = sb.charAt(0);
            int num_first = 1;
            int num_second = 0;
            boolean del = false;
            for(int i = 1; i < sb.length(); i++){
                if(sb.charAt(i) == s_first){
                    num_first++;
                }
                else{
                    num_second++;
                }
                if(num_first == num_second){
                    answer++;
                    sb.delete(0,i+1);
                    del = true;
                    break;
                }
            }
            if (!del){
                answer++;
                break;
            }
            if (sb.length() <= 1){
                if(sb.length() == 1){
                    answer += 1;
                }
                break;
            }
        }
        return answer;
    }
}