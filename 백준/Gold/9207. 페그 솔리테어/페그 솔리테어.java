import java.io.*;

public class Main {

    static char[][] map = new char[5][9];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minPin;
    static int minMove;

    private static void solve(int maxPin) {
        minPin = maxPin;
        minMove = 0;

        dfs(map, maxPin, 0);

        System.out.println(minPin + " " + minMove);
    }

    private static void dfs(char[][] mapP, int p, int moves) {
        boolean moved = false;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (mapP[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        int nnx = nx + dx[k];
                        int nny = ny + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 5 || ny >= 9) continue;
                        if (nnx < 0 || nny < 0 || nnx >= 5 || nny >= 9) continue;
                        if (mapP[nx][ny] != 'o' || mapP[nnx][nny] != '.') continue;

                        mapP[i][j] = '.'; 
                        mapP[nx][ny] = '.'; 
                        mapP[nnx][nny] = 'o';
                        
                        dfs(mapP, p - 1, moves + 1);
                        
                        mapP[i][j] = 'o'; 
                        mapP[nx][ny] = 'o'; 
                        mapP[nnx][nny] = '.';
                        
                        moved = true;
                    }
                }
            }
        }
        
        if (!moved) {
            if (p < minPin) {
                minPin = p;
                minMove = moves;
            } else if (p == minPin) {
                minMove = Math.min(minMove, moves);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc > 0) {
            int maxPin = 0;

            for (int i = 0; i < 5; i++) {
                String s = br.readLine();
                for (int j = 0; j < 9; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == 'o') {
                        maxPin++;
                    }
                }
            }

            solve(maxPin);

            if (tc > 1) {
                br.readLine();
            }
            tc--;
        }
    }
}