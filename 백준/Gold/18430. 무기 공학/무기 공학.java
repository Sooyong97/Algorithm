import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int maxStrength = 0;
    
    static int[][][] shapes = {
        {{0, 0}, {0, -1}, {1, 0}},  // ┘ 모양
        {{0, 0}, {0, -1}, {-1, 0}}, // ┐ 모양
        {{0, 0}, {0, 1}, {-1, 0}},  // ┌ 모양
        {{0, 0}, {0, 1}, {1, 0}}    // └ 모양
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backtrack(0, 0, 0);
        
        System.out.println(maxStrength);
    }
    
    static void backtrack(int row, int col, int currentStrength) {
        if (col == M) {
            row++;
            col = 0;
        }
        
        if (row == N) {
            maxStrength = Math.max(maxStrength, currentStrength);
            return;
        }
        

        backtrack(row, col + 1, currentStrength);

        for (int s = 0; s < 4; s++) {
            if (canPlaceBoomerang(row, col, s)) {
                int strength = placeBoomerang(row, col, s, true);
                
                backtrack(row, col + 1, currentStrength + strength);

                placeBoomerang(row, col, s, false);
            }
        }
    }
    
    static boolean canPlaceBoomerang(int row, int col, int shapeIndex) {
        for (int i = 0; i < 3; i++) {
            int nr = row + shapes[shapeIndex][i][0];
            int nc = col + shapes[shapeIndex][i][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
                return false;
            }
        }
        return true;
    }
    
    static int placeBoomerang(int row, int col, int shapeIndex, boolean place) {
        int strength = 0;
        
        for (int i = 0; i < 3; i++) {
            int nr = row + shapes[shapeIndex][i][0];
            int nc = col + shapes[shapeIndex][i][1];
            
            visited[nr][nc] = place;
            
            if (i == 0) {
                strength += grid[nr][nc] * 2;
            } else {
                strength += grid[nr][nc];
            }
        }
        
        return strength;
    }
}