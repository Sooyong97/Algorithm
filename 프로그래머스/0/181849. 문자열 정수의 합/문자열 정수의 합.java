class Solution {
    public int solution(String num_str) {
        int answer = 0;
        String[] num_arr = num_str.split("");
        for (int i = 0; i < num_arr.length; i++){
            answer += Integer.parseInt(num_arr[i]);
        }
        return answer;
    }
}