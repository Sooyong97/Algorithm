import java.util.*;

class Solution {
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] l : links) {
            tree.get(l[0] - 1).add(l[1] - 1);
        }

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        dfs(0, tree, sales, dp);

        return Math.min(dp[0][0], dp[0][1]);
    }

    private void dfs(int u, List<List<Integer>> tree, int[] sales, int[][] dp) {
        if (dp[u][0] != -1) return;

        int costAttend = sales[u];
        int costNotAttend = 0;

        boolean mustAttendOne = true;
        int minExtra = Integer.MAX_VALUE;

        for (int v : tree.get(u)) {
            dfs(v, tree, sales, dp);

            costAttend += Math.min(dp[v][0], dp[v][1]);

            int choose = Math.min(dp[v][0], dp[v][1]);
            costNotAttend += choose;

            if (dp[v][1] <= dp[v][0]) {
                mustAttendOne = false;
            } else {
                minExtra = Math.min(minExtra, dp[v][1] - dp[v][0]);
            }
        }

        if (mustAttendOne && tree.get(u).size() > 0) {
            costNotAttend += minExtra;
        }

        dp[u][0] = costNotAttend;
        dp[u][1] = costAttend;
    }
}
