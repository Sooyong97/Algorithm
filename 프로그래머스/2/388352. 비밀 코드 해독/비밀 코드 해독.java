import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] numbers = IntStream.rangeClosed(1, n).toArray();
        boolean[] visited = new boolean[n];
        List<int[]> secretCodes = combination(numbers, visited, 0, 5);
        
        boolean check;
        for (int[] secret : secretCodes) {
            check = false;
            for (int i = 0; i < q.length; i++) {
                if (!checkArrays(secret, q[i], ans[i])) {
                    check = true;
                    break;
                }
            }
            if(!check) answer += 1;
        }
        
        return answer;
    }
    
    public static List<int[]> combination(int[] arr, boolean[] visited, int start, int n) {
        List<int[]> result = new ArrayList<>();
        
        if (n == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) temp.add(arr[i]);
            }
            
            result.add(temp.stream().mapToInt(Integer::intValue).toArray());
            return result;
        }
        
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            result.addAll(combination(arr, visited, i + 1, n - 1));
            visited[i] = false;
        }
        
        return result;
    }
    
    public static boolean checkArrays(int[] arr1, int[] arr2, int count) {
        Set<Integer> set = new HashSet<>();
        int c = 0;
        
        for (int num : arr1) {
            set.add(num);
        }
        
        for (int num : arr2) {
            if (set.contains(num)) {
                c++;
                set.remove(num);
            }
            if (c > count) return false;
        }
        
        if (c == count) return true;
        
        return false;
    }
    
}