class Solution {

    class Pair {
        int node;
        int direction;

        Pair(int node, int direction) {
            this.node = node;
            this.direction = direction;
        }
    }

    int changes = 0;

    public int minReorder(int n, int[][] connections) {

        List<Pair>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            adj[u].add(new Pair(v, 1)); // original direction
            adj[v].add(new Pair(u, 0)); // reverse direction (only for traversal)
        }

        boolean[] visited = new boolean[n];

        dfs(0, adj, visited);

        return changes;
    }

    private void dfs(int curr, List<Pair>[] adj, boolean[] visited) {

        visited[curr] = true;

        for (Pair neighbour : adj[curr]) {

            if (!visited[neighbour.node]) {

                changes += neighbour.direction;

                dfs(neighbour.node, adj, visited);
            }
        }
    }
}
