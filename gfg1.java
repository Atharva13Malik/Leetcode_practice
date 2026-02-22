class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

       int i = 0;
       int j = 0;

       while (j < n) {

    if ((j - i + 1) < k) {
        j++;
    }

    else if ((j - i + 1) == k) {

        boolean found = false;   

        for (int x = i; x <= j; x++) {
            if (arr[x] < 0) {
                list.add(arr[x]);
                found = true;
                break;           
            }
        }

        if (!found) {
            list.add(0);
        }

        i++;
        j++;
    }
}

return list;
    }
}
