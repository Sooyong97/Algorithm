class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String babb : babbling){
            if (babb.contains("ayaaya") || babb.contains("yeye") || babb.contains("woowoo") || babb.contains("mama")) {
                continue;
            }
            babb = babb.replace("aya", " ");
            babb = babb.replace("ye", " ");
            babb = babb.replace("woo", " ");
            babb = babb.replace("ma", " ");
            babb = babb.replace(" ", "");
            
            if (babb.equals("")){
                answer += 1;
            }
            
        }
        return answer;
    }
}