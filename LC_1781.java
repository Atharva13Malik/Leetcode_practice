class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                // Update frequency
                freq[s.charAt(j) - 'a']++;

                int max = getMax(freq);
                int min = getMin(freq);

                ans += (max - min);
            }
        }

        return ans;
    }

    private int getMax(int[] freq) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, freq[i]);
        }
        return max;
    }

    private int getMin(int[] freq) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {   // Ignore zero frequency
                min = Math.min(min, freq[i]);
            }
        }

        return min;
    }
}
