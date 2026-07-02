class Solution {
    int missingNum(int arr[]) {
        int n = arr.length+1;  // +1 vo number jo missing h 

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        int expected = (n ) * (n +1) / 2;

        return expected - sum;
    }
}
