import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr1 : intervals) {
            int start = arr1[0];
            int end = arr1[arr1.length -1];
            for (int i = start ; i <= end; i++) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}