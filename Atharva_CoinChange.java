class Solution {
    public int coinChange(int[] coins, int amount) {

        long dp[][] = new long[coins.length][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        long ans = helper(0, coins, amount, dp);

        if (ans >= 1e9) return -1;
        return (int) ans;
    }

    public long helper(int i, int[] coins, int amount, long[][] dp) {

        if (amount == 0) return 0;

        if (i == coins.length) return (long) 1e9;

        if (dp[i][amount] != -1) return dp[i][amount];

        long skip = helper(i + 1, coins, amount, dp);

        long pick = (long) 1e9;
        if (amount >= coins[i]) {
            pick = 1 + helper(i, coins, amount - coins[i], dp);
        }

        return dp[i][amount] = Math.min(skip, pick);
    }
}
