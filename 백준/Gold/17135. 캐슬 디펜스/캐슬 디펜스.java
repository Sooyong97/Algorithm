import java.util.*;
import java.io.*;

public class Main {

    static int N, M, D;
    static int[][] map;
    static int dead, deleted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    static void solve() {
        List<int[][]> archers = placeArchers();
        deleted = 0;

        for (int[][] board : archers) {
            int turn = N;
            dead = 0;
            while (turn-- > 0) {
                attack(board);
                board = move(board);
            }
            deleted = Math.max(deleted, dead);
        }

        System.out.println(deleted);
    }

    // 궁수 배치별로 맵
    static List<int[][]> placeArchers() {
        List<int[][]> archers = new ArrayList<>();
        List<int[]> combs = combination();

        for (int[] cols : combs) {
            int[][] newMap = new int[N + 1][M];
            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }
            // 궁수 위치(2)
            newMap[N][cols[0]] = 2;
            newMap[N][cols[1]] = 2;
            newMap[N][cols[2]] = 2;
            archers.add(newMap);
        }

        return archers;
    }

    // M개 중 3개 조합 생성
    static List<int[]> combination() {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= M - 3; i++) {
            for (int j = i + 1; j <= M - 2; j++) {
                for (int k = j + 1; k <= M - 1; k++) {
                    result.add(new int[]{i, j, k});
                }
            }
        }
        return result;
    }

    static void attack(int[][] board) {
        Set<String> targets = new HashSet<>();

        // 각 궁수마다 가장 가까운 적 찾기
        for (int c = 0; c < M; c++) {
            if (board[N][c] != 2) continue;

            int bestDist = D + 1;
            int targetR = -1, targetC = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 1) continue;
                    int dist = Math.abs(N - i) + Math.abs(c - j);
                    if (dist > D) continue;

                    // 거리 우선 -> 인덱스 작은 순
                    if (dist < bestDist || (dist == bestDist && j < targetC)) {
                        bestDist = dist;
                        targetR = i;
                        targetC = j;
                    }
                }
            }

            if (targetR != -1) {
                targets.add(targetR + " " + targetC);
            }
        }

        // 중복 없이 제거
        for (String key : targets) {
            StringTokenizer st = new StringTokenizer(key);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 0;
            dead++;
        }
    }

    // 적이 아래로 이동
    static int[][] move(int[][] board) {
        int[][] next = new int[N + 1][M];
        for (int i = N - 1; i >= 0; i--) {
            next[i + 1] = board[i].clone();
        }
        next[N] = board[N].clone();
        return next;
    }
}