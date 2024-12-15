class Solution {
    
    static class Time implements Comparable<Time> {
        int min;
        int sec;
        
        public Time(int min, int sec) {
            this.min = min;
            this.sec = sec;
        }
        
        public void nextTime() {
            this.sec += 10;
            if (this.sec > 59) {
                this.min += 1;
                this.sec -= 60;
            }
        }
        
        public void prevTime() {
            this.sec -= 10;
            if (this.sec < 0) {
                if (this.min == 0) {
                    this.min = 0;
                    this.sec = 0;
                } else {
                    this.min -= 1;
                    this.sec += 60;
                }
            }
        }
        
        public void setTime(Time o) {
            this.min = o.min;
            this.sec = o.sec;
        }
        
        @Override
        public int compareTo(Time o) {
            if (this.min == o.min) {
                return this.sec - o.sec;
            }
            return this.min - o.min;
        }
        
        public boolean isGreaterOrEquals(Time o) {
            return this.compareTo(o) >= 0;
        }
        public boolean isLessOrEquals(Time o) {
            return this.compareTo(o) <= 0;
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Time time = new Time(Integer.parseInt(pos.split(":")[0]), Integer.parseInt(pos.split(":")[1]));
        Time video = new Time(Integer.parseInt(video_len.split(":")[0]), Integer.parseInt(video_len.split(":")[1]));
        Time op = new Time(Integer.parseInt(op_start.split(":")[0]), Integer.parseInt(op_start.split(":")[1]));
        Time ed = new Time(Integer.parseInt(op_end.split(":")[0]), Integer.parseInt(op_end.split(":")[1]));
        
        for (String command : commands) {
            if (command.equals("prev")) {
                if (checkOp(time, op, ed)) time.setTime(ed);
                time.prevTime();
            }
            if (command.equals("next")) {
                if (checkOp(time, op, ed)) time.setTime(ed);
                time.nextTime();
                if (time.isGreaterOrEquals(video)) time.setTime(video);
            }
        }
        if (checkOp(time, op, ed)) time.setTime(ed);
        
        return String.format("%02d:%02d", time.min, time.sec);
    }
    
    private static boolean checkOp(Time time, Time op, Time ed) {
        return time.isGreaterOrEquals(op) && time.isLessOrEquals(ed);
    }
}