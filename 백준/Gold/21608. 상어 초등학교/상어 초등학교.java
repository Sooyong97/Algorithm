import java.util.*;
import java.io.*;

public class Main {

    static class Seat implements Comparable<Seat>{
        int x, y, favorites, empty;

        public Seat(int x, int y, int favorites, int empty) {
            this.x = x;
            this.y = y;
            this.favorites = favorites;
            this.empty = empty;
        }

        @Override
        public int compareTo(Seat o) {
            // 1. 좋아하는 학생 수
            if (favorites != o.favorites) return o.favorites - favorites;
            // 2. 비어있는 칸 수
            if (empty != o.empty) return o.empty - empty;
            // 3. 행
            if (x != o.x) return x - o.x;
            // 4. 열
            return y - o.y;
        }
    }

    static int N, sum;
    static int[] students;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static Map<Integer, Set<Integer>> favoritesStudents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 만족도
        sum = 0;
        map = new int[N][N];
        students = new int[N * N];
        favoritesStudents = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int numStudent = Integer.parseInt(st.nextToken());
            students[i] = numStudent;
            favoritesStudents.put(numStudent, new HashSet<>());
            // 각 학생별 좋아하는 학생
            for (int j = 0; j < 4; j++) {
                favoritesStudents.get(numStudent).add(Integer.parseInt(st.nextToken()));
            }
        }

        // 자리 배치
        for (int i = 0; i < students.length; i++) {
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }
        
        // 만족도 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = getStudent(i, j, map[i][j]);
                if (count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

        System.out.println(sum);
    }

    // 자리 찾기
    private static Seat findSeat(int student) {
        Seat seat = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이미 학생이 있으면
                if (map[i][j] > 0) {
                    continue;
                }

                // 현재 위치에서 Seat
                Seat cur = new Seat(i, j, getStudent(i, j, student), getEmpty(i, j));
                if (seat == null) {
                    seat = cur;
                    continue;
                }

                // 자리별 조건 비교
                if (seat.compareTo(cur) > 0) {
                    seat = cur;
                }
            }
        }
        return seat;
    }

    // 인접한 좋아하는 학생 수
    private static int getStudent(int x, int y, int student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (favoritesStudents.get(student).contains(map[nx][ny])) {
                count++;
            }
        }
        return count;
    }

    // 인접한 빈칸 수
    private static int getEmpty(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }
}