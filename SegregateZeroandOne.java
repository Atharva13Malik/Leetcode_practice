class Solution {
    void segregate0and1(int[] arr) {

        int numzero = 0;

        for (int x : arr) {
            if (x == 0)
                numzero++;
        }

        for (int i = 0; i < numzero; i++) {
            arr[i] = 0;
        }

        for (int i = numzero; i < arr.length; i++) {
            arr[i] = 1;
        }
    }
}
