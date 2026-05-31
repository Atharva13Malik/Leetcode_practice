class Solution {
    static boolean ans;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        ans = true;

        for(int i = 0; i < n; i++) {
            if(visited[i] == -1) {
                bfs(i, graph, visited);

                if(!ans) return false;
            }
        }

        return true;
    }

    public void bfs(int src, int[][] graph, int[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[src] = 0;
        q.add(src);

        while(!q.isEmpty()) {

            int front = q.remove();

            for(int ele : graph[front]) {

                if(visited[ele] == -1) {
                    visited[ele] = 1 - visited[front];
                    q.add(ele);
                }
                else if(visited[ele] == visited[front]) {
                    ans = false;
                    return;
                }
            }
        }
    }
}
