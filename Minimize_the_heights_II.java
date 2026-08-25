import java.util.Arrays;

class Solution {
    public int getMinDiff(int[] arr, int k) {

        Arrays.sort(arr);

        int n = arr.length;
        int min = arr[n - 1] - arr[0];

        int longheight;
        int shortheight;

        for (int i = 0; i < n - 1; i++) {

            // Height negative nahi ho sakti
            if (arr[i + 1] - k < 0)
                continue;

            longheight = Math.max(
                arr[n - 1] - k,
                arr[i] + k
            );

            shortheight = Math.min(
                arr[0] + k,
                arr[i + 1] - k
            );

            min = Math.min(min, longheight - shortheight);
        }

        return min;
    }
}
