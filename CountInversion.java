class Solution {

    static long inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static long mergeSort(int[] arr, int l, int r) {

        long count = 0;

        if (l < r) {

            int mid = l + (r - l) / 2;

            // Left half
            count += mergeSort(arr, l, mid);

            // Right half
            count += mergeSort(arr, mid + 1, r);

            // Merge + count inversions
            count += merge(arr, l, mid, r);
        }

        return count;
    }

    static long merge(int[] arr, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= r) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }

            else {
                temp[k++] = arr[j++];

                // Main inversion logic
                count += (mid - i + 1);
            }
        }

        // Remaining left elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Remaining right elements
        while (j <= r) {
            temp[k++] = arr[j++];
        }

        // Copy temp back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }

        return count;
    }
}
