class Solution {

    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {

        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        int count = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(count);
                ans.add(temp);

                count = 1;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[n - 1]);
        temp.add(count);
        ans.add(temp);

        return ans;
    }
}
