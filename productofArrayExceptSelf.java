class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = multiply(nums, i);
        }

        return result;
    }

    public int multiply(int[] arr, int idx) {
        long product = 1;

        for (int j = 0; j < arr.length; j++) {
            if (j != idx) {
                product *= arr[j];
            }
        }

        return (int) product;
    }
}
