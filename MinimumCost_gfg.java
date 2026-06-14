import java.util.*;

class Solution {

    static class Pair {
        int x, y, cost;

        Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int minimumCostPath(int[][] grid) {

        int n = grid.length;

        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[0][0] = grid[0][0];
        pq.offer(new Pair(0, 0, grid[0][0]));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if (cost > dist[x][y])
                continue;

            if (x == n - 1 && y == n - 1)
                return cost;

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n) {

                    int newCost = cost + grid[nx][ny];

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Pair(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}
