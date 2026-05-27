class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        visited[0] = true;

        q.add(0);

        while (!q.isEmpty()) {

            int node = q.remove();

            for (int key : rooms.get(node)) {

                if (!visited[key]) {

                    visited[key] = true;

                    q.add(key);
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                return false;
            }
        }

        return true;
    }
}
