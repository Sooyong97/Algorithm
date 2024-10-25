import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    static void combination(List<int[]> chicken, boolean[] visited, int start, int n, int r, List<List<int[]>> selectedCombinations) {
        if (r == 0) {
            List<int[]> selected = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    selected.add(chicken.get(i));
                }
            }
            selectedCombinations.add(selected);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(chicken, visited, i + 1, n, r - 1, selectedCombinations);
            visited[i] = false;
        }
    }

    static int calculateCityChickenDistance(List<int[]> houses, List<int[]> selectedChickens) {
        int totalDistance = 0;
        
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens) {
                int dist = distance(house, chicken);
                minDistance = Math.min(minDistance, dist);
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] maps = new int[N][N];

        List<int[]> house = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maps[i][j] = scanner.nextInt();
                if (maps[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (maps[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        scanner.close();

        List<List<int[]>> selectedCombinations = new ArrayList<>();
        boolean[] visited = new boolean[chicken.size()];
        combination(chicken, visited, 0, chicken.size(), M, selectedCombinations);

        int minDistance = Integer.MAX_VALUE;
        for (List<int[]> selectedChickens : selectedCombinations) {
            int cityDistance = calculateCityChickenDistance(house, selectedChickens);
            minDistance = Math.min(minDistance, cityDistance);
        }

        System.out.println(minDistance);
    }
}