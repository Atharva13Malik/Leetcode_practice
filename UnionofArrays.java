class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        int i = 0, j = 0;
        int n1 = a.length, n2 = b.length;

        ArrayList<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2) {

            if (a[i] == b[j]) {
                if (list.size() == 0 || list.get(list.size() - 1) != a[i])
                    list.add(a[i]);
                i++;
                j++;
            }
            else if (a[i] < b[j]) {
                if (list.size() == 0 || list.get(list.size() - 1) != a[i])
                    list.add(a[i]);
                i++;
            }
            else {
                if (list.size() == 0 || list.get(list.size() - 1) != b[j])
                    list.add(b[j]);
                j++;
            }
        }

        while (i < n1) {
            if (list.size() == 0 || list.get(list.size() - 1) != a[i])
                list.add(a[i]);
            i++;
        }

        while (j < n2) {
            if (list.size() == 0 || list.get(list.size() - 1) != b[j])
                list.add(b[j]);
            j++;
        }

        return list;
    }
}
