class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String map_over = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder paddedMap = new StringBuilder();

            for (int j = 0; j < n - map_over.length(); j++) {
                paddedMap.append("0");
            }
            paddedMap.append(map_over);

            map_over = paddedMap.toString().replace("1", "#").replace("0", " ");

            answer[i] = map_over;
        }

        return answer;
    }
}