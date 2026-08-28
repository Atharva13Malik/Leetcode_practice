class Solution {
    static int minOps(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {

            if (arr[left] == arr[right]) {
                left++;
                right--;
            }

            else if (arr[left] < arr[right]) {
                arr[left + 1] += arr[left];
                left++;
                count++;
            }

            else {
                arr[right - 1] += arr[right];
                right--;
                count++;
            }
        }

        return count;
    }
}
