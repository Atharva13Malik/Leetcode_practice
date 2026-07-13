class Solution {
    Integer[][] dp;

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int m = cuts.length;
        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 1; i <= m; i++) {
            arr[i] = cuts[i - 1];
        }

        dp = new Integer[m + 2][m + 2];

        return cost(1, m, arr);
    }

    private int cost(int i, int j, int[] arr) {
        if (i > j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int currCost = arr[j + 1] - arr[i - 1];

            int left = cost(i, k - 1, arr);
            int right = cost(k + 1, j, arr);

            ans = Math.min(ans, currCost + left + right);
        }

        return dp[i][j] = ans;
    }
}
