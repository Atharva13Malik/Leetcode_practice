class Solution {

    int n, m;
    int[][] dp;

    public int dfs(int[][] matrix, int i, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {

            int ni = i + dr[k];
            int nj = j + dc[k];

            if (ni >= 0 && ni < n &&
                nj >= 0 && nj < m &&
                matrix[ni][nj] > matrix[i][j]) {

                int length = 1 + dfs(matrix, ni, nj);

                ans = Math.max(ans, length);
            }
        }

        dp[i][j] = ans;

        return ans;
    }

    public int longestIncreasingPath(int[][] matrix) {

        n = matrix.length;
        m = matrix[0].length;

        dp = new int[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }
}
