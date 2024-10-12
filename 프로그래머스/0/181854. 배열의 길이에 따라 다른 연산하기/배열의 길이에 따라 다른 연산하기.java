class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = {};
        int len_arr = arr.length;
        if (len_arr % 2 == 0){
            for (int i=1; i < len_arr; i += 2){
                arr[i] += n;
            }
        }
        else{
            for (int i=0; i <= len_arr; i += 2){
                arr[i] += n;
            }
        }
        return arr;
    }
}