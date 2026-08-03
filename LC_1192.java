class Solution {

    int timer = 0;
    int[] disc;
    int[] low;
    boolean[] visited;

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> adj = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // Build Adjacency List
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];

        // Handle disconnected graph also
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }

        return result;
    }

    void dfs(int node, int parent) {

        visited[node] = true;

        disc[node] = timer;
        low[node] = timer;
        timer++;

        for (int neighbour : adj.get(node)) {

            // Ignore the edge to parent
            if (neighbour == parent)
                continue;

            // Tree Edge
            if (!visited[neighbour]) {

                dfs(neighbour, node);

                low[node] = Math.min(low[node], low[neighbour]);

                // Bridge Found
                if (low[neighbour] > disc[node]) {
                    result.add(Arrays.asList(node, neighbour));
                }

            }
            // Back Edge
            else {

                low[node] = Math.min(low[node], disc[neighbour]);

            }
        }
    }
}
