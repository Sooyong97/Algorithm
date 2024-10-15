class Solution {
    public String solution(int a, int b) {
        String[] day_of_week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int tot_day = 0;
        for(int i = 1; i < a; i++){
            tot_day += days[i];
        }
        tot_day += b;
        int day_index = (tot_day + 4) % 7;
        return day_of_week[day_index];
    }
}