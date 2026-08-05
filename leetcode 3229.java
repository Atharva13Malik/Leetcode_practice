class Solution {
    public long minimumOperations(int[] nums, int[] target) {

        int diff[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            diff[i] = target[i] - nums[i];
        }

        long ans = Math.abs((long) diff[0]);

        for (int i = 1; i < nums.length; i++) {

            if ((diff[i] > 0) != (diff[i - 1] > 0)) {
                ans += Math.abs((long) diff[i]);
            } else {
                ans += Math.max(0L,
                        Math.abs((long) diff[i]) - Math.abs((long) diff[i - 1]));
            }
        }

        return ans;
    }
}
