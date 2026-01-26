public int maxSubarraySumCircular(int[] nums) {
    int totalSum = 0;
    for (int x : nums) {
        totalSum += x;
    }

    int currMax = nums[0];
    int maxKadane = nums[0];
    for (int i = 1; i < nums.length; i++) {
        currMax = Math.max(nums[i], currMax + nums[i]);
        maxKadane = Math.max(maxKadane, currMax);
    }

    for (int i = 0; i < nums.length; i++) {
        nums[i] = -nums[i];
    }

    int currMin = nums[0];
    int maxOnInverted = nums[0];
    for (int i = 1; i < nums.length; i++) {
        currMin = Math.max(nums[i], currMin + nums[i]);
        maxOnInverted = Math.max(maxOnInverted, currMin);
    }

    int minKadane = -maxOnInverted;

    if (maxKadane < 0) {
        return maxKadane;
    }

    return Math.max(maxKadane, totalSum - minKadane);
}
