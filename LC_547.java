class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                bfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    public void bfs(int i, int[][] isConnected, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[i] = true;
        q.add(i);

        int n = isConnected.length;

        while (!q.isEmpty()) {

            int node = q.remove();

            for (int j = 0; j < n; j++) {

                if (isConnected[node][j] == 1 && !visited[j]) {

                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}
