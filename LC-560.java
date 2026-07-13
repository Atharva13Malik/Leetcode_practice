class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 ek baar pehle se exist karta hai
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            // Current prefix sum
            sum += num;

            // Agar (sum - k) pehle aaya hai,
            // to utni subarrays mil gayi
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Current prefix sum ki frequency update karo
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
