class Solution {

    public int[] minOperations(String boxes) {

        int n = boxes.length();

        int[] ans = new int[n];

        int balls = 0;
        int moves = 0;

        // Left to Right
        for (int i = 0; i < n; i++) {

            ans[i] = moves;

            if (boxes.charAt(i) == '1')
                balls++;

            moves += balls;
        }

        balls = 0;
        moves = 0;

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {

            ans[i] += moves;

            if (boxes.charAt(i) == '1')
                balls++;

            moves += balls;
        }

        return ans;
    }
}
