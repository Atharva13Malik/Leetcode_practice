class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        Stack<Integer> stk = new Stack<>();

        int[] nse = new int[n];
        int[] pse = new int[n];

        long sum = 0;
        int mod = 1000000007;

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) nse[i] = n;
            else nse[i] = stk.peek();

            stk.push(i);
        }

        stk.clear();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) pse[i] = -1;
            else pse[i] = stk.peek();

            stk.push(i);
        }

        // Contribution Technique
        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            sum = (sum + (arr[i] * left * right) % mod) % mod;
        }

        return (int) sum;
    }
}
