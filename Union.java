class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            int val;

            if (a[i] < b[j]) {
                val = a[i++];
            }
            else if (a[i] > b[j]) {
                val = b[j++];
            }
            else {
                val = a[i];
                i++;
                j++;
            }

            if (!list.contains(val))
                list.add(val);
        }

        while (i < a.length) {
            if (!list.contains(a[i]))
                list.add(a[i]);

            i++;
        }

        while (j < b.length) {
            if (!list.contains(b[j]))
                list.add(b[j]);

            j++;
        }

        return list;
    }
}
