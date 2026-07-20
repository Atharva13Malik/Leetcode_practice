import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] ans = new int[n];

        int i = 0;
        int k = 0;
        long time = 0;

        while (i < n || !pq.isEmpty()) {

            if (pq.isEmpty()) {
                time = Math.max(time, arr[i][0]);
            }

            while (i < n && arr[i][0] <= time) {
                pq.offer(new int[]{arr[i][1], arr[i][2]});
                i++;
            }

            int[] curr = pq.poll();

            ans[k++] = curr[1];

            time += curr[0];
        }

        return ans;
    }
}
