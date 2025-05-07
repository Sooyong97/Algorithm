import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int blindSpot = Integer.MAX_VALUE;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    q.add(new int[]{i, j});
                }
            }
        }

        solve(map, q);
    }

    static void solve(int[][] map, Queue<int[]> q) {
        if (q.isEmpty()) {
            System.out.println(findBlindSpot(map));
            return;
        }
        int[] camera = q.poll();
        dfs(map, camera, q);
        System.out.println(blindSpot);
    }

    static void dfs(int[][] map, int[] camera, Queue<int[]> q) {
        List<int[][]> maps = ableMaps(map, camera);

        if (q.isEmpty()) {
            for (int[][] nextMap : maps) {
                blindSpot = Math.min(blindSpot, findBlindSpot(nextMap));
            }
            return;
        }

        int[] nextCamera = q.poll();

        for (int[][] nextMap : maps) {
            Queue<int[]> nextQ = new LinkedList<>(q);
            dfs(nextMap, nextCamera, nextQ);
        }
    }

    //카메라 별 감시 가능 맵
    static List<int[][]> ableMaps(int[][] map, int[] camera) {
        List<int[][]> maps = new ArrayList<>();
        int cameraNum = map[camera[0]][camera[1]];

        if (cameraNum == 1) {
            for (int i = 0; i < 4; i++) {
                maps.add(camera1(map, camera, i));
            }
        }
        if (cameraNum == 2) {
            for (int i = 0; i < 2; i++) {
                maps.add(camera2(map, camera, i));
            }
        }
        if (cameraNum == 3) {
            for (int i = 0; i < 4; i++) {
                maps.add(camera3(map, camera, i));
            }
        }
        if (cameraNum == 4) {
            for (int i = 0; i < 4; i++) {
                maps.add(camera4(map, camera, i));
            }
        }
        if (cameraNum == 5) {
            maps.add(camera5(map, camera));
        }

        return maps;
    }

    //Map 복사
    static int[][] cloneMap(int[][] map) {
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            cloneMap[i] = map[i].clone();
        }
        return cloneMap;
    }

    //1번 카메라
    static int[][] camera1(int[][] map, int[] camera, int direction) {
        int[][] map1 = cloneMap(map);
        int x = camera[0];
        int y = camera[1];

        int[] d = dir[direction];

        checkPlace(map1, x, y, d);

        return map1;
    }

    //2번 카메라
    static int[][] camera2(int[][] map, int[] camera, int direction) {
        int[][] map2 = cloneMap(map);
        int x = camera[0];
        int y = camera[1];

        int[] d1 = dir[direction];
        int[] d2 = dir[direction + 2];

        checkPlace(map2, x, y, d1);
        checkPlace(map2, x, y, d2);

        return map2;
    }

    //3번 카메라
    static int[][] camera3(int[][] map, int[] camera, int direction) {
        int[][] map3 = cloneMap(map);
        int x = camera[0];
        int y = camera[1];

        int[] d1 = dir[direction];
        int[] d2 = dir[(direction + 1) % 4];

        checkPlace(map3, x, y, d1);
        checkPlace(map3, x, y, d2);

        return map3;
    }

    // 4번 카메라
    static int[][] camera4(int[][] map, int[] camera, int direction) {
        int[][] map4 = cloneMap(map);
        int x = camera[0];
        int y = camera[1];

        int[] d1 = dir[direction];
        int[] d2 = dir[(direction + 1) % 4];
        int[] d3 = dir[(direction + 2) % 4];

        checkPlace(map4, x, y, d1);
        checkPlace(map4, x, y, d2);
        checkPlace(map4, x, y, d3);

        return map4;
    }

    //5번 카메라
    static int[][] camera5(int[][] map, int[] camera) {
        int[][] map5 = cloneMap(map);
        int x = camera[0];
        int y = camera[1];

        for (int[] d : dir) {
            checkPlace(map5, x, y, d);
        }

        return map5;
    }

    //감시
    static void checkPlace(int[][] map, int x, int y, int[] dir) {
        int nx = x + dir[0];
        int ny = y + dir[1];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) map[nx][ny]--;
            nx += dir[0];
            ny += dir[1];
        }
    }

    //사각지대 찾기
    static int findBlindSpot(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}
