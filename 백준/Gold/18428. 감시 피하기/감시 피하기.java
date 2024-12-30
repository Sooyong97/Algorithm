import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static List<List<Integer>> teacher;
    static List<List<Integer>> student;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teacher = new ArrayList<>();
        student = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teacher.add(Arrays.asList(i, j));
                }
                if (map[i][j] == 'S') {
                    student.add(Arrays.asList(i, j));
                }
            }
        }

        System.out.println(solve() ? "YES" : "NO");
    }
    
    private static boolean solve() {
        return backtrack(0, 0, 0);
    }
    
    private static boolean backtrack(int row, int col, int count) {
        if (count == 3) {
            return isSafe();
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';  // 장애물 설치
                    if (backtrack(i, j + 1, count + 1)) {
                        return true;
                    }
                    map[i][j] = 'X';
                }
            }
        }
        return false;
    }
    
    private static boolean isSafe(){
        for (List<Integer> t : teacher) {
            int tRow = t.get(0);
            int tCol = t.get(1);
            
            for (int i = 0; i < 4; i++) {
                int nx = tRow;
                int ny = tCol;
                
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        break;
                    }
                    
                    if (map[nx][ny] == 'O') {
                        break;
                    }
                    
                    if (map[nx][ny] == 'S') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}