class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        int alreadySatisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alreadySatisfied += customers[i];
            }
        }

        int sum = 0;
        int max = 0;

        for (int j = 0; j < n; j++) {

            sum += customers[j] * grumpy[j];

            if (j >= minutes) {
                sum -= customers[j - minutes] * grumpy[j - minutes];
            }

            max = Math.max(max, sum);
        }

        return alreadySatisfied + max;
    }
}
