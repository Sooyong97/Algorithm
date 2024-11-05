import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
     
     private static void move(int[][] map) {
        int n = map.length;
 
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] == 1) {
                    int k = i;
                    while (k + 1 < n && map[k + 1][j] == 0) {
                        map[k + 1][j] = 1;
                        map[k][j] = 0;
                        k++;
                    }
                    if (k + 1 == n) {
                        map[k][j] = 0;
                    }
                }
            }
        }
 
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (map[i][j] == 2) {
                    int k = i;
                    while (k - 1 >= 0 && map[k - 1][j] == 0) {
                        map[k - 1][j] = 2;
                        map[k][j] = 0;
                        k--;
                    }
                    if (k - 1 < 0) {
                        map[k][j] = 0;
                    }
                }
            }
        }
    }
 
    private static int check(int[][] map) {
        int n = map.length;
        int count = 0;
 
        for (int j = 0; j < n; j++) {
            boolean foundOne = false;
            for (int i = 0; i < n; i++) {
                if (map[i][j] == 1) {
                    foundOne = true;
                } else if (map[i][j] == 2 && foundOne) {
                    count++;
                    foundOne = false;
                }
            }
        }
        return count;
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            move(map);
            int result = check(map);
            System.out.println("#"+ test_case + " " + result);
 
        }
    }
}