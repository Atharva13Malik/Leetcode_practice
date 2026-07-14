class Solution {
    public int minFallingPathSum(int[][] matrix) {

    int n = matrix.length;

    int[][] dp = new int[n][n];

    for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
    }

    int ans = Integer.MAX_VALUE;

    for(int j=0;j<n;j++){
        ans = Math.min(ans, solve(0,j,dp,matrix));
    }

    return ans;
}
    public int solve(int i, int j, int[][] dp, int[][] matrix){

    int n = matrix.length;

    if(j < 0 || j >= n)
        return (int)1e9;

    if(i == n - 1)
        return matrix[i][j];

    if(dp[i][j] != -1)
        return dp[i][j];

    int left  = solve(i + 1, j - 1, dp, matrix);

    int down  = solve(i + 1, j, dp, matrix);

    int right = solve(i + 1, j + 1, dp, matrix);

    return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
}
}
