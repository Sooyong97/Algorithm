import java.util.*;

public class Main {

    static class Date {
        int year;
        int month;
        int day;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int subtract(Date o) {
            if (this.year - o.year > 1000 ||
                    (this.year - o.year == 1000 && this.month > o.month) ||
                    (this.year - o.year == 1000 && this.month == o.month && this.day >= o.day)) {
                return -1;
            }

            int start = o.toDay();
            int end = this.toDay();

            return end - start;
        }

        private int toDay() {
            int daysFromYear = yearToDay();
            int daysFromMonth = monthToDay();
            return daysFromYear + daysFromMonth + this.day;
        }

        private int yearToDay() {
            int year = this.year - 1;
            return year * 365 + year / 4 - year / 100 + year / 400;
        }

        private int monthToDay() {
            int daySum = 0;
            for (int i = 1; i < this.month; i++) {
                daySum += this.days[i];
            }

            if (this.month > 2 && isLeapYear(this.year)) {
                daySum += 1;
            }
            return daySum;
        }

        private boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Date start = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Date end = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int diff = end.subtract(start);
        if (diff == -1) {
            System.out.println("gg");
        } else {
            System.out.println("D-"+diff);
        }
    }
}