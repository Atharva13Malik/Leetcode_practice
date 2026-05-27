class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // create empty lists
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // build graph
        for(int[] e : edges) {

            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // bfs
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()) {

            int node = q.remove();

            if(node == destination) {
                return true;
            }

            for(int nei : adj.get(node)) {

                if(!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }

        return false;
    }
}
