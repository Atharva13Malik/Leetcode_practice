class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        // odd sum cannot be divided
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][target + 1];

        return solve(0, target, nums, dp);
    }

    private boolean solve(int i, int sum, int[] nums, Boolean[][] dp) {
        // base cases
        if (sum == 0) return true;
        if (i == nums.length) return false;

        // memo check
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // skip
        boolean skip = solve(i + 1, sum, nums, dp);

        // take
        boolean take = false;
        if (nums[i] <= sum) {
            take = solve(i + 1, sum - nums[i], nums, dp);
        }

        // store & return
        dp[i][sum] = take || skip;
        return dp[i][sum];
    }
}
