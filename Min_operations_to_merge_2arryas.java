class Solution {
    int minSwap(int[] arr, int k) {

        int good = 0;
        int bad = 0;

        for (int x : arr) {
            if (x <= k) good++;
        }

        for (int i = 0; i < good; i++) {
            if (arr[i] > k) bad++;
        }

        int left = 0;
        int right = good;
        int ans = bad;

        while (right < arr.length) {

            if (arr[right] > k) bad++;
            if (arr[left] > k) bad--;

            ans = Math.min(ans, bad);

            left++;
            right++;
        }

        return ans;
    }
}
