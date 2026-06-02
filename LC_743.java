class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap for Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, k});   // {distance, node}

        // Dijkstra Algorithm
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currDist = top[0];
            int node = top[1];

            if (currDist > dist[node]) continue;

            for (int[] edge : adj.get(node)) {
                int nei = edge[0];
                int wt = edge[1];
                int newDist = currDist + wt;

                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    pq.offer(new int[]{newDist, nei});
                }
            }
        }

        // Find max distance
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
