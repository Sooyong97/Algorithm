import java.util.*;

class Solution {
    static int n, m;
    static char[][] map;
    static boolean[][] outsideConnected; // 외곽과 연결된 빈 공간 체크
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (String req : requests) {
            char alphabet = req.charAt(0);
            if (req.length() == 1) {
                markOutsideConnected(); // 외곽과 연결된 빈 공간 먼저 찾기
                remove(alphabet);
            } else {
                removeAll(alphabet);
            }
        }

        return countContainers();
    }

    private static void markOutsideConnected() {
        outsideConnected = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // **외곽에서 시작하여 BFS 실행**
        for (int i = 0; i < n; i++) {
            if (map[i][0] == '.') queue.offer(new int[]{i, 0});
            if (map[i][m - 1] == '.') queue.offer(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            if (map[0][j] == '.') queue.offer(new int[]{0, j});
            if (map[n - 1][j] == '.') queue.offer(new int[]{n - 1, j});
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            if (outsideConnected[x][y]) continue;
            outsideConnected[x][y] = true;

            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !outsideConnected[nx][ny] && map[nx][ny] == '.') {
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static void remove(char alpha) {
        char[][] newMap = new char[n][m];

        for (int i = 0; i < n; i++) {
            newMap[i] = map[i].clone();
        }

        // **외곽 또는 외곽과 연결된 `.`에 접한 컨테이너 제거**
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == alpha) {
                    // 1. 테두리에 있는 경우 제거
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        newMap[i][j] = '.';
                        continue;
                    }
                    // 2. 외곽과 연결된 `.`과 접한 경우 제거
                    for (int[] d : directions) {
                        int nx = i + d[0], ny = j + d[1];
                        if (outsideConnected[nx][ny]) {
                            newMap[i][j] = '.';
                            break;
                        }
                    }
                }
            }
        }

        map = newMap;
    }

    private void removeAll(char alpha) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == alpha) {
                    map[i][j] = '.';
                }
            }
        }
    }

    private int countContainers() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '.') count++;
            }
        }
        return count;
    }
}
