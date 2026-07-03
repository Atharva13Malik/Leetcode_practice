class Solution {
    public void segregateElements(int[] arr) {

        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;

        // Store all non-negative elements
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp[j++] = arr[i];
            }
        }

        // Store all negative elements
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                temp[j++] = arr[i];
            }
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
