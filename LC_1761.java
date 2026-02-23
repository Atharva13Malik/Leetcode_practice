import java.util.*;

class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;

        // LIS from left
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // LDS from right
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // valid peak
            if (dp1[i] > 1 && dp2[i] > 1) {
                int len = dp1[i] + dp2[i] - 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return n - maxLen;
    }
}
