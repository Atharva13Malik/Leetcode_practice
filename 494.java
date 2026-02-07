lass Solution {
    int sum;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for (int ele : nums) sum += ele;

        int dp[][] = new int[n][2 * sum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(nums, 0,0, target, dp);
    }

    private int helper(int[] nums, int i,int res, int target, int[][] dp) {
        if (i == nums.length) {
            if(res==target)  return 1;
            else return 0;
        }

        int idx = res + sum; 
        if (dp[i][idx] != -1) return dp[i][idx];

        int add = helper(nums, i + 1, res-nums[i],target, dp);
        int sub = helper(nums, i + 1, res+nums[i],target, dp);

        dp[i][idx] = add + sub; 
        return dp[i][idx];
    }
}
